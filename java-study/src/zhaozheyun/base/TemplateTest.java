package com.zhaozheyun.base;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import sun.util.calendar.BaseCalendar;

import java.math.BigDecimal;
import java.util.Date;

//    编写工资系统，实现不同类型员工(多态)的按月发放工资。如果当月出现某个
//    Employee对象的生日，则将该雇员的工资增加100元。
//    实验说明：
//    （1）定义一个Employee类，该类包含：
//    private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
//    abstract方法earnings()；
//    toString()方法输出对象的name,number和birthday。
//    （2）MyDate类包含:
//    private成员变量year,month,day ；
//    toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
//    （3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处
//    理。该类包括：private成员变量monthlySalary；
//    实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输
//    出员工类型信息及员工的name，number,birthday。
abstract class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    private MyDate birthday;

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    abstract public String earnings();

    public Employee(String name, Integer number, MyDate myDate) {
        this.setName(name);
        this.setNumber(number);
        this.setBirthday(myDate);
    }
}

class MyDate {
    private Integer year;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private Integer month;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    private Integer date;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String toDateString() {
        return this.getYear() + "年" + this.getMonth() + "月" + this.date + "日";
    }

    public MyDate(Integer year, Integer month, Integer date) {
        this.setYear(year);
        this.setMonth(month);
        this.setDate(date);
    }
}

//    （3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处
//    理。该类包括：private成员变量monthlySalary；
//    实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输
//    出员工类型信息及员工的name，number,birthday。
class SalariedEmployee extends Employee {
    private BigDecimal monthlySalary;

    public SalariedEmployee(String name, Integer number, MyDate myDate, BigDecimal monthlySalary) {
        super(name, number, myDate);
        this.monthlySalary = monthlySalary;
    }

    public String earnings() {
//        return this.monthlySalary.toString() + this.getNumber().toString();
        Integer m = 1;

        if (this.getBirthday().getMonth() == m) {
            this.monthlySalary = this.monthlySalary.add(new BigDecimal(100));
        }
        return this.monthlySalary.toString();
    }

    @Override
    public String toString() {
        return this.getName() + this.getName() + this.getBirthday();
    }

}

public class TemplateTest {
    public static void main(String[] args) {
        MyDate d = new MyDate(1995, 2, 1);
        SalariedEmployee salariedEmployee = new SalariedEmployee("小明", 1, d, new BigDecimal(100000));
        System.out.println(salariedEmployee.earnings());
    }
}
