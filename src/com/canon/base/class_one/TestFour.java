package com.canon.base.class_one;

public class TestFour {

    public static void main(String[] args) {
        get(3);
    }
    public static void get(int n) {
        switch (n) {
            case 1 :
                System.out.println("1");
                break;
            case 2 :
                System.out.println("2");
                break;
            case 5 :
            case 6 :
            case 7 :
            case 9 :
            case 10 :
                System.out.println("10");
                break;
            case 11 :
                System.out.println("11");
                break;
            case 12 :
                System.out.println("12");
                break;
            case 8 :
                System.out.println("8");
                break;
            default:
                break;
        }
    }
}
