package com.canon.java.base.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2020/1/2 11:45
 * @Description:
 */
public class LambdaTest {
    public static void main(String[] args) {
        // forEach();
        // threadOut();
        output();
    }

    /**
     * 通用示例,函数式编程
     * 这种其实就是构造一个代理对象类;然后通过代理对象对接口方法的实现进行输出;
     */
    public static void output() {
        System.out.println("output");
        LambdaTest tester = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;


        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }


    public void output2() {

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


    /**
     * TODO 循环示例
     */
    // #############################################循环示例#######################################################
    public static void forEach() {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");

        // 直接打印
        lists.forEach(System.out :: println);

        // 这个是什么鬼? 这种是方法引用的方式
        DoubleConsumer runnable = System.out :: println;
        Runnable a = System.out :: println;



        // for 循环内比较值
        lists.forEach(s -> System.out.println(s.equals("1")));



    }

    /**
     * TODO 线程示例
     */
    // #############################################线程示例#######################################################
    public static void threadOut() {
        // new Thread(() -> System.out.println("lambda 编程")).start();
        // Runnable runnable = () -> System.out.println(123);
        new Thread(() -> {System.out.println(123);}).start();
    }
}


