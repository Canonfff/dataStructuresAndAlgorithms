package com.canon.base.class_three;

import com.canon.base.class_four.TestOne;

import java.util.ServiceLoader;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/8/2 18:04
 * @Description:
 */
public class TestTen {


    public <T> T getReturn(T t) {

        TestOne.Inner inner = new TestOne.Inner();

        return t;
    }


    public static void main(String[] args) throws Exception {
        //Bean bean = initBean(new Bean());
        // System.out.println(bean);
        ServiceLoader<BeanInterface> interfaces = ServiceLoader.load(BeanInterface.class, TestTen.class.getClassLoader());
//        Class<?> clazz = Class.forName("com.canon.base.class_three.Bean", false, TestTen.class.getClassLoader());
//        Object o = clazz.newInstance();
//        System.out.println(o);
        for (BeanInterface anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    /**
     * 递归设置值
     * @param bean
     * @return
     */
    public static Bean initBean(Bean bean) {
        check : {
            if (bean.getName() == null) {
                bean.putName("wocao");
                break check;
            }
            if (bean.getNickName() == null) {
                bean.putNickName("aabb");
                break check;
            }
            if (bean.getPassword() == null) {
                bean.setPassword("123456");
                break check;
            }

            return bean;
        }

        return initBean(bean);
    }

}

class Bean implements BeanInterface {
    private String name;

    private String nickName;

    private String password;


    public Bean putName(String name) {
        this.name = name;
        return this;
    }

    public Bean putNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Bean putPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


class Bean2 implements BeanInterface {
    private String feild1;

    public String getFeild1() {
        return feild1;
    }

    public void setFeild1(String feild1) {
        this.feild1 = feild1;
    }
}


interface BeanInterface {

}
