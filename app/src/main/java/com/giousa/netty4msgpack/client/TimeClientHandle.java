package com.giousa.netty4msgpack.client;

import com.giousa.netty4msgpack.model.Student;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
public class TimeClientHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client read");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(getStudent());
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

    private Student getStudent(){
        Student s = new Student();
        s.setId(3);
        s.setName("zhangsan");
        return s;
    }


}
