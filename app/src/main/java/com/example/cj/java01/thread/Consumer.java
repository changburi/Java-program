package com.example.cj.java01.thread;


/**
 * Created by cj on 2017-01-29.
 */

public class Consumer extends Thread {
  private Buffer buffer;

  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      buffer.get(i);
    }
  }
}
