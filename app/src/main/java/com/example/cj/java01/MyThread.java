package com.example.cj.java01;

/**
 * Created by cj on 2017-01-28.
 */

public class MyThread extends Thread {
  String threadName;

  public MyThread(String threadName) {
    this.threadName = threadName;
  }

  public void run() {
    for (int i = 0; i < 500; i++) {
      System.out.println(i + " " + threadName);
      try {
        sleep((int)(Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(" ----> " + threadName + " 수행종료 ");
  }


}
