package com.example.cj.java01;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cj on 2017-01-25.
 */

public class ByteStreamManager {
  public static void stdIOTest() {
    int bt;
    int cnt = 0;
    try {
      while ((bt = System.in.read()) != -1) {
        cnt++;
        System.out.print((char)bt);
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println(e);
    }
    System.out.println();
    System.out.println("total bytes : " + cnt);
  }

  public static void fileInputStreamTest(Context context, String fileName) {
    String filePath = context.getFilesDir().getAbsolutePath();
    int size;
    FileInputStream input = null;
    try {
      input = new FileInputStream(filePath + fileName);
      while ((size = input.available()) > 0) {
        byte[] bytes = new byte[size];
        int result = input.read(bytes);
        if (result == -1) {
          break;
        }
        String str = new String(bytes);
        System.out.println(str);
      }
      input.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void fileOutputStreamTest(Context context, String fileName, String data) throws FileNotFoundException {
    String filePath = context.getFilesDir().getAbsolutePath();
//    File file = new File(filePath, fileName);
    FileOutputStream fo = new FileOutputStream(filePath + fileName, false);
    try {
      fo.write(data.getBytes());
      fo.flush();
      fo.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copyFile(Context context, String inputName, String outputName) {
    String filePath = context.getFilesDir().getAbsolutePath();
    FileInputStream input = null;
    FileOutputStream output = null;

    try {
      input = new FileInputStream(filePath + inputName);
      output = new FileOutputStream(filePath + outputName, false);
      long start = System.currentTimeMillis();
      int ch = 0;
      while((ch = input.read()) != -1) {
        output.write(ch);
      }
      long end = System.currentTimeMillis();
      System.out.println("파일 복사에 걸린 시간: " + (end - start) + "ms(초)");
      input.close();
      output.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copyFileBuffer(Context context, String inputName, String outputName) {
    String filePath = context.getFilesDir().getAbsolutePath();
    FileInputStream input = null;
    FileOutputStream output = null;

    try {
      input = new FileInputStream(filePath + inputName);
      output = new FileOutputStream(filePath + outputName, false);
      int size = input.available();
      byte[] buffer = new byte[size];
      long start = System.currentTimeMillis();

      int readCnt = input.read(buffer);
      output.write(buffer, 0, readCnt);

      long end = System.currentTimeMillis();
      System.out.println("파일 복사에 걸린 시간 버퍼: " + (end - start) + "ms(초)");
      input.close();
      output.flush();
      output.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copyFileBufferedStream(Context context, String inputName, String outputName) {
    String filePath = context.getFilesDir().getAbsolutePath();

    try {
      FileInputStream fin = new FileInputStream(filePath + inputName);
      BufferedInputStream bin = new BufferedInputStream(fin);
      FileOutputStream fout = new FileOutputStream(filePath + outputName);
      BufferedOutputStream bout = new BufferedOutputStream(fout);

      long start = System.currentTimeMillis();
      int data = 0;
      while ((data = bin.read()) != -1) {
        bout.write(data);
      }
      long end = System.currentTimeMillis();
      bin.close();
      bout.close();
      fin.close();
      fout.close();
      System.out.println("파일 복사에 걸린 시간 : " + (end - start) + " ms(초)");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
