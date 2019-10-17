package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

public class MsgpackEncoder extends MessageToByteEncoder<Object> {
    protected void encode(ChannelHandlerContext ctx, Object arg1, ByteBuf arg2) throws Exception {

        MessagePack msgePack = new MessagePack();

        byte[] raw = msgePack.write(arg1);

        arg2.writeBytes(raw);

    }
}
