package com.example.gas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {
	public abstract int getContentViewId();

	public abstract void initListener();

	public abstract void initData();

	public abstract void findIdByView();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getContentViewId() != 0) {
			setContentView(getContentViewId());
		}
		findIdByView();
		initData();
		initListener();
	}
}
