package com.feizi.domain;

import java.io.Serializable;

/**
 * 列结构基本信息
 * Created by feizi Ruan on 2017/7/4.
 */
public class ColumnInfo implements Serializable{
    private static final long serialVersionUID = 610003869585115152L;

    //字段名称
    private String columnName;
    //数据类型
    private String dataType;
    //字段描述
    private String columnComment;
    //是否主键
    private String columnKey;
    //字段长度
    private String columnType;
    //是否为空
    private String isNullAble;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getIsNullAble() {
        return isNullAble;
    }

    public void setIsNullAble(String isNullAble) {
        this.isNullAble = isNullAble;
    }
}
