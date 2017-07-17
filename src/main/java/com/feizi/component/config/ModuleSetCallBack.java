package com.feizi.component.config;

import com.feizi.domain.Module;
import com.feizi.domain.ModuleList;
import com.feizi.component.xml.XmlSetCallBack;
import com.thoughtworks.xstream.XStream;

/**
 * 配置xml解析属性
 * Created by feizi Ruan on 2017/7/17.
 */
public class ModuleSetCallBack implements XmlSetCallBack{
    public void config(Object obj) {
        XStream xStream = (XStream) obj;
        xStream.alias("moduleList", ModuleList.class);
        xStream.alias("module", Module.class);
        xStream.aliasField("module", ModuleList.class, "moduleList");
        xStream.addImplicitCollection(ModuleList.class, "moduleList");
        xStream.useAttributeFor("moduleName", String.class);
        xStream.useAttributeFor("exportType", String.class);
        xStream.useAttributeFor("tableName", String.class);
    }
}
