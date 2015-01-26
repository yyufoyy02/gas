package com.example.gas;

import java.util.List;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.factory.XDbFactory;
import com.example.model.GasModel;
import com.example.myutils.MyToast;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class GasEditActivity extends BaseActivity implements
		OnMenuItemClickListener {
	@ViewInject(R.id.edt_gasedit_date)
	private EditText edtDate;
	@ViewInject(R.id.edt_gasedit_time)
	private EditText edtTime;
	@ViewInject(R.id.edt_gasedit_mileage)
	private EditText edtMileage;
	@ViewInject(R.id.edt_gasedit_price)
	private EditText edtPrice;
	@ViewInject(R.id.edt_gasedit_amount)
	private EditText edtAmount;
	@ViewInject(R.id.edt_gasedit_oil)
	private EditText edtOil;

	@Override
	public int getContentViewId() {
		// TODO Auto-generated method stub
		return R.layout.gaseditactivity_main;
	}

	// @OnClick(R.id.edt_gasedit_date)
	// private void a(View v) {
	// MyToast.showToast(mContext, "测试", 1500);
	// }

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.main, menu);
		MenuItem actionItem = menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "保存");
		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		actionItem.setOnMenuItemClickListener(this);
		return true;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		setTitle("增加");

		// GasModel mGasModel = new GasModel();
		// mGasModel.setAmount(99);
		// mGasModel.setData("hhhhhhhhh");
		// mGasModel.setPrice(99.99);
		// mGasModel.setMileage(99);
		// GasModel mGasModel2 = new GasModel();
		// mGasModel2.setAmount(888);
		// mGasModel2.setData("kkkkkkkkkk");
		// mGasModel2.setPrice(8888.8);
		// try {
		// XDbFactory.getInstance().getDB().save(mGasModel);
		// XDbFactory.getInstance().getDB().save(mGasModel2);
		// } catch (DbException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case Menu.FIRST:
			// List<GasModel> result = null;
			// try {
			// result = XDbFactory.getInstance().getDB()
			// .findAll(Selector.from(GasModel.class));
			// } catch (DbException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// if (result != null)
			// Log.e("aa", result.toString());
			finish();
			break;

		default:
			break;
		}
		return false;
	}
}
