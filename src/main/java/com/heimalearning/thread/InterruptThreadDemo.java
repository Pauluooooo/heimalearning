package com.heimalearning.thread;
/*
* 代码运行顺序
* 1. main线程创建并启动t线程，然后等待1秒钟
* 2. t线程启动hello线程，等待hello线程结束
* 3. hello线程启动，输出自增，并休息0.1秒
* 4. main中断t线程，并等待t线程结束
* 5. t线程处于等待hello线程结束中，抛出InterruptedException，立即结束t线程，在结束前对hello线程中断
* 6. hello线程结束，main线程输出end
* */
public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000); // main线程暂停1秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
