package com.feizi.component.util;

/**
 * @Author: feizi Ruan
 * @Description: 字符串工具类
 * @Date: Created by 20:01 on 2017/6/1.
 * @Modified By: feizi Ruan
 */
public final class StringUtils {
    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return
     */
    public static boolean isBlank(String str){
        return null == str || str.trim().length() == 0;
    }
}
