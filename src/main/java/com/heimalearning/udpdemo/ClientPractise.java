package com.heimalearning.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientPractise {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();
        while (true) {
            String s = scanner.nextLine();
            if ("886".equals(s)) {
                break;
            }
            byte[] bytes = s.getBytes();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 10000;
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
            datagramSocket.send(datagramPacket);
        }
        datagramSocket.close();
    }
}
