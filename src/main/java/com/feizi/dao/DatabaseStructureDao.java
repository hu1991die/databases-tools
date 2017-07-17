package com.feizi.dao;

import com.feizi.domain.ColumnInfo;
import com.feizi.domain.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
@Mapper
public interface DatabaseStructureDao {
    /**
     * 根据数据库名（schema）查询数据表列表
     * @param schemaName 数据库名称
     * @return
     */
    List<TableInfo> queryTableInfoListBySchemaName(String schemaName);

    /**
     * 根据数据库名和数据表名前缀查询数据表列表
     * @param schemaName 数据库名称
     * @param tablePerfix 数据表名前缀
     * @return
     */
    List<TableInfo> queryTableInfoListBySchemaNameAndPerfix(@Param("schemaName") String schemaName, @Param("tablePerfix") String tablePerfix);

    /**
     * 根据数据库名和数据表名数组查询数据表列表
     * @param params Map参数
     * @return
     */
    List<TableInfo> queryTableInfoListBySchemaNameAndTableArray(Map<String, Object> params);

    /**
     * 根据数据库名称和数据表名称查询表的列字段列表信息
     * @param schemaName 数据库名称
     * @param tableName 数据表名称
     * @return
     */
    List<ColumnInfo> queryColumnInfoList(@Param("schemaName") String schemaName, @Param("tableName") String tableName);
}
