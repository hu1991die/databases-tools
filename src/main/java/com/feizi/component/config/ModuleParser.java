package com.feizi.component.config;

import com.feizi.domain.ModuleList;
import com.feizi.component.util.PropertiesUtils;
import com.feizi.component.xml.XmlXStreamParser;

import java.io.InputStream;

/**
 * 解析xml文件
 * Created by feizi Ruan on 2017/7/4.
 */
public class ModuleParser {
    private static ModuleList moduleList = null;

    public static ModuleList getModuleList(String filePath){
        if(null != moduleList){
            return moduleList;
        }

        XmlXStreamParser xmlXStreamParser = new XmlXStreamParser();
        InputStream inputStream = PropertiesUtils.class.getResourceAsStream(filePath);
        moduleList = xmlXStreamParser.fromXml(inputStream, ModuleList.class, new ModuleSetCallBack());
        return moduleList;
    }
}
