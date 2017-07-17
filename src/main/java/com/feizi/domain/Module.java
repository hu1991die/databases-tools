package com.feizi.domain;

import java.io.Serializable;

/**
 * 模块类
 * Created by feizi Ruan on 2017/7/4.
 */
public class Module implements Serializable{
    private static final long serialVersionUID = -11262188140141388L;

    //模块名称
    private String moduleName;
    //导出类型
    private String exportType;
    //导出表的名称
    private String tableName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
