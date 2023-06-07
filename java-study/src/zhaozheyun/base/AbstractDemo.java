package com.zhaozheyun.base;

import java.math.BigDecimal;

//        编写一个Employee类，声明为抽象类，
//        包含如下三个属性：name，id，salary。
//        提供必要的构造器和抽象方法：work()。
//        对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
//        请使用继承的思想，设计CommonEmployee类和Manager类，要求类
//        中提供必要的方法进行属性访问。
abstract class CommonEmployee {
    private String name;
    private Integer id;
    private BigDecimal salary;

    public CommonEmployee() {

    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

class Manager extends CommonEmployee {
    BigDecimal bonus;

    public void work() {

    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }
}

public class AbstractDemo {
    public static void main(String[] args) {

    }
}
