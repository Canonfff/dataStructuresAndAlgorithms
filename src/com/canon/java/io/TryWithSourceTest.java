package com.canon.java.io;

/**
 * @PackageName: com.canon.java.io
 * @Description:
 * @author: canon
 * @date: 2020/9/14 9:57
 * @Version: 1.0
 */
public class TryWithSourceTest {

    public static void main(String[] args) {
        try (TryWithSourceDemo demo = new TryWithSourceDemo()) {
            System.out.println("inner try");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
