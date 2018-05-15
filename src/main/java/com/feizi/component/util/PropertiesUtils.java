package com.feizi.component.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: feizi Ruan
 * @Description: 读取配置文件
 * @Date: Created by 19:41 on 2017/6/1.
 * @Modified By: feizi Ruan
 */
public final class PropertiesUtils {
    /**配置文件名称*/
    private static String configFileName;
    /**配置文件路径*/
    private static String path;
    /**配置文件后缀名称*/
    private static final String SUFFIX_NAME = ".properties";
    /**配置文件实例对象*/
    private static Properties properties = null;

    private PropertiesUtils() {
    }

    /**
     * 初始化配置
     * @param path
     * @param configFileName
     */
    public static void init(String path, String configFileName){
        PropertiesUtils.path = path;
        PropertiesUtils.configFileName = configFileName;
    }

    /**
     * 获取配置文件
     * @return
     */
    public static Properties getProperties(){
        if(null != properties){
            return properties;
        }

        InputStream ins = null;
        try {
            properties = new Properties();
            ins = PropertiesUtils.class.getResourceAsStream(path + "/" + configFileName + SUFFIX_NAME);
            properties.load(ins);
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件失败，请检查路径是否正确！");
        }finally {
            //关闭流
            if(null != ins){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
