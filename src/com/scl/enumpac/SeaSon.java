package com.scl.enumpac;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 9:28
 */
public enum SeaSon {
    SPRING(1, "春"), SUMMER(2, "夏"), AUTUMN(3, "秋"), WINNER(4, "冬"), HELLO(5, "哈哈");
    Integer code;
    String name;

    SeaSon(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public static SeaSon getSeasonByCode(Integer code) {
        SeaSon[] values = SeaSon.values();
        for (SeaSon value : values) {
            if (code == value.getCode()) {
                return value;
            }
        }
        return null;
    }

   /* public static void main(String[] args) {
        System.out.println(SeaSon.getSeasonByCode(1));
        System.out.println(SeaSon.getSeasonByCode(1).getName());
    }*/

}



