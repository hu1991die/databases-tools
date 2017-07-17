package com.feizi.service;

import com.feizi.BaseTest;
import com.feizi.domain.ColumnInfo;
import com.feizi.domain.TableInfo;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
public class DatabaseStructureServiceTest extends BaseTest{

    private static Logger logger = LoggerFactory.getLogger(DatabaseStructureServiceTest.class);

    @Resource
    private DatabaseStructureService databaseStructureService;

    @Test
    public void testQueryTableInfoList() throws Exception {
        List<TableInfo> tableInfoList = databaseStructureService.queryTableInfoList("lmstest", module);
        Assert.assertNotNull(tableInfoList);
        logger.info(String.valueOf(tableInfoList.size()));
    }

    @Test
    public void testQueryColumnInfoList() throws Exception {
        List<ColumnInfo> columnInfoList = databaseStructureService.queryColumnInfoList("lmstest", "tb_lb_applyinfo");
        Assert.assertNotNull(columnInfoList);
        logger.info(String.valueOf(columnInfoList.size()));
    }
}