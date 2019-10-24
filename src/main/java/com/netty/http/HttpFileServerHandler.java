package com.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        /*if (!request.getDecoderResult().isSuccess()){
            sendError(ctx,BAD_REQUEST);
            return;
        }

        if(request.getMethod()!=GET){
            sendError(ctx,METHOD_NOT_ALLOWED);
            return;

        }*/
    }
}
