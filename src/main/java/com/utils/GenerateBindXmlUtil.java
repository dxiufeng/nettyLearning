package com.utils;

import org.jibx.binding.generator.BindGen;
import org.jibx.runtime.JiBXException;

import java.io.IOException;

public class GenerateBindXmlUtil {
    public static void main(String[] args) throws JiBXException, IOException {
        genFile();
    }

    private static void genFile() throws JiBXException, IOException {

        String[] args = new String[9];

        // 指定pojo源码路径（指定父包也是可以的）。必须
        args[0] = "-s";
        args[1] = "src";

        // 自定义生成的binding文件名，默认文件名binding.xml。可选
        args[2] = "-b";
        args[3] = "binding.xml";

        // 打印生成过程的一些信息。可选
        args[4] = "-v";

        // 如果目录已经存在，就删除目录。可选
        args[5] = "-w";

        //- t 指定xml和xsd输出路径 路径。默认路径 .（当前目录,即根目录）。
        args[6] = "-t";
        args[7] = "./src/main/java/com/a/pojo/order";

        // 告诉 BindGen 使用下面的类作为 root 生成 binding 和 schema。必须
        args[8] = "com.netty.pojo.Order";

        BindGen.main(args);


    }
}
