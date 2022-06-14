package com.heimalearning.tcpdemo;

import java.io.*;
import java.net.Socket;

public class ClientPractise {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        socket.shutdownOutput();

//        InputStream is = socket.getInputStream();
//        int b;
//        while ((b = is.read()) != -1){
//            System.out.print((char) b);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.print(line);
        }
        br.close();
        os.close();
        socket.close();
    }
}
