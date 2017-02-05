package com.example.cj.java01.thread;

/**
 * Created by cj on 2017-01-29.
 */

public class ProducerConsumerTest {
  public static void producerConsumerTest() {
    Buffer buffer = new Buffer();
    Producer producer = new Producer(buffer);
    Consumer consumer = new Consumer(buffer);
    producer.start();
    consumer.start();
  }
}
