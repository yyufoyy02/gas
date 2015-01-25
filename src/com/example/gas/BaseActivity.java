package com.example.gas;

import com.cengalabs.flatui.FlatUI;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

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
		getActionBar().setBackgroundDrawable(
				FlatUI.getActionBarDrawable(this,
						MyApplication.getInstance().Theme, false, 2));
		findIdByView();
		initData();
		initListener();
	}
}
