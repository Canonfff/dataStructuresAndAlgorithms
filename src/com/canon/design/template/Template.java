package com.canon.design.template;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PackageName: com.canon.design.template
 * @Description: 抽象模板接口
 * @author: canon
 * @date: 2020/5/27 10:37
 * @Version: 1.0
 */
public class Template {

    private static ConcurrentHashMap<Integer, Strategy> strategys;

    public void doThings(int i) {
       doFn(i);
    }

    private void fn3() {
        System.out.println(3);
    }

    private void fn2() {
        System.out.println(2);
    }

    private void fn1() {
        System.out.println(1);
    }

    private void doFn(int i) {
        strategys.get(i).doFn();
    }




    @PostConstruct
    public void init() {
        strategys = new ConcurrentHashMap<Integer, Strategy>();
        strategys.put(1, () -> fn1());
        strategys.put(2, () -> fn2());
        strategys.put(3, () -> fn3());
    }

    interface Strategy {
        void doFn();
    }

//    class F1 implements Strategy{
//
//        @Override
//        public void doFn() {
//
//        }
//    }
}
