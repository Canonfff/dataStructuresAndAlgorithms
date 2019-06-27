package com.canon.base.class_one;

import com.canon.testeunm.HouseRoomChangeTypeEnum;

public class TestFive {

    public static void main(String[] args) {
        System.out.println(get(HouseRoomChangeTypeEnum.LEASE_SAVE));
    }
    public static String get(HouseRoomChangeTypeEnum typeEnum){
        System.out.println(typeEnum.name());
        return typeEnum.toString();
    }
}
