package com.example.cj.java01;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cj on 2017-01-22.
 */

public class FileManager {
  private static Context mContext;
  protected static FileManager sInstance;
  private static String FILE_NAME = "ocj.txt";

  private FileManager(Context context) {
    mContext = context;
    System.out.println(context.getFilesDir());
  }

  public static FileManager getInstance(Context context) {
    if (sInstance == null) {
      sInstance = new FileManager(context);
    }
    return sInstance;
  }

  public static void createFile() {
    System.out.println("createFile : " + mContext.getFilesDir());

    File file = new File(mContext.getFilesDir(), FILE_NAME);
    try {
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (file.exists()) {
      String fileName = file.getName();
      System.out.println("File Name : " + fileName);
      System.out.println("Absolute Path : " + file.getAbsolutePath());
      System.out.println("Path : " + file.getPath());
      try {
        System.out.println("Canonical Path : " + file.getCanonicalPath());
        System.out.println("Canonical File : " + file.getCanonicalFile());
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Parent : " + file.getParent());
      System.out.println("Parent File : " + file.getParentFile());
      System.out.println("Absolute File : " + file.getAbsoluteFile());

      if (file.canWrite()) {
        System.out.println(fileName + " 은 쓸 수 있다.");
      }
      if (file.canRead()) {
        System.out.println(fileName + " 은 읽을 수 있다. ");
      }
      if (file.isFile()) {
        System.out.println(fileName + " 은 파일이다. ");
      }
      if (file.isDirectory()) {
        System.out.println(fileName + " 은 폴더다. ");
      }
      System.out.println(fileName + " 의 크기는 " + file.length() + " 이다. ");
    } else {
      System.out.println("File does not created");
    }
  }

  public static void createFileStream(String fileName, String str) {
    FileOutputStream fos = null;
    try {
      fos = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
      fos.write(str.getBytes());
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String openFileStream(String fileName) {
    String result = null;
    try {
      FileInputStream fis = mContext.openFileInput(fileName);
      byte[] str = new byte[fis.available()];
      while (fis.read(str) != -1) {}
      fis.close();
      result =  new String(str);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("파일스트림 : " + result.toString());
    return result;
  }


  public static void createFolder(String folderName) {
    File dir = new File(mContext.getFilesDir() + folderName);
    dir.mkdir();
    if (dir.isDirectory()) {
      System.out.println(dir + " 은 폴더");
    } else {
      System.out.println(dir + " 은 폴더가 아닙니다. ");
    }
  }

  public static void checkFileList(String folderName) {
    File dir = new File(mContext.getFilesDir() + folderName);

    if (dir.isDirectory()) {
      String[] fileList = dir.list();
      for (int i = 0; i < fileList.length; i++) {
        System.out.println("file list : " + fileList[i]);
      }
      System.out.println(dir + " 객체는 폴더다.");
    } else {
      System.out.println(dir + " 객체는 폴더가 아니다.");
    }
  }
}
