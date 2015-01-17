package com.example.util;

import android.text.TextUtils;

public class MyUtil {
	/** 是否为空 */
	public static Boolean isEmpty(String str) {
		if (TextUtils.isEmpty(str) || str.equals("null")) {
			return true;
		} else {
			return false;
		}

	}

	/** 为空输出默认值 */
	public static String isEmpty(String str, String defaultext) {
		if (TextUtils.isEmpty(str)) {
			return defaultext;
		} else {
			return str;
		}

	}

}
