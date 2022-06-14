package com.heimalearning.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServerDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket(10000);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        multicastSocket.joinGroup(InetAddress.getByName("224.0.1.0"));
        multicastSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] bytes = datagramPacket.getData();
        System.out.println(new String(bytes, 0, length));
        multicastSocket.close();
    }
}
