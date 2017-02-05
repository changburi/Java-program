package com.example.cj.java01;

/**
 * Created by cj on 2017-01-29.
 */

public class SimpleThread extends Thread {

  private String threadName;

  public SimpleThread(String threadName) {
    this.threadName = threadName;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(threadName + " : " + i);
    }
    System.out.println("==> " + threadName + " 수행종료 ");
  }

}
