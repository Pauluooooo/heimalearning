package com.heimalearning.tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个socket对象
        Socket socket = new Socket("127.0.0.1", 10000);
        // 获取一个IO流开始写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,world!".getBytes());
        outputStream.close();
        socket.close();
    }
}
