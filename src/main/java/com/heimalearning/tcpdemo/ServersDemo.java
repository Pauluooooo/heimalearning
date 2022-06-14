package com.heimalearning.tcpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServersDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocketocket = new ServerSocket(10000);
        Socket accept = serverSocketocket.accept();
        InputStream inputStream = accept.getInputStream();
        int b;
        while ((b = inputStream.read()) != -1) {
            System.out.print((char) b);
        }
        inputStream.close();
        serverSocketocket.close();
    }
}
