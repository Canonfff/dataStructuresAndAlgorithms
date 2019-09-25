package com.canon.base.class_three;

import com.canon.base.class_four.TestOne;

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


    public static void main(String[] args) {
        Bean bean = initBean(new Bean());
        System.out.println(bean);
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

class Bean {
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