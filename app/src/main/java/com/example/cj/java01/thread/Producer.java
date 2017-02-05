package com.example.cj.java01.thread;


/**
 * Created by cj on 2017-01-29.
 */

public class Producer extends Thread {

  private Buffer buffer;

  public Producer(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      buffer.put(i);
      try {
        sleep ((int) Math.random() * 100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
