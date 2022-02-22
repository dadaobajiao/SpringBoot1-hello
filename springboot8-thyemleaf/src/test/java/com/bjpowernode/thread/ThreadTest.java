package com.bjpowernode.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {


        static int r = 0;
        public static void main(String[] args) throws InterruptedException {
            test1();
        }
        private static void test1() throws InterruptedException {
            Thread t1 = new Thread(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r=10;
            },"t1");
            t1.start();
            t1.join();//不等待线程执行结束，输出的10
            System.out.println(r);
        }

        @Test
    public void test01(){
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.interrupt();
            System.out.println("sssssssss");
        System.out.println(" 打断状态: {}" + t1.interrupted());// 打断状态: {}false
    }



}
