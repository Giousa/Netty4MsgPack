package com.giousa.netty4msgpack.model;

import org.msgpack.annotation.Message;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
@Message
public class Student {

    private byte type;

    private int id;

    private String name;


    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "type=" + type +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
