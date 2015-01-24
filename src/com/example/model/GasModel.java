package com.example.model;

import java.io.Serializable;

import com.example.myutils.MyStringUtil;
import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

@SuppressWarnings("serial")
@Table(name = "GasModels")
public class GasModel extends BaseModel implements Serializable {
	public GasModel() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Column(column = "data")
	private String data;
	@Column(column = "time")
	private String time;
	@Column(column = "mileage")
	private int mileage;
	@Column(column = "price")
	private double price;
	@Column(column = "amount")
	private double amount;
	@Column(column = "oil")
	private double oil;

	public String getData() {
		return MyStringUtil.isEmpty(data, "");
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTime() {
		return MyStringUtil.isEmpty(time, "");
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getOil() {
		return oil;
	}

	public void setOil(double oil) {
		this.oil = oil;
	}
}
