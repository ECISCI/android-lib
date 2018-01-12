package com.mincat.sample.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


import com.mincat.sample.R;

import java.security.NoSuchAlgorithmException;

/**
 * @author Mings
 * @描述 SharedPreferences工具类
 */
public class SpUtils {
    public static final String TAG = SpUtils.class.getName();
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    // 构造函数私有化
    private SpUtils() {
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @param context  上下文对象
     * @描述 保存用户登录信息
     */
    public static void setLoginInfo(String username, String password, String user_id,
                                    Context context) {
        SharedPreferences sp;
        SharedPreferences.Editor editor;
        try {
            sp = context.getSharedPreferences(Constants.CONFIG,
                    Context.MODE_PRIVATE);
            editor = sp.edit();
            String md5Password = MD5.getMd5(password);
            editor.putString(Constants.USER_NAME, username);
            editor.putString(Constants.PASS_WORD, md5Password);
            editor.putString(Constants.USER_ID, user_id);
            editor.commit();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            L.i(TAG, context.getString(R.string.encryption_failed) + e);
        } catch (Exception e) {

            L.e(TAG, context.getString(R.string.save_user_info_failed) + e);
        }
    }


    /**
     * 清除用户信息
     *
     * @param context 上下文对象
     * @return 清除用户信息是否成功
     */
    public static boolean clearUserInfo(Context context) {

        SharedPreferences sp;

        SharedPreferences.Editor editor;

        try {
            sp = context.getSharedPreferences(Constants.CONFIG,
                    Context.MODE_PRIVATE);
            editor = sp.edit();
            String username = sp.getString(Constants.USER_NAME,
                    Constants.NULL_STRING);
            String password = sp.getString(Constants.PASS_WORD,
                    Constants.NULL_STRING);

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                editor.clear();
                editor.commit();
                return true;
            }
        } catch (Exception e) {
            L.e(TAG, context.getString(R.string.clear_user_info_failed)
                    + e);
            return false;
        }
        return false;
    }


    /**
     * 清空数据
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constants.CONFIG,
                Context.MODE_PRIVATE);
        sp.edit().clear().commit();
        SharedPreferences spa = context.getSharedPreferences(Constants.USERINFO,
                Context.MODE_PRIVATE);
        spa.edit().clear().commit();
    }
}
