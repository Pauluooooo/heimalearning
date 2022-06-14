package com.heimalearning.tcpdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPractise {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char) b);
        }

//        OutputStream os = accept.getOutputStream();
//        os.write("你谁啊？".getBytes());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊？");
        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
