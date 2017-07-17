package com.feizi.service;

import com.feizi.domain.ColumnInfo;
import com.feizi.domain.Module;
import com.feizi.domain.TableInfo;

import java.util.List;

/**
 * 数据库查询服务接口
 * Created by feizi Ruan on 2017/7/17.
 */
public interface DatabaseStructureService {
    /**
     * 根据模块查询该模块数据表集合
     * @param schemaName 数据库名称
     * @param module 模块
     * @return
     */
    List<TableInfo> queryTableInfoList(String schemaName, Module module);

    /**
     * 根据表名称查询该表的表的列字段集合
     * @param schemaName 数据库名称
     * @param tableName 数据表名称
     * @return
     */
    List<ColumnInfo> queryColumnInfoList(String schemaName, String tableName);
}
