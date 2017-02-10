package com.giousa.netty4msgpack.client;

import com.giousa.netty4msgpack.code.MsgPackDecode;
import com.giousa.netty4msgpack.code.MsgPackEncode;
import com.giousa.netty4msgpack.model.Student;
import com.giousa.netty4msgpack.model.TypeData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/10
 * Email:65489469@qq.com
 */
public class TimeClient {

    public static String host = "127.0.0.1";
    public static int port = 7878;
    public static int speed = 0;
    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new MsgPackDecode());
                    pipeline.addLast(new MsgPackEncode());
                    pipeline.addLast(new TimeClientHandle());
                }
            });

            // 连接服务端
            Channel ch = b.connect(host, port).sync().channel();

            // 控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                System.out.println("请输入：");
                String line = in.readLine();
                if (line == null) {
                    continue;
                }
                System.out.println("client msg:"+getStudent().toString());
                ch.writeAndFlush(getStudent());
//                ch.writeAndFlush(line + "\r\n");
            }
        } finally {
            // The connection is closed automatically on shutdown.
            group.shutdownGracefully();
        }
    }

    private static Student getStudent(){
        Student s = new Student();
        s.setType(TypeData.CUSTOME);
        s.setId(speed++);
        s.setName("giousa");
        return s;
    }
}

