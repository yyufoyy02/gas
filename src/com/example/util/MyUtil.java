package com.example.util;

import android.text.TextUtils;

public class MyUtil {
	/** �Ƿ�Ϊ�� */
	public static Boolean isEmpty(String str) {
		if (TextUtils.isEmpty(str) || str.equals("null")) {
			return true;
		} else {
			return false;
		}

	}

	/** Ϊ�����Ĭ��ֵ */
	public static String isEmpty(String str, String defaultext) {
		if (TextUtils.isEmpty(str)) {
			return defaultext;
		} else {
			return str;
		}

	}

}
