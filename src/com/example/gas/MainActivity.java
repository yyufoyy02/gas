package com.example.gas;

import java.util.List;

import android.os.Bundle;

import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.fragment.ThirdFragment;
import com.example.ui.base.IndicatorFragmentActivity;

public class MainActivity extends IndicatorFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
