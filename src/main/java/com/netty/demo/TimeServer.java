package com.netty.demo;

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

            while (true){

                socket = server.accept();

                final Socket finalSocket = socket;
                new Thread(
                       new TimerServerHandler(socket)
               ).start();
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
