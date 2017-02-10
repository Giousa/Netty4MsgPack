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

//        MessagePack messagePack = (MessagePack) msg;//阻塞，若是不通过，不会继续获取数据



    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

}
