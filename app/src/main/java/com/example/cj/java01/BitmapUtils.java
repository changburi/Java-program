package com.example.cj.java01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cj on 2017-01-25.
 */

public class BitmapUtils {
  public static boolean createBitmapImage(Context context, String folderName, String fileName, int resId) {
    File file = context.getFilesDir();
    String localPath = file.getAbsolutePath() + folderName;
    System.out.println(localPath);
    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
    try {
      File filePath = new File(localPath);
      if (filePath.isDirectory() == false) {
        filePath.mkdirs();
      }

      FileOutputStream fos = new FileOutputStream(localPath + fileName);

//      bitmap.createScaledBitmap(bitmap, 36, 36, false);
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
      fos.flush();
      fos.close();
      return true;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static Uri getLogoUri(Context context, String localPath, String fileName) {
    File file = new File(context.getFilesDir().getAbsolutePath(), localPath + fileName);
    System.out.println(file.getAbsolutePath());
    System.out.println(" getLogoUri : " + Uri.fromFile(file));
    return Uri.fromFile(file);
  }

}
