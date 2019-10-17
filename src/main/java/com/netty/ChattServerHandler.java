package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Scanner;

public class ChattServerHandler extends ChannelHandlerAdapter {

    /**
     * 获取数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println(body);





        //获取输入的数据
        Scanner scanner = new Scanner(System.in);


            System.out.println("请输入数据");
            String a = scanner.nextLine();

            ByteBuf resp = Unpooled.copiedBuffer((a+"\r\n").getBytes());

            ctx.writeAndFlush(resp);








    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }



    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("11111");
    }
}
