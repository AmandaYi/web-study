package com.zhaozheyun.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Server extends Thread{
    public static void main(String[] args) {

    }

    @Override
    public void run() {
        new Server();
    }

    public Server() {
        try {
            ServerSocket ss = new ServerSocket(8888);
//            System.out.println("广播消息");
            Socket s = ss.accept();

            //打开输入流
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            String msg = dis.readUTF();
            System.out.println(msg);
            while (true) {
                msg = dis.readUTF();
                System.out.println(msg);
            }
//            //读取客户端发送的数据
//            int msg = is.read();
            //打印出来
//            System.out.println(msg);
//            is.close();
//            dis.close();
//            s.close();
//            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client extends Thread {
    public static void main(String[] args) {

    }

    @Override
    public void run() {
        new Client();
    }

    public Client() {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in);
            dos.writeUTF(sc.next());
            while (true) {
                sc = new Scanner(System.in);
                dos.writeUTF(sc.next());
            }
//            dos.close();
//            os.close();
//            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class TestSocket {

    public static void main(String[] args) {

//        TestSocket t = new TestSocket();
//        t.getIp();
//        new Server();
        new Server();
        new Client();
    }


    public void getIp() {
        try {
            InetAddress host = InetAddress.getLocalHost();
            String ip = host.getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}