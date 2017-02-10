package com.giousa.netty4msgpack.test;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
public class TestMessagePack {

    public static void main(String[] args) {
        // Create serialize objects
        List<String> src=new ArrayList<>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");
        MessagePack msgpack=new MessagePack();
        // Serialize
        byte[] raw;
        try {
            raw = msgpack.write(src);
            // Deserialize directly using a template
            List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
            System.out.println(dst1.get(0));
            System.out.println(dst1.get(1));
            System.out.println(dst1.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
