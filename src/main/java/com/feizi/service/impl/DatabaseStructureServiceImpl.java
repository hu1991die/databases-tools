package com.feizi.service.impl;

import com.feizi.component.constant.ModuleConstant;
import com.feizi.dao.DatabaseStructureDao;
import com.feizi.domain.ColumnInfo;
import com.feizi.domain.Module;
import com.feizi.domain.TableInfo;
import com.feizi.service.DatabaseStructureService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * 数据库查询服务接口实现类
 * Created by feizi Ruan on 2017/7/17.
 */
@Service
public class DatabaseStructureServiceImpl implements DatabaseStructureService {

    @Resource
    private DatabaseStructureDao databaseStructureDao;

    @Override
    public List<TableInfo> queryTableInfoList(String schemaName, Module module) {
        List<TableInfo> tableInfoList = new ArrayList<>();

        //获取配置的导出类型
        String exportType = module.getExportType();

        //判断导出类型
        if(ModuleConstant.EXPORT_TYPE_ALL.equals(exportType)){
            //查询所有的表结构列表
            tableInfoList = databaseStructureDao.queryTableInfoListBySchemaName(schemaName);
        }else if(ModuleConstant.EXPORT_TYPE_ARRAY.equals(exportType)){
            //根据指定的table表名称查询
            String[] tableNameArray = module.getTableName().split(",");
            Map<String, Object> params = new HashMap<>();
            params.put("schemaName", schemaName);
            params.put("tableNameArray", tableNameArray);

            tableInfoList = databaseStructureDao.queryTableInfoListBySchemaNameAndTableArray(params);
        }else if (ModuleConstant.EXPORT_TYPE_PREFIX.equals(exportType)){
            //根据指定的table类型查询
            String tablePerfix = module.getTableName();
            tableInfoList = databaseStructureDao.queryTableInfoListBySchemaNameAndPerfix(schemaName, tablePerfix);
        }
        return tableInfoList;
    }

    @Override
    public List<ColumnInfo> queryColumnInfoList(String schemaName, String tableName) {
        return databaseStructureDao.queryColumnInfoList(schemaName, tableName);
    }
}
