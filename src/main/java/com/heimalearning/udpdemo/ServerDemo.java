package com.heimalearning.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建接收端码头
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        // 2.创建新箱子
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        // 3.从码头接收数据至新箱子
        datagramSocket.receive(datagramPacket);
        // 4.输出数据
        int length = datagramPacket.getLength();
        System.out.print(new String(bytes, 0, length));
        // 5.释放资源
        datagramSocket.close();
    }
}
