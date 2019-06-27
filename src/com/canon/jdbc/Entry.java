package com.canon.jdbc;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 15:53
 * @Description:
 */
@Table("role_group_entry")
public class Entry implements Serializable {
    @PrimaryKey()
    private String id;
    @Field("name")
    private String name;
    @Field("password")
    private String password;

    private String nickName;

    @Field
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
