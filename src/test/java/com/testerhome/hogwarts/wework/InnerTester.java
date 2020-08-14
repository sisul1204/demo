package com.testerhome.hogwarts.wework;

public class InnerTester {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        }).start();

        new Thread(()->{
            System.out.println("Hello sisul");
        }).start();

    }
}
