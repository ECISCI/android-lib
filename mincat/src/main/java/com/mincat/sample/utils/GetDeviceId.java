package com.mincat.sample.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @author Mings
 * @描述 获取设备ID
 */

public class GetDeviceId {

    public static String getDeviceId(Context context) {

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String DEVICE_ID = tm.getDeviceId();

        return DEVICE_ID;
    }


}
