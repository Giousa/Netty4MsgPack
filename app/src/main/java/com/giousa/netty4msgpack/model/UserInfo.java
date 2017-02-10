package com.giousa.netty4msgpack.model;

import org.msgpack.annotation.Message;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */

@Message
public class UserInfo {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
