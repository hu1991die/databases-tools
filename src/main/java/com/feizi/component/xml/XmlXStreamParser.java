package com.feizi.component.xml;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.InputStream;

/**
 * 使用XStream对xml文件进行解析
 * Created by feizi Ruan on 2017/7/4.
 */
public class XmlXStreamParser {

    /**
     * 将javaBean对象转换成字符串
     * @param object javaBean
     * @return
     */
    public String toXml(Object object){
        XStream xStream = new XStream();
        return xStream.toXML(object);
    }

    /**
     * 将XML字符串转换成javaBean对象
     * @param xmlStr XML字符串
     * @param clazz javaBean对象
     * @param setCallBack
     * @param <T>
     * @return
     */
    public <T> T fromXml(String xmlStr, Class<T> clazz, XmlSetCallBack setCallBack){
        XStream xStream = new XStream();
        setCallBack.config(xStream);
        return (T) xStream.fromXML(xmlStr);
    }

    /**
     * 将xml文件转换成javaBean对象
     * @param file xml文件
     * @param clazz javaBean对象
     * @param xmlSetCallBack
     * @param <T>
     * @return
     */
    public <T> T fromXml(File file, Class<T> clazz, XmlSetCallBack xmlSetCallBack){
        XStream xStream = new XStream();
        xmlSetCallBack.config(xStream);
        return (T) xStream.fromXML(file);
    }

    /**
     * 将输入流转换成javaBean对象
     * @param inputStream 输入流
     * @param clazz javaBean对象
     * @param xmlSetCallBack
     * @param <T>
     * @return
     */
    public <T> T fromXml(InputStream inputStream, Class<T> clazz, XmlSetCallBack xmlSetCallBack){
        XStream xStream = new XStream();
        xmlSetCallBack.config(xStream);
        return (T) xStream.fromXML(inputStream);
    }
}
