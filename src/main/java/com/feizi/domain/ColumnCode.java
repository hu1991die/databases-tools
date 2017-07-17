package com.feizi.domain;

import java.io.Serializable;

/**
 * Created by feizi Ruan on 2017/7/4.
 */
public class ColumnCode implements Serializable{

    private static final long serialVersionUID = -6189835693698279125L;
    //约束
    private String code;
    //字段名
    private String name;

    public ColumnCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
