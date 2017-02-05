package com.example.cj.java01.thread;

/**
 * Created by cj on 2017-01-29.
 */

public class Buffer {
  private int contents;
  private boolean flag = false;

  public synchronized void put(int value) {
    if (flag == true) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    contents = value;
    flag = true;
    System.out.println("생산자 : 생산 " + contents );
    notifyAll();
  }

  public synchronized void get(int value) {
    if (flag == false) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("소비자 : 소비 " + contents);
    flag = false;
    notifyAll();
  }
}
