package com.canon.jdk.javabean;

/**
 * @PackageName: com.canon.jdk.javabean
 * @Description: 内省机制VO
 * @author: canon
 * @date: 2020/5/19 15:07
 * @Version: 1.0
 */
public class IntrospectModel {

    private String name;

    private String nickName;

    private String password;

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
