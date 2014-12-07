package com.example.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gas.R;

/**
 * 最热
 * 
 * @author Administrator
 * 
 */
public class FirstFragment extends Fragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup p = (ViewGroup) view.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();

		}
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = getActivity().getLayoutInflater().inflate(
				R.layout.firstfragment, null, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	/**
	 * 界面回调
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

	}

	@Override
	public void onPause() {
		super.onPause();

	}
}
