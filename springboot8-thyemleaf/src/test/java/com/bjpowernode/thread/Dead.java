package com.bjpowernode.thread;

public class Dead {
    //public static Object resources1 = new Object();
    //public static Object resources2 = new Object();
    public static void main(String[] args) {
        Object resources1 = new Object();
        Object resources2 = new Object();
        new Thread(() -> {
            // 线程1：占用资源1 ，请求资源2
            synchronized(resources1){
                System.out.println("线程1已经占用了资源1，开始请求资源2");
                try {
                    Thread.sleep(2000);//休息两秒，防止线程1直接运行完成。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //2秒内线程2肯定可以锁住资源2
                synchronized (resources2){
                    System.out.println("线程1已经占用了资源2");
                }
            }}).start();

            new Thread(() -> {
                // 线程2：占用资源2 ，请求资源1
                synchronized(resources2){
                    System.out.println("线程2已经占用了资源2，开始请求资源1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources1){
                        System.out.println("线程2已经占用了资源1");
                    }
                }
        }).start();
    }
}