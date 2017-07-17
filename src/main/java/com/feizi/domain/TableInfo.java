package com.feizi.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 表结构基本信息
 * Created by feizi Ruan on 2017/7/4.
 */
public class TableInfo implements Serializable{
    private static final long serialVersionUID = -6972254939538206327L;

    //表名称
    private String tableName;
    //表注释
    private String tableComment;
    //表结构字段集合
    private List<ColumnInfo> columnInfoList = null;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<ColumnInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }
}
