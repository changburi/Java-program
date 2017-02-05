package com.example.cj.java01.data;

/**
 * Created by cj on 2017-01-15.
 */

public class Book {

  public String title;
  public String author;
  public int price;

  public Book() {
    this.title = null;
    this.author = null;
    this.price = -1;
  }

  public Book(String title, int price) {
    this.title = title;
    this.price = price;
  }

  public Book(String author, String title) {
    this.author = author;
    this.title = title;
  }

  public String toString() {
    return "[" + title + " : " + price + " ] ";
  }
  public String toText() {
    return "[" + author + " : " + title + " ] ";
  }

}
