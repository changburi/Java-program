package com.example.cj.java01.thread;

/**
 * Created by cj on 2017-01-29.
 */

public class MailBox {
  private String message;
  private boolean request;

  public synchronized void storeMessage(String message) {
    while (request == true) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    request = true;
    this.message = message;
    notify();
  }

  public synchronized String retrieveMessage() {
    while (request == true) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    request = false;
    notify();
    return message;
  }
}
