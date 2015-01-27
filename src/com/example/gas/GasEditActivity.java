package com.example.gas;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;

import com.example.factory.XDbFactory;
import com.example.model.GasModel;
import com.example.myutils.MyStringUtil;
import com.example.myutils.MyTimeUtils;
import com.example.myutils.MyToast;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ViewInject;

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
		edtDate.setInputType(InputType.TYPE_CLASS_DATETIME);
		edtTime.setInputType(InputType.TYPE_CLASS_DATETIME);
		edtAmount.setInputType(InputType.TYPE_CLASS_PHONE);
		initEdit(edtAmount);
		edtPrice.setInputType(InputType.TYPE_CLASS_PHONE);
		initEdit(edtPrice);
		edtOil.setInputType(InputType.TYPE_CLASS_PHONE);
		initEdit(edtOil);
		edtMileage.setInputType(InputType.TYPE_CLASS_NUMBER);
	}

	private void initEdit(final EditText edit) {

		edit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.toString().contains(".")) {
					if (s.length() - 1 - s.toString().indexOf(".") > 2) {
						s = s.toString().subSequence(0,
								s.toString().indexOf(".") + 3);
						edit.setText(s);
						edit.setSelection(s.length());
					}
				}
				if (s.toString().trim().substring(0).equals(".")) {
					s = "0" + s;
					edit.setText(s);
					edit.setSelection(2);
				}

				if (s.toString().startsWith("0")
						&& s.toString().trim().length() > 1) {
					if (!s.toString().substring(1, 2).equals(".")) {
						edit.setText(s.subSequence(0, 1));
						edit.setSelection(1);
						return;
					}
				}
				if (s.toString().indexOf("..") > 0) {
					s = s.toString().replace("..", ".");
					edit.setText(s);
					edit.setSelection(s.length());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

		});

	}

	private void submit() {
		if (MyStringUtil.isEmpty(edtDate.getText().toString())) {
			MyToast.showToast(mContext, "请填写日期", 1500);
			return;
		} else if (MyStringUtil.isEmpty(edtTime.getText().toString())) {
			MyToast.showToast(mContext, "请填写时间", 1500);
			return;
		} else if (MyStringUtil.isEmpty(edtMileage.getText().toString())) {
			MyToast.showToast(mContext, "请填写里程", 1500);
			return;
		} else if (MyStringUtil.isEmpty(edtPrice.getText().toString())) {
			MyToast.showToast(mContext, "请填写单价", 1500);
			return;
		} else if (MyStringUtil.isEmpty(edtAmount.getText().toString())) {
			MyToast.showToast(mContext, "请填写金额", 1500);
			return;
		} else if (MyStringUtil.isEmpty(edtOil.getText().toString())) {
			MyToast.showToast(mContext, "请填写油量", 1500);
			return;
		} else {
			GasModel mGasModel = new GasModel();
			mGasModel.setAmount(Double.parseDouble(edtAmount.getText()
					.toString()));
			long data = MyTimeUtils.getTimestampFromString(edtDate.getText()
					.toString(), MyTimeUtils.FORMAT_DATE);
			if (data != 0) {
				mGasModel.setData(data);
			} else {
				MyToast.showToast(mContext, "日期格式错误", 1500);
				return;
			}
			long time = MyTimeUtils.getTimestampFromString(edtTime.getText()
					.toString(), MyTimeUtils.FORMAT_TIME);
			if (time != 0) {
				mGasModel.setTime(time);
			} else {
				MyToast.showToast(mContext, "时间格式错误", 1500);
				return;
			}
			mGasModel.setPrice(Double
					.parseDouble(edtPrice.getText().toString()));
			mGasModel.setMileage(Integer.parseInt(edtMileage.getText()
					.toString()));

			mGasModel.setOil(Double.parseDouble(edtOil.getText().toString()));

			// try {
			// XDbFactory.getInstance().getDB().save(mGasModel);
			// } catch (DbException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// MyToast.showToast(mContext, "保存失败", 1500);
			// return;
			// }
			// finish();
		}
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
			submit();
			break;

		default:
			break;
		}
		return false;
	}
}
