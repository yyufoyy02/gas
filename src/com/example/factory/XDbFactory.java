package com.example.factory;

import com.lidroid.xutils.DbUtils;

import android.content.Context;

/**
 * 数据库工厂
 * 
 * @author LWJ
 * 
 */
public class XDbFactory {
	DbUtils db;

	// 单例模式实例化类
	static class Holder {
		private static XDbFactory instance = new XDbFactory();
	}

	private XDbFactory() {
	}

	public static XDbFactory getInstance() {
		return Holder.instance;
	}

	public void init(Context mContext) {
		db = DbUtils.create(mContext);
	}

	public void init(Context mContext, String dbName) {
		db = DbUtils.create(mContext, dbName);
	}

	public DbUtils getDB() {
		return db;
	}
}