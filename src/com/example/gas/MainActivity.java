package com.example.gas;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;

import com.cengalabs.flatui.FlatUI;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.fragment.ThirdFragment;
import com.example.ui.base.IndicatorFragmentActivity;

public class MainActivity extends IndicatorFragmentActivity implements
		OnMenuItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(false);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.main, menu);
		MenuItem actionItem = menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "添加");
		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		actionItem.setOnMenuItemClickListener(this);
		return true;
	}

	@Override
	protected int supplyTabs(List<TabInfo> tabs) {
		// TODO Auto-generated method stub
		tabs.add(new TabInfo(0, getString(R.string.fragment_one),
				FirstFragment.class));
		tabs.add(new TabInfo(1, getString(R.string.fragment_two),
				SecondFragment.class));
		tabs.add(new TabInfo(2, getString(R.string.fragment_three),
				ThirdFragment.class));
		return 0;
	}

	@Override
	public int getContentViewId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		setTitle("油耗软件");
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case Menu.FIRST:
			startActivity(new Intent(MainActivity.this, GasEditActivity.class));
			break;

		default:
			break;
		}
		return false;
	}

}
