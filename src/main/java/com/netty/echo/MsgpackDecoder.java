package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected void decode(ChannelHandlerContext ctx, ByteBuf arg1, List<Object> arg2) throws Exception {
        byte [] array;

        int length = arg1.readableBytes();

        array= new byte[length];

        arg1.getBytes(arg1.readerIndex(),array,0,length);

        MessagePack msgpack = new MessagePack();

        arg2.add(msgpack.read(array));

    }
}
