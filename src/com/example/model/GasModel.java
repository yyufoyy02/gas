package com.example.model;

import java.io.Serializable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.example.util.MyUtil;

@SuppressWarnings("serial")
@Table(name = "GasModels")
public class GasModel extends Model implements Serializable {
	public GasModel() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Column(name = "data")
	private String data;
	@Column(name = "time")
	private String time;
	@Column(name = "mileage")
	private int mileage;
	@Column(name = "price")
	private double price;
	@Column(name = "amount")
	private double amount;
	@Column(name = "oil")
	private double oil;

	public String getData() {
		return MyUtil.isEmpty(data, "");
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTime() {
		return MyUtil.isEmpty(time, "");
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
