package com.example.cj.java01;

/**
 * Created by cj on 2017-01-28.
 */

public class ThreadManager {
  public static void threadTest() {
    System.out.println("싱글 thread 프로그램 수행...");

    for (int i = 0; i < 10; i++) {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + " : " + i);
    }
  }

  public static void myThreadTest() {
    System.out.println("====> program start");
    MyThread first, second;
    first = new MyThread("First thread");
    second = new MyThread("Second thread");
    first.setName("first_ocj");
    second.setName("second_ocj");
    first.start();
    second.start();
    System.out.println("====> progradm end");
  }

  public static void doWork() {
    Thread anotherThread = new Thread();
    anotherThread.setName("doWork");
    anotherThread.start();

    try {
      anotherThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void myThreadRunnableTest() {
    System.out.println("===> program start ");
    Thread first, second;
    first = new Thread(new MyThreadRunnable("first thread"));
    second = new Thread(new MyThreadRunnable("second thread"));
    first.start();
    second.start();
    System.out.println("==> program end");
  }

  public static void myThreadRunnableRunTest() {
    MyThreadRunnable myThread = new MyThreadRunnable();
    myThread.threadStart();
    myThread.threadStop();
  }

  public static void simpleThreadTest() {
    System.out.println("===> program start");
    SimpleThread first = new SimpleThread("First Thread");
    SimpleThread second = new SimpleThread("second thread");
    first.setPriority(Thread.MIN_PRIORITY);
    second.setPriority(Thread.MAX_PRIORITY);
    first.start();
    second.start();
  }

}
