package com.feizi.component.xml;

/**
 * 使用XStream的元素属性设置，解析xml文件
 * Created by feizi Ruan on 2017/7/4.
 */
public interface XmlSetCallBack {

    /**
     * 配置XStream元素及属性
     * @param obj
     */
    void config(Object obj);
}
