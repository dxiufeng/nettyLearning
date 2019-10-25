package com.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

    private static final String DEFAULT_URL="/src/main/java/com/netty/http/";

    public void run(final int port,final String url){


        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder",new HttpRequestDecoder());


                            //HttpObjectAggregator 解码器,作用: 将多个消息转换为单一的FullHttpRequest或者FullHttpResponse,原因: http解码器在每个http消息中会生成多个消息对象
                            ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));//2^16

                            //http响应编码器,对http响应消息进行编码
                            ch.pipeline().addLast("http-encoder",new HttpResponseEncoder());

                            //支持异步发送大的码流(例如大的文件传输),但不占用过多的内存,防止java内存溢出
                            ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());

                            //文件服务器业务逻辑处理
                            ch.pipeline().addLast("fileServerHandler",new HttpFileServerHandler(url));


                        }
                    });


            ChannelFuture f = b.bind("localhost", port).sync();
            System.out.println("http 文件目录服务器启动,网址是: "+"http://localhost:"+port+url);
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }


    public static void main(String[] args) {
        int port =8080;

        String url =DEFAULT_URL;

        new HttpFileServer().run(port,url);
    }
}
