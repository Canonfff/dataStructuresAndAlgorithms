package com.canon.base.class_four;

/**
 * @Author Canon
 * @Date:Created in 15:20 2020/3/28
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class TestFour {
    // 1000 10
    // 10,110,111,1110,1010,1011,1111
    public static void main(String[] args) {
        int b = 0;
        int c = 0;
//        b |= 1;
        b |= 2;
 //       b |= 4;
//        b |= 8;
        System.out.println(b);

        c = b & 2;
        Boolean a;
        a = (b & 2) == 1;
        System.out.println(c);
        System.out.println(a);

        for (int i = 0; i < 16; i++) {
            if ((i & 2) == 2) {
                System.out.println(i);
            }
        }
    }
}
