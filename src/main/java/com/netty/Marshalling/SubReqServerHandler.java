package com.netty.Marshalling;

import com.netty.protobuf.SubscribeReqProto;
import com.netty.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到消息");
        SubscribeReqProto.SubscribeReq req =  (SubscribeReqProto.SubscribeReq)msg;

        if ("Lilinfeng".equalsIgnoreCase(req.getUserName())){

            System.out.println("Service accept client subscribe req : ["+req.toString()+"]");
            ctx.writeAndFlush(resp(req.getSubReqID()));

        }

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive 收到消息");
        System.out.println("收到消息");

    }

    private SubscribeRespProto.SubscribeResp resp(int subReqID){

        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setDesc("Netty book order succeed, 3 days later" +
                ", sent to the designated address");
        return builder.build();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }


}
