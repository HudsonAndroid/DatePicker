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
      DatePickerCreator.createYearDatePicker();//to create year type DatePicker
      DatePickerCreator.createMonthDatePicker();//to create month type DatePicker
      DatePickerCreator.createHourDatePicker();//to create hour type DatePicker
# See More
##### 本DatePicker依赖<a href="https://github.com/HudsonAndroid/WheelView">WheelView<a/>组件，相关逻辑请跳转参考。
