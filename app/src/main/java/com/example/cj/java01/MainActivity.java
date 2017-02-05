package com.example.cj.java01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {
  private String FILE_NAME = "/ocj5.txt";
  private String COPY_FILE_NAME = "/copy_ocj5.txt";
  private String COPY_FILE_NAME_2 = "/copy_buff_ocj5.txt";
  private String SRC_FILE_NAME = "/cardLogo/logo.png";
  private String DEST_FILE_NAME = "/cardLogo/copied_logo.png";
  private String DEST_FILE_NAME_02 = "/cardLogo/copied_buffer_logo.png";
  private String DEST_FILE_NAME_03 = "/cardLogo/copied_buffered_logo.png";
  private String LOGO_FILE_NAME = "logo.png";
  private String LOGO_DIR_PATH = "/cardLogo/";
  private String INPUT_FILE_NAME = "/ocj5.txt";
  private String OUTPUT_FILE_NAME = "/ocj5.txt";
  private String DIR_NAME = "/fileTest";
//  private ImageView mLogo;
  private NetworkImageView mLogo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    JavaUtils.ArrayTest();
//    JavaUtils.DateTest();
//    JavaUtils.CalendarTest();
//    JavaUtils.FormatterTest();
//    JavaUtils.VectorTest();
//    JavaUtils.EnumerationTest();
//    JavaUtils.StackTest();
//    JavaUtils.QueueTest();
//    JavaUtils.GenericsTest();
//    JavaUtils.ForTest();
//    JavaUtils.GenericBookTest();

//    CollectionUtils.myArrayTest();
//    CollectionUtils.arrayListTest();
//    CollectionUtils.linkedListTest();
//    CollectionUtils.HashSetTest();
//    CollectionUtils.linkedHashSetTest();
//    CollectionUtils.treeSetTest();
//    CollectionUtils.iteratorTest();
//    CollectionUtils.hashMapTest();
//    CollectionUtils.linkedHashMapTest();
    CollectionUtils.treeMapTest();


//    CollectionUtils.sumTest(1,2,3,4);
//    CollectionUtils.addBook("Test","one","two","three","four","five","six");

//    FileManager fileManager = FileManager.getInstance(this);
//    fileManager.createFile();
//    fileManager.createFileStream(FILE_NAME, "test");
//    fileManager.openFileStream(FILE_NAME);
//    fileManager.createFolder("/Download");
//    fileManager.checkFileList("/Download");

//    ByteStreamManager.stdIOTest();
//    try {
//      ByteStreamManager.fileOutputStreamTest(this, FILE_NAME, "OCJ aaa");
//      ByteStreamManager.fileInputStreamTest(this, FILE_NAME);
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }

//    ByteStreamManager.copyFile(this, SRC_FILE_NAME, DEST_FILE_NAME);
//    ByteStreamManager.copyFileBuffer(this, SRC_FILE_NAME, DEST_FILE_NAME_02);
//    ByteStreamManager.copyFileBufferedStream(this, SRC_FILE_NAME, DEST_FILE_NAME_03);

//    try {
//      CharacterManager.encodingTest();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    CharacterManager.fileReaderTest(this, FILE_NAME);
//    CharacterManager.fileWriterTest(this, INPUT_FILE_NAME, DIR_NAME, OUTPUT_FILE_NAME);
//    CharacterManager.fileWriterAppendTest(this, DIR_NAME, OUTPUT_FILE_NAME);
//    CharacterManager.bufferedReaderTest(this, DIR_NAME, OUTPUT_FILE_NAME);
//    CharacterManager.inputStreamReaderTest();
//    try {
//      CharacterManager.printWriterTest(this, DIR_NAME, OUTPUT_FILE_NAME);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    CharacterManager.scannerTest();
//    try {
//      CharacterManager.advancedIOTest(this, DIR_NAME, OUTPUT_FILE_NAME);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }


//    ThreadManager.threadTest();
//    Thread th = new Thread();
//    System.out.println("main thread name: " + th.getName());
//    System.out.println("main thread id: " + th.getId());
//    System.out.println("main thread priority: " + th.getPriority());
//    System.out.println("main thread state: " + th.getState());

//    ThreadManager.myThreadTest();
//    ThreadManager.myThreadRunnableTest();

//    ThreadManager.doWork();
//    ThreadManager.myThreadRunnableRunTest();
//    ThreadManager.simpleThreadTest();

//    ProducerConsumerTest.producerConsumerTest();

//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("NetworkManager inetAddressTest");
////        NetworkManager.inetAddressTest();
//        NetworkManager.IPAddressLocalTest();
//      }
//    }).start();

  }
}
