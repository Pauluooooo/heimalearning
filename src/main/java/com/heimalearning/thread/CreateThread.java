package com.heimalearning.thread;
/*
* 1. 继承Thread，重写run方法
* 2. 实现Runnable接口，重写run方法，创建实例，将实例传入Thr
* 3. 利用Callable接口传入FutureTask<T>实现
* */
public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new FirstThread();
        t1.start();

        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);
        t2.start();
    }
}

class FirstThread extends Thread {
    @Override
    public void run(){
        System.out.println("start new thread!");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}