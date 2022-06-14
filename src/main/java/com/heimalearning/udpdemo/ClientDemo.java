package com.heimalearning.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建码头
        DatagramSocket datagramSocket = new DatagramSocket();
        // 2.创建礼物
        String s = "Hello,world!";
        byte[] bytes = s.getBytes();
        // 3.创建包裹
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
        // 4.发送包裹
        datagramSocket.send(datagramPacket);
        // 5.释放资源
        datagramSocket.close();
    }
}
