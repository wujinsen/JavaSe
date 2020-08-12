package cn.wjs.javase.thread;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        waitNotifyRun();
    }
    private static void waitNotifyRun() {
        Object lock = new Object();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        a.start();
        b.start();
    }

}
