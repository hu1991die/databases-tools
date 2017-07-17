package com.feizi.dao;

import com.feizi.BaseTest;
import com.feizi.domain.TableInfo;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
public class DatabaseStructureDaoTest extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(DatabaseStructureDaoTest.class);

    @Resource
    private DatabaseStructureDao databaseStructureDao;

    @Test
    public void testQueryTableInfoListBySchemaName() throws Exception {
        List<TableInfo> tableInfoList = databaseStructureDao.queryTableInfoListBySchemaName("lmstest");
        Assert.assertNotNull(tableInfoList);
        logger.info(String.valueOf(tableInfoList.size()));
    }

    @Test
    public void testQueryTableInfoListBySchemaNameAndPerfix() throws Exception {
        List<TableInfo> tableInfoList = databaseStructureDao.queryTableInfoListBySchemaNameAndPerfix("lmstest", "tb_lb");
        Assert.assertNotNull(tableInfoList);
        logger.info(String.valueOf(tableInfoList.size()));
    }

    @Test
    public void testQueryTableInfoListBySchemaNameAndTableArray() throws Exception {
        String[] tableNameArray = new String[]{"tb_lb_applyinfo", "tb_cp_parminfo", "tb_car_model"};
        Map<String, Object> params = new HashMap<>();
        params.put("schemaName", "lmstest");
        params.put("tableNameArray",tableNameArray);

        List<TableInfo> tableInfoList = databaseStructureDao.queryTableInfoListBySchemaNameAndTableArray(params);
        Assert.assertNotNull(tableInfoList);
        logger.info(String.valueOf(tableInfoList.size()));
    }

    @Test
    public void testQueryColumnInfo() throws Exception {

    }
}