package com.netty.demo;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class TimerServerHandler implements Runnable {

    private Socket socket;

    public TimerServerHandler(Socket socket) {
        this.socket = socket;
    }


    /**
     * 从写runnable
     */
    public void run() {

        BufferedReader in =null;
        PrintWriter out =null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

             out = new PrintWriter(this.socket.getOutputStream(), true);

             String currentTime =null;
             String body=null;
             while (true){

                 body =in.readLine();
                 if(body==null)
                     break;


                 System.out.println("the time server receive order : "+body);

                 currentTime= "Query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
                 out.println(currentTime);

             }

        } catch (Exception e) {
            if(in !=null){

                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

            if(out!=null){
                out.close();
                out=null;
            }

            if(this.socket!=null){


                try {
                    this.socket.close();
                    this.socket=null;

                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }

            e.printStackTrace();
        }

    }
}
