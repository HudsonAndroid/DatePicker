# DatePicker
支持各类组合形式的DatePicker，当前提供好的组合形式有：

#### 年类型 YearType
      year - month - day - hour - minute
      year - month - day - hour
      year - month - day
      year - month
      year
#### 月类型 MonthType
      month - day
      month
#### 时类型 HourType
      hour - minute
      hour
#### 其他不常用类型没有写，如果需要可以快速拓展(见下方的快速拓展指引)。

# Usage
### 一 依赖
#### 1.在项目的根目录的build.gradle添加repositories
      maven { url 'https://jitpack.io' }
#### 2.在需要依赖DatePicker的module中的build.gradle的dependencies中添加依赖
      implementation 'com.github.HudsonAndroid:DatePicker:1.0.1'
      //DatePicker 依赖 WheelView （如果studio提示找不到WheelView，把下面的依赖也加上）
      //implementation 'com.github.HudsonAndroid:WheelView:1.0.1'
### 二 基础构建
#### 1.创建年类型日期选择器
     //to create year type DatePicker
      DatePickerCreator.createYearDatePicker(YearType type, LinearLayout parent,int startYear, int endYear);
##### 参数说明：
      type: 需要创建的年类型的具体类型，枚举类型
      parent: 用于承载DatePicker的父容器，必须是LinearLayout
      startYear和endYear: 可供选择的年份的范围，由于year参数可以有很多，因此需要给出具体限定的选择范围
#### 2.创建月类型日期选择器      
      //to create month type DatePicker
      DatePickerCreator.createMonthDatePicker(MonthType type,LinearLayout parent,int targetYear);
##### 参数说明：
      type: 需要创建的月类型的具体类型，枚举类型
      parent: 用于承载DatePicker的父容器，必须是LinearLayout
      targetYear: 指定月类型选择器的年份，用于在二月份情况下，判断闰年情况，以决定day展示的形式
#### 3.创建时类型日期选择器            
      //to create hour type DatePicker
      DatePickerCreator.createHourDatePicker(HourType type,LinearLayout parent);
##### 参数说明：同上，略
### 三 其他方法说明
#### 1.配置滚轮的属性
      DatePickerCreator.setConfig(@NonNull WheelViewConfig config);
 
 该WheelViewConfig源自依赖的组件<a href="https://github.com/HudsonAndroid/WheelView">WheelView<a/>。
      
#### 2.配置默认的选中日期
      //mDatePicker is an instance of IDatePicker
       mDatePicker.setDefaultDate(new Date(2019,9,8,16,0));
      
#### 3.获取选中的日期结果
      //mDatePicker is an instance of IDatePicker
      Date date = mDatePicker.getDate();
### 四 快速拓展指引
正如上面描述，我们可以通过DatePickerCreator来构建相关的时间选择器，但是内部提供的相关方法是由我这边写死的，虽然包括了我们常见的情形，但是不可避免的存在一些问题，包括：

      1）一些上面没有包含的场景
      2）如果我需要在滚轮之间加入其他元素，例如上面的方法中仅仅是单纯的显示滚轮，我需要加上“年”、“月”、“日”等的单位时，上面无法满足等
      因此，有必要我们自行拓展。
如果需要拓展的话，其实可以参考DatePickerCreator内部的枚举类型initDatePicker方法，因为基本逻辑都是类似如下（以年份选择器为例）：

       // Year cannot decorate others
       public IDatePicker initDatePicker(LinearLayout container,int startYear,int endYear) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            Context context = container.getContext();
            AbsWheelView year = new YearWheelView(context);
            year.setRange(startYear,endYear);
            year.setLayoutParams(params);
            container.addView(year);
            return year;
        }
        //Month decorate Year
        public IDatePicker initDatePicker(LinearLayout parent, int startYear, int endYear) {
            // use above code to create datePicker
            IDatePicker datePicker = TypeYearOnly.initDatePicker(parent, startYear, endYear);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT,1f);
            AbsWheelView month = new MonthWheelView(parent.getContext(),datePicker);
            month.setLayoutParams(params);
            parent.addView(month);
            return month;
        }
        
清楚了上述代码逻辑，基本上可以任意拓展了。当然，未必一定要使用LinearLayout，使用其他ViewGroup也行，但是LinearLayout更好处理点，原因是我们的WheelView都是通过代码方式new出来的（需要提示的是，所有提供的日期选择器WheelView类型都只能通过代码方式new出来，不允许通过布局文件方式，这样的目的是为了更好的拓展）。


 但需要注意的有以下几点：
 
      （1）你需要使用AbsWheelView来承载创建的DatePicker WheelView,这样才能通过addView方法加入到ViewGroup中
      （2）YearWheelView这里没有提供装饰其他滚轮的功能，因为它不应该是装饰其他滚轮
      （3）在使用YearWheelView的时候，你应该通过AbsWheelView的setRange(int min,int max)来设置选择的范围，否则该滚轮无法正常使用；在使用MonthWheelView的时候，你应该通过MonthWheelView的setTargetYear(int year)来设置月份选择器所属的年份（当然，如果MoonthWheelView有包裹YearWheelView的话，可以不用设置，内部有处理相关逻辑，就像上面代码那样。），目的是如果MonthWheelView有被DayWheelView包裹的时候，需要考虑到二月份的平闰年的问题。
# See More
##### 本DatePicker依赖<a href="https://github.com/HudsonAndroid/WheelView">WheelView<a/>组件，相关逻辑请跳转参考。
