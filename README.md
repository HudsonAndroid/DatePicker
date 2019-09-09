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
#### 其他不常用类型没有写，如果需要可以快速拓展。

# Usage
### 一 基础构建
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
### 二 其他方法说明
#### 1.配置滚轮的属性
      DatePickerCreator.setConfig(@NonNull WheelViewConfig config);
 
 该WheelViewConfig源自依赖的组件<a href="https://github.com/HudsonAndroid/WheelView">WheelView<a/>。
      
#### 2.配置默认的选中日期
      //mDatePicker is an instance of IDatePicker
       mDatePicker.setDefaultDate(new Date(2019,9,8,16,0));
      
#### 3.获取选中的日期结果
      //mDatePicker is an instance of IDatePicker
      Date date = mDatePicker.getDate();
      
# See More
##### 本DatePicker依赖<a href="https://github.com/HudsonAndroid/WheelView">WheelView<a/>组件，相关逻辑请跳转参考。
