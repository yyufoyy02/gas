package com.example.gas;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.factory.XDbFactory;
import com.example.model.GasModel;
import com.lidroid.xutils.DbUtils;

public class GasEditActivity extends BaseActivity {
	private EditText edtDate, edtTime, edtMileage, edtPrice, edtAmount, edtOil;
	private Button submit;

	@Override
	public void findIdByView() {
		// TODO Auto-generated method stub
		edtDate = (EditText) findViewById(R.id.edt_gasedit_date);
		edtTime = (EditText) findViewById(R.id.edt_gasedit_time);
		edtMileage = (EditText) findViewById(R.id.edt_gasedit_mileage);
		edtPrice = (EditText) findViewById(R.id.edt_gasedit_price);
		edtAmount = (EditText) findViewById(R.id.edt_gasedit_amount);
		edtOil = (EditText) findViewById(R.id.edt_gasedit_oil);
		submit = (Button) findViewById(R.id.submit);
	}

	@Override
	public int getContentViewId() {
		// TODO Auto-generated method stub
		return R.layout.gaseditactivity_main;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// List<GasModel> result = new Select().from(GasModel.class)
				// .execute();
				// Log.e("aa", result.toString());
			}
		});
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		GasModel mGasModel = new GasModel();
		mGasModel.setAmount(99);
		mGasModel.setData("hhhhhhhhh");
		mGasModel.setPrice(99.99);
		mGasModel.setMileage(99);
		XDbFactory.getInstance().getDB().save(mGasModel);
		GasModel mGasModel2 = new GasModel();
		mGasModel2.setAmount(888);
		mGasModel2.setData("kkkkkkkkkk");
		mGasModel2.setPrice(8888.8);
		XDbFactory.getInstance().getDB().save(mGasModel);
	}

}
