package com.example.cj.java01;

import com.example.cj.java01.collection.MyArray;
import com.example.cj.java01.data.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by cj on 2017-01-18.
 */

public class CollectionUtils {
  public static void myArrayTest() {
    MyArray arr = new MyArray(5);
    for (int i = 1; i <= 5; i++) {
      arr.add("데이터-" + i);
    }
    System.out.println("<< MyArray 객체에 저장된 요소들 >>");
    System.out.println(arr.toString());
    System.out.println("<< MyArray 0번 index에 저장된 요소 >>");
    System.out.println(arr.get(0));
    System.out.println("<< MyArray 3번 index에 저장된 요소 >>");
    System.out.println(arr.get(3));

    arr.remove(3);
    System.out.println("<< 3번 index 요소 삭제 후, 요소들 >>");
    System.out.println(arr.toString());

    arr.add("데이터-4");
    System.out.println("<< 새로운 데이터 등록 후, 요소들 >>");
    System.out.println(arr);
  }

  public static void arrayListTest() {
    ArrayList<Double> scoreList = new ArrayList<Double>();
    scoreList.add(9.5);
    scoreList.add(8.4);
    scoreList.add(1, 9.2);
    scoreList.add(9.5);
    System.out.println(scoreList.toString());

    double minScore = 100;
    double maxScore = 0;
    double score = 0;
    for (int i = 0; i < scoreList.size(); i++) {
      score = scoreList.get(i);
      if (score < minScore) {
        minScore = score;
      }
      if (score > maxScore) {
        maxScore = score;
      }
    }
    scoreList.remove(minScore);
    scoreList.remove(maxScore);
    System.out.println(scoreList.toString());

    double sum = 0;
    for (int i = 0; i < scoreList.size(); i++) {
      sum += scoreList.get(i);
    }

    System.out.println("최저 점수 : " + minScore);
    System.out.println("최고 점수 : " + maxScore);
    System.out.println("평균 점수 : " + (sum / scoreList.size()));
  }

  public static void linkedListTest() {
    LinkedList<Double> scoreList = new LinkedList<Double>();
    scoreList.add(9.5);
    scoreList.addFirst(8.4);
    scoreList.add(9.2);
    scoreList.add(9.5);
    System.out.println(scoreList.toString());

    double minScore = scoreList.getFirst();
    double maxScore = scoreList.getLast();

    scoreList.removeFirst();
    scoreList.removeLast();
    System.out.println(scoreList.toString());

    double sum = 0;
    for (int i = 0; i < scoreList.size(); i++) {
      sum += scoreList.get(i);
    }

    System.out.println("최저 점수 : " + minScore);
    System.out.println("최고 점수 : " + maxScore);
    System.out.println("평균 점수 : " + (sum / scoreList.size()));
  }

  public static void HashSetTest() {
    HashSet<String> set = new HashSet<String>();
    set.add("9.5");
    set.add("8.4");
    set.add("9.2");
    set.add("9.5");
    set.add("6.7");
    System.out.println(set.toString());

    set.remove("9.2");
    System.out.println(set.toString());
  }

    public static void linkedHashSetTest() {
      LinkedHashSet<String> set = new LinkedHashSet<String>();
      set.add("9.5");
      set.add("8.4");
      set.add("9.2");
      set.add("9.5");
      set.add("6.7");
      System.out.println(set.toString());

      set.remove("9.2");
      System.out.println(set.toString());
    }

    public static void treeSetTest() {
      TreeSet<String> set = new TreeSet<String>();
      set.add("9.5");
      set.add("8.4");
      set.add("9.2");
      set.add("9.5");
      set.add("6.7");
      System.out.println(set.toString());

      set.remove("9.2");
      System.out.println(set.toString());
    }

    public static void iteratorTest() {
      LinkedList<Double> scoreList = new LinkedList<Double>();
      scoreList.add(new Double(9.5));
      scoreList.add(new Double(7.5));
      scoreList.add(new Double(8.2));
      System.out.println(scoreList.toString());

      double sum = 0;
      Iterator<Double> it = scoreList.iterator();
      while (it.hasNext()) {
        sum += it.next();
      }
      System.out.println("점수의 총합 : " + sum);
    }

    public static void hashMapTest() {
      HashMap<String, String> map = new HashMap<String, String>();
      map.put("정길용", "010-111-1111");
      map.put("강성윤", "010-222-2222");
      map.put("채규태", "010-333-3333");

      Set<String> keys = map.keySet();
      System.out.println(keys.toString());

      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = (String) it.next();
        System.out.println(key + " : " + map.get(key));
      }
    }

    public static void linkedHashMapTest() {
      LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
      map.put("정길용", "010-111-1111");
      map.put("강성윤", "010-222-2222");
      map.put("채규태", "010-333-3333");

      Set<String> keys = map.keySet();
      System.out.println(keys.toString());

      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = (String) it.next();
        System.out.println(key + " : " + map.get(key));
      }
    }

    public static void treeMapTest() {
      TreeMap<String, String> map = new TreeMap<String, String>();
      map.put("정길용", "010-111-1111");
      map.put("강성윤", "010-222-2222");
      map.put("채규태", "010-333-3333");

      Set<String> keys = map.keySet();
      System.out.println(keys.toString());

      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = (String) it.next();
        System.out.println(key + " : " + map.get(key));
      }
    }

  public static void sumTest(int... x) {
    int sum = 0;
    for (int i : x) {
      sum += i;
    }
    System.out.println(sum);
  }

  public static void addBook(String type, String... str) {
    int index = 0;
    ArrayList<Book> book = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    for (String data : str) {
      title.add(data);
    }

    for (int i = 0; i < title.size() / 2; i++) {
      Book temp = new Book();
      temp.author = title.get(index++);
      temp.title = title.get(index++);
      book.add(i, temp);
      System.out.println(book.get(i).toText());
    }
  }

  public static void HashMapTest() {
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    ArrayList<String> phoneNo = new ArrayList<>();
    phoneNo.add("010-111-1111");
    phoneNo.add("010-222-2222");
    map.put("정길윤", phoneNo);
  }
}
