package com.example.gas;

import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.factory.XDbFactory;
import com.example.model.GasModel;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;

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
				List<GasModel> result = null;
				try {
					result = XDbFactory.getInstance().getDB()
							.findAll(Selector.from(GasModel.class));
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (result != null)
					Log.e("aa", result.toString());
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
		GasModel mGasModel2 = new GasModel();
		mGasModel2.setAmount(888);
		mGasModel2.setData("kkkkkkkkkk");
		mGasModel2.setPrice(8888.8);
		try {
			XDbFactory.getInstance().getDB().save(mGasModel);
			XDbFactory.getInstance().getDB().save(mGasModel2);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
