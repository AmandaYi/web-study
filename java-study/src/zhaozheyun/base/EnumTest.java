package com.zhaozheyun.base;

enum NodeTypeEnum {
    BY_AIR("海运", "用于海上运输");


    private final String name;
    private final String desc;

    NodeTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        System.out.println(NodeTypeEnum.BY_AIR.getName());
    }

}
