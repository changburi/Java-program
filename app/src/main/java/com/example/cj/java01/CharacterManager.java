package com.example.cj.java01;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by cj on 2017-01-28.
 */

public class CharacterManager {

    public static void encodingTest() throws Exception {
      String str = "가나다똠, 펲, 믜, 븨, 뮹, 헿, 뷁";

      byte[] defaultBytes = str.getBytes();
      byte[] eucBytes = str.getBytes("euc-kr");
      byte[] ksc5601Bytes = str.getBytes("ksc5601");
      byte[] ms949Bytes = str.getBytes("ms949");
      byte[] uniBytes = str.getBytes("unicode");
      byte[] utf16Bytes = str.getBytes("utf-16");
      byte[] utf16beBytes = str.getBytes("utf-16be");
      byte[] utf16leBytes = str.getBytes("utf-16le");
      byte[] utf8Bytes = str.getBytes("utf-8");
      byte[] latinBytes = str.getBytes("8859_1");

      System.out.println("기본인코딩으로 조합 : " + new String(defaultBytes));
      System.out.println("euc-kr로 조합 : " + new String(eucBytes, "euc-kr"));
      System.out.println("ksc5601로 조합 : "
          + new String(ksc5601Bytes, "ksc5601"));
      System.out.println("MS-949로 조합 : " + new String(ms949Bytes, "ms949"));
      System.out.println("유니코드로 조합 : " + new String(uniBytes, "unicode"));
      System.out.println("utf-16 조합 : " + new String(utf16Bytes, "utf-16"));
      System.out.println("utf-16be 조합 : "
          + new String(utf16beBytes, "utf-16be"));
      System.out.println("utf-16le 조합 : "
          + new String(utf16leBytes, "utf-16le"));
      System.out.println("utf-8 조합 : " + new String(utf8Bytes, "utf-8"));
      System.out.println("Latin-1로 조합 : " + new String(latinBytes, "8859_1"));
    }

  public static void fileReaderTest(Context context, String fileName) {
    String filePath = context.getFilesDir().getAbsolutePath();

    try {
      FileReader fileReader = new FileReader(filePath + fileName);
      int data = 0;
      while ((data = fileReader.read()) != -1) {
        System.out.println((char)data);
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void fileWriterTest(Context context, String inputName, String dirName, String outputName) {
    String filePath = context.getFilesDir().getAbsolutePath();

    File file = new File(filePath + dirName);
    file.mkdirs();

    try {
      FileReader fileReader = new FileReader(filePath + inputName);
      FileWriter fileWriter = new FileWriter(filePath + dirName + outputName);
      int data = 0;
      while ((data = fileReader.read()) != -1) {
        fileWriter.write((char)data);
      }
      fileReader.close();
      fileWriter.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void fileWriterAppendTest(Context context, String dirName, String fileName) {
    String filePath = context.getFilesDir().getAbsolutePath();
    File folder = new File(filePath + dirName);
    folder.mkdirs();

    try {
      FileWriter writer = new FileWriter(filePath + dirName + fileName, true);
      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      int min = calendar.get(Calendar.MINUTE);
      int sec = calendar.get(Calendar.SECOND);
      String time = hour + "시 " + min + "분 " + sec + "초";
      String logMsg = time + "에 발생된 로그 메시지\n";
      writer.write(logMsg);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void bufferedReaderTest(Context context, String dirName, String inputName) {
    String filePath = context.getFilesDir().getAbsolutePath();

    try {
      FileReader fileReader = new FileReader(filePath + dirName + inputName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String data = null;
      int lineNumber = 0;
      while ((data = bufferedReader.readLine()) != null) {
        System.out.println(++lineNumber + " : " + data + "\n");
      }
      bufferedReader.close();
      fileReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    public static void inputStreamReaderTest() {
      try {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buffReader = new BufferedReader(reader);

        System.out.println("< 이름을 입력하세요. >");
        String name = buffReader.readLine();

        System.out.println("< 전화번호를 입력하세요. >");
        String phone = buffReader.readLine();

        buffReader.close();
        reader.close();
        in.close();
        System.out.println(name + " 님의 전화번호 : " + phone);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static void printWriterTest(Context context,String dirName, String fileName) throws IOException {
      String filePath = context.getFilesDir().getAbsolutePath();
      InputStream in = System.in;
      InputStreamReader inReader = new InputStreamReader(in);
      BufferedReader reader = new BufferedReader(inReader);

      File folder = new File(dirName);
      if (!folder.exists()) {
        folder.mkdirs();
      }

      FileOutputStream output = new FileOutputStream(filePath + dirName + fileName);
      PrintWriter writer = new PrintWriter(output, true);

      System.out.println("[저장할 메시지를 입력하세요.]");
      String msg = null;

      while ((msg = reader.readLine()) != null) {
        writer.println(msg);
      }
      reader.close();
      inReader.close();
      in.close();
      writer.close();
      output.close();
    }

    public static void scannerTest() {
      InputStream in = System.in;
      Scanner keyboard = new Scanner(in);

      System.out.println("< 이름을 입력하세요. >");
      String name = keyboard.nextLine();

      System.out.println("< 전화번호를 입력하세요. >");
      String phone = keyboard.nextLine();

      keyboard.close();
      System.out.println(name + " 님의 전화번호 : " + phone);
    }

    public static void advancedIOTest(Context context, String dirName, String fileName) throws IOException {
      String filePath = context.getFilesDir().getAbsolutePath();
      Scanner keyboard = new Scanner(System.in);
      PrintWriter writer = new PrintWriter(new FileWriter(filePath + dirName + fileName), true);

      while (true) {
        System.out.println("< 이름을 입력하세요. >");
        String name = keyboard.nextLine();

        System.out.println("< 전화번호를 입력하세요. >");
        String phone = keyboard.nextLine();

        writer.write(name + " : " + phone);
        System.out.println(name + " 님의 전화번호를 저장했습니다.");
        System.out.println("종료를 원하시면 exit를 입력하시고 " +
            "계속 입력하시려면 Enter를 입력하세요.");

        String flag = keyboard.nextLine();
        if (flag.equals("exit")) {
          break;
        }
      }
      keyboard.close();
      writer.close();
    }


}
