package com.heimalearning.udpdemo;

import java.io.IOException;
import java.net.*;

public class MulticastClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String s = "hello,world!";
        byte[] bytes = s.getBytes();
        InetAddress inetAddress = InetAddress.getByName("224.0.1.0");
        int port = 10000;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
