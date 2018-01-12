package com.mincat.sample.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @author Michael
 * @描述 获取手机状态
 */
public final class SIMCardInfo {

	public static final String TAG = "SIMCardInfo";
	private TelephonyManager telephonyManager;

	private String IMSI;

	public SIMCardInfo(Context context) {

		telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
	}

	// 获取手机的本机号码
	public String getNativePhoneNumber() {
		String NativePhoneNumber = null;

		NativePhoneNumber = telephonyManager.getLine1Number();

		return NativePhoneNumber;
	}

	// 获取手机运营商信息
	public String getProvidersName() {
//		String ProvidersName = null;
//		// 返回唯一的用户ID;就是这张卡的编号神马的
//		IMSI = telephonyManager.getSubscriberId();
//		// IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
//		System.out.println(IMSI);
//		L.i(TAG, "SIMCardInfo:" + IMSI);
//		if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
//			ProvidersName = "中国移动";
//		} else if (IMSI.startsWith("46001")) {
//			ProvidersName = "中国联通";
//		} else if (IMSI.startsWith("46003")) {
//			ProvidersName = "中国电信";
//		}
//		return ProvidersName;
		return null;
	}
}
