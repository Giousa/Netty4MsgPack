package com.giousa.netty4msgpack.server;

import com.giousa.netty4msgpack.model.Student;

import org.msgpack.MessagePack;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
public class TimeServerHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        System.out.println("msg:"+msg);

        List<Student> s = (List<Student>) msg;
        System.out.println(s);

        System.out.println("type="+s.get(0));
        System.out.println("id="+s.get(1));
        System.out.println("name="+s.get(2));

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

}
