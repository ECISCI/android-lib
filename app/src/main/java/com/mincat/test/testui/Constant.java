package com.mincat.test.testui;

/**
 * @author Mings
 * @描述 常量
 */

public class Constant {

    /**
     * 测试请求地址 Get
     *
     * @param cityEncode 城市编码
     * @return
     */
    public static String getJuHeWeather(String cityEncode) {

        return "http://op.juhe.cn/onebox/weather/query?cityname=" + cityEncode + "&key=bf5e0ec5c949eb84ca3e4ee2c37b541e";

    }

    /**
     * 请求地址 post
     */
    public static final String BASE_URL = "https://www.horus.net.cn/ucenter/api";

    public static final String LOGIN = BASE_URL + "/login";

    /**
     * 加载封面图片
     */
    public static final String IMAGE_ON_VIDEO = "http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg";

    /**
     * 网络视频测试路径
     */
    public static final String VIDEO_NET_URL = "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4";
    /**
     * 测试图片地址
     */
    public static final String CACHE_IMAGE_URL = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
    /**
     * 测试图片地址
     */
    public static final String CACHE_IMAGE_URL_01 = "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg";
    public static final String CACHE_IMAGE_URL_02 = "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg";
    public static final String CACHE_IMAGE_URL_03 = "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg";
    public static final String CACHE_IMAGE_URL_04 = "http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg";
    public static final String CACHE_IMAGE_URL_05 = "http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg";
    public static final String CACHE_IMAGE_URL_06 = "http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg";
    public static final String CACHE_IMAGE_URL_07 = "http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg";
    public static final String CACHE_IMAGE_URL_08 = "http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg";
    public static final String CACHE_IMAGE_URL_09 = "http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg";
    public static final String CACHE_IMAGE_URL_10 = "http://img.my.csdn.net/uploads/201407/26/1406383264_8243.jpg";

}
