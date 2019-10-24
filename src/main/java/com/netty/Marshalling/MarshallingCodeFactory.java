package com.netty.Marshalling;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public final class MarshallingCodeFactory {


    /**
     * 解码器
     *
     * @return
     */
    public static MarshallingDecoder builMarshallingDecoder() {

        //得到 MashallerFactory实例,"serial" 表示创建的是java序列化工程对象
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");

        MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);//设置 MarshallingConfiguration 的版本号为5

        //更具工厂和配置类,创建 UnmarshallerProvider 实例
        DefaultUnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory, configuration);

        //通过构造函数 创建解码对象
        MarshallingDecoder decoder = new MarshallingDecoder(provider, 1024);

        return decoder;
    }


    /**
     * 编码器
     *
     * @return
     */
    public static MarshallingEncoder buildMarshallingEncoder() {

        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");

        MarshallingConfiguration configuration = new MarshallingConfiguration();

        configuration.setVersion(5);

        // MarshallerProvider 对象,用于创建Netty提供的MarshallingEncoder实例,
        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory, configuration);

        //MarshallingEncoder实例用于序列化接口的POJO对象序列化为二进制数组
        MarshallingEncoder encoder = new MarshallingEncoder( provider);

        return  encoder;

    }

}
