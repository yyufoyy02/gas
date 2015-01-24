package com.example.gas;

import com.example.factory.XDbFactory;
import com.example.myutils.MyLogger;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static MyApplication sInstance;
	public Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
		mContext = getApplicationContext();
		DataInit();
		DebugMode(true);

	}

	private void DebugMode(boolean b) {
		// TODO Auto-generated method stub
		MyLogger.setDebugMode(b);
		XDbFactory.getInstance().getDB().configDebug(b);
	}

	private void DataInit() {
		// TODO Auto-generated method stub
		XDbFactory.getInstance().init(mContext);
	}

	/**
	 * synchronized
	 * 
	 * @return ApplicationController singleton instance
	 */
	public static MyApplication getInstance() {

		return sInstance;
	}
}
