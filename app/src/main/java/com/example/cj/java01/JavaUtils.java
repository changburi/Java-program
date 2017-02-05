package com.example.cj.java01;

import android.util.Log;

import com.example.cj.java01.data.Book;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by cj on 2017-01-14.
 */

public class JavaUtils {
  protected final static String TAG = JavaUtils.class.getSimpleName();

  public static void ArrayTest() {
    int[] scoreList = {87, 56, 79, 98, 34, 55, 76};
    Log.d(TAG, "ArrayTest");
    Arrays.sort(scoreList);
    for (int i = 0; i < scoreList.length; i++) {
      System.out.println(scoreList[i] + ", ");
    }
    System.out.println(" ");
    System.out.println("최소점 " + scoreList[0]);
    System.out.println("최대점 " + scoreList[scoreList.length - 1]);
  }

  public static void DateTest() {
    Date currentDate = new Date();
    long start = currentDate.getTime();

    System.out.println(currentDate.toString());
    System.out.println(currentDate.toLocaleString());

    currentDate = new Date();
    long end = currentDate.getTime();
    System.out.println("프로그램 수행시간 걸린 시간 " + (end - start) + "(ms)초 ");
  }

  public static void CalendarTest() {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int mon = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    int sec = cal.get(Calendar.SECOND);

    System.out.println("현재 시간");
    System.out.println(year + " 년 " + mon + " 월 " + day + " 일");
    System.out.println(hour + " 시 " + min + " 분 " + sec + " 초");
  }

  public static void FormatterTest() {
    StringBuffer sb = new StringBuffer();
    Formatter fb = new Formatter(sb);
    Calendar cal = Calendar.getInstance();

    int i = 10;
    int j = 5;
    int k = i + j;
    String str = "연산 결과";
    fb.format("%s%n", str);
    fb.format("%d과 %d을 더하면 %d이 됩니다.", i, j, k);
    fb.format("현재 시간은 %tk시 %tM분 %tS초 입니다.", cal, cal, cal);
    System.out.println(fb.toString());
  }

  public static void VectorTest() {
    Vector list = new Vector(3);
    System.out.println("저장능력 : " + list.capacity());
    System.out.println("저장 요소 개수 : " + list.size());

    list.addElement(new Integer(10));
    list.addElement(new Double(10));
    list.addElement(new String("자바"));
    list.addElement(new Date());

    System.out.println("<<세개의 객체 저장후>>");
    System.out.println("저장능력 : " + list.capacity());
    System.out.println("저장 요소 개수 : " + list.size());

    if (list.contains("자바")) {
      System.out.print("\"자바\" 스트링은 " + list.indexOf("자바"));
      System.out.println(" 번 인덱스에 존재한다.");
    }

    System.out.println("<< Vector에 저장된 요소들 >> ");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " 번째 요소는 " + list.elementAt(i));
    }
  }

  public static void EnumerationTest() {
    Vector list = new Vector(5);
    list.addElement(new Integer(10));
    list.addElement(new Double(10));
    list.addElement(new String("자바"));
    list.addElement(new Date());

    System.out.println("<< Vector에 저장된 요소들 >> ");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " 번째 요소는 " + list.elementAt(i));
    }

    Enumeration e = list.elements();
    System.out.println();
    System.out.println("<< Vector로 부터 생성한 Enumeration의 요소들 >>");
    while (e.hasMoreElements()) {
      System.out.println("e의 요소 : " + e.nextElement());
    }
  }

  public static void StackTest() {
    Stack stack = new Stack();
    for (int i = 0; i <= 5; i++) {
      stack.push(" 데이터 - " + i);
    }
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public static void QueueTest() {
    Queue<String> queue = new LinkedList<String>();
    for (int i = 0; i <=3; i++) {
      queue.add("데이터 - " + i);
    }
    System.out.println("<< 가장 앞에 있는 요소 >>");
    System.out.println(queue.peek());
    System.out.println("<< 순차적으로 요소 꺼내기 >>");
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }

  public static void GenericsTest() {
    Vector<Integer> list = new Vector<Integer>();
    list.addElement(new Integer(100));
    list.addElement(new Integer(95));
//    list.addElement(new Double(10.0));
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      Integer score = list.elementAt(i);
      sum = sum + score.intValue();
      System.out.println("점수의 총합 : " + sum);
    }
  }

  public static void ForTest() {
    Vector<String> list = new Vector<String>();
    list.add("JAVA");
    list.add("SQL");
    list.add("Servlet");

    for (String subject : list) {
      System.out.println(subject);
    }
  }

  public static void GenericBookTest() {
    new GenericBook();
  }

  public static class GenericBook {

    public GenericBook() {
      Vector<Book> bookList = new Vector<Book>();
      bookList.add(new Book("Java Programmin", 28000));
      bookList.add(new Book("SQL Fundamentals", 17600));
      bookList.add(new Book("Java Web Programming", 67200));
      bookList.add(new Book("XML Web Service 기초 ", 32000));
      bookList.add(new Book("Spring Framework 3.0", 54300));

      System.out.println("Book의 평균 가격 : " + avgPrice(bookList));
      Book maxPriceBook = getMaxPriceBook(bookList);
      System.out.println("최고가 책 : " + maxPriceBook.toString());
    }

    public int avgPrice(Vector<Book> bookList) {
      int sumPrice = 0;
      for (Book book : bookList) {
        sumPrice = sumPrice + book.price;
      }
      int avgPrice = sumPrice / bookList.size();
      return avgPrice;
    }

    private Book getMaxPriceBook(Vector<Book> bookList) {
      int maxPrice = 0;
      Book selectedBook = null;
      for (Book book : bookList) {
        if (book.price > maxPrice) {
          maxPrice = book.price;
          selectedBook = book;
        }
      }
      return selectedBook;
    }
  }
}
