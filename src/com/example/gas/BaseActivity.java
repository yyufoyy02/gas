package com.example.gas;

import com.cengalabs.flatui.FlatUI;
import com.lidroid.xutils.ViewUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

public abstract class BaseActivity extends FragmentActivity {
	public Context mContext;

	public abstract int getContentViewId();

	public abstract void initData();

	/** 设置监听器 */
	public abstract void initListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getContentViewId() != 0) {
			setContentView(getContentViewId());
			ViewUtils.inject(this); // 注入view和事件
		}
		mContext = this;
		getActionBar().setBackgroundDrawable(
				FlatUI.getActionBarDrawable(this,
						MyApplication.getInstance().Theme, false, 2));
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowTitleEnabled(true);
		initData();
		initListener();
	}
}
