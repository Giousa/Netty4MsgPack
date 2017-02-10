package com.giousa.netty4msgpack.server;

import com.giousa.netty4msgpack.code.MsgPackDecode;
import com.giousa.netty4msgpack.code.MsgPackEncode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
public class TimeServer {

    /**
     * 服务端监听的端口地址
     */
    private static final int portNumber = 7878;

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {

                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new MsgPackDecode());
                    pipeline.addLast(new MsgPackEncode());
                    pipeline.addLast(new TimeServerHandle());
                }
            });

            // 服务器绑定端口监听
            ChannelFuture f = b.bind(portNumber).sync();

            System.out.println("Server Start");
            // 监听服务器关闭监听
            f.channel().closeFuture().sync();

            System.out.println("------");

            // 可以简写为
            /* b.bind(portNumber).sync().channel().closeFuture().sync(); */
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
