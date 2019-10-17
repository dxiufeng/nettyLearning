package com.netty.demo2;

import com.netty.demo.TimerServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) {

        int port =8080;

        if(args !=null && args.length > 0){

            try {
                port = Integer.valueOf(args[0]);

            }catch (Exception e){
                e.fillInStackTrace();
            }

        }


        ServerSocket server =null;

        try {
            server = new ServerSocket(port);

            System.out.println("the time server is start in port :"+ port);

             Socket socket=null;

            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(4, 2);


            while (true){

                socket = server.accept();

                final Socket finalSocket = socket;

                singleExecutor.execute(new TimerServerHandler(socket));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (server!=null){
                System.out.println("the time server closed");

                try {
                    server.close();
                    server=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }


    }
}
