package com.example.cj.java01;

/**
 * Created by cj on 2017-01-29.
 */

public class MyThreadRunnable implements Runnable {
  String threadName;
  private boolean flag = true;
  public MyThreadRunnable() {
  }

  public MyThreadRunnable(String threadName) {
    this.threadName = threadName;
  }

  @Override
  public void run() {
    while (flag) {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + " " + threadName);
        try {
          Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("---> " + threadName + " 수행 종료 ");
    }
  }

  public void threadStart() {
    Thread myThread = new Thread(this);
    myThread.start();
  }

  public void threadStop() {
    System.out.println("Thread 중지!");
    flag = false;
  }

}
