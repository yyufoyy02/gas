package com.example.myutils;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyImageUtil 
{
	// 缩放/裁剪图片
 	public static Bitmap zoomImg(Bitmap bm, int newWidth ,int newHeight)
 	{ 
 		// 获得图片的宽高
  	   int width = bm.getWidth();
  	   int height = bm.getHeight();
  	   // 计算缩放比例
  	   float scaleWidth = ((float) newWidth) / width;
  	   float scaleHeight = ((float) newHeight) / height;
  	   // 取得想要缩放的matrix参数
  	   Matrix matrix = new Matrix();
  	   matrix.postScale(scaleWidth, scaleHeight);
  	   // 得到新的图片
  	   Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
  	   return newbm;
 	}
 	
 	
 	
 	
 	
 	// 通过路径生成Base64文件
 	public static String getBase64FromPath(String path)
 	{
 		String base64="";
 		try
 		{
 			File file = new File(path);
 			byte[] buffer = new byte[(int) file.length() + 100];  
			@SuppressWarnings("resource")
			int length = new FileInputStream(file).read(buffer);  
 	        base64 = Base64.encodeToString(buffer, 0, length,  Base64.DEFAULT);
 		}
 		catch (IOException e) {
			e.printStackTrace();
		}
 		return base64;
 	}
 	
 	//通过文件路径获取到bitmap
 	public static Bitmap getBitmapFromPath(String path, int w, int h) {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		// 设置为ture只获取图片大小
		opts.inJustDecodeBounds = true;
		opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
		// 返回为空
		BitmapFactory.decodeFile(path, opts);
		int width = opts.outWidth;
		int height = opts.outHeight;
		float scaleWidth = 0.f, scaleHeight = 0.f;
		if (width > w || height > h) {
			// 缩放
			scaleWidth = ((float) width) / w;
			scaleHeight = ((float) height) / h;
		}
		opts.inJustDecodeBounds = false;
		float scale = Math.max(scaleWidth, scaleHeight);
		opts.inSampleSize = (int)scale;
		WeakReference<Bitmap> weak = new WeakReference<Bitmap>(BitmapFactory.decodeFile(path, opts));
		return Bitmap.createScaledBitmap(weak.get(), w, h, true);
	}
 	
 	//把bitmap转换成base64
 	public static String getBase64FromBitmap(Bitmap bitmap, int bitmapQuality)
 	{
 		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
 		bitmap.compress(CompressFormat.PNG, bitmapQuality, bStream);
 		byte[] bytes = bStream.toByteArray();
 		return Base64.encodeToString(bytes, Base64.DEFAULT);
 	}
 	
 	//把base64转换成bitmap
 	public static Bitmap getBitmapFromBase64(String string)
 	{
 		byte[] bitmapArray = null;
 		try {
 		bitmapArray = Base64.decode(string, Base64.DEFAULT);
 		} catch (Exception e) {
 		e.printStackTrace();
 		}
 		return BitmapFactory.decodeByteArray(bitmapArray, 0,bitmapArray.length);
 	}
 	

 
		

}