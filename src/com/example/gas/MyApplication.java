package com.example.gas;

import com.activeandroid.ActiveAndroid;

public class MyApplication extends com.activeandroid.app.Application {
	@Override
	public void onCreate() {
		super.onCreate();
		ActiveAndroid.initialize(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		ActiveAndroid.dispose();
	}
}
