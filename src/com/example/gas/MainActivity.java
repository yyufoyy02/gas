package com.example.gas;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.cengalabs.flatui.FlatUI;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.fragment.ThirdFragment;
import com.example.ui.base.IndicatorFragmentActivity;

public class MainActivity extends IndicatorFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setBackgroundDrawable(
				FlatUI.getActionBarDrawable(this,
						MyApplication.getInstance().Theme, false, 2));
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		findViewById(R.id.tv_home_add).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(MainActivity.this,
								GasEditActivity.class));
					}
				});
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

}
