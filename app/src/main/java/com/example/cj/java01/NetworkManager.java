package com.example.cj.java01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by cj on 2017-01-30.
 */

public class NetworkManager {
  public static void inetAddressTest() {
    System.out.println("<< IP 주소나 도메인 주소를 입력하세요 >>");
    String address = "daum.net";
//    Scanner keyboard = new Scanner(System.in);
//    String address = keyboard.nextLine();

    InetAddress[] addressList = null;

    try {
      addressList = InetAddress.getAllByName(address);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < addressList.length; i++) {
      System.out.println("----------------");
      System.out.println(addressList[i].getHostName());
      System.out.println(addressList[i].getHostAddress());
      System.out.println(addressList[i].toString());
      System.out.println("----------------");
    }
  }

  public static void IPAddressLocalTest() {
    InetAddress address = null;
    try {
      address = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    System.out.println("<< 로컬 컴퓨터 이름과 IP 주소 >>");
    System.out.println(address.getHostName());
    System.out.println(address.getHostAddress());

    System.out.println("<< byte[] 형식의 IP 주소 >>");
    byte[] ip = address.getAddress();
    for (int i = 0; i < ip.length; i++) {
      System.out.print((int)ip[i]);
      if ( i != ip.length - 1) {
        System.out.print(".");
      }
    }
  }
}
