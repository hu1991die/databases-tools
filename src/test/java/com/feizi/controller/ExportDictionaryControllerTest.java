package com.feizi.controller;

import com.feizi.BaseTest;
import com.feizi.component.properties.CustomProperties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * ExportDictionaryController测试用例
 * Created by feizi Ruan on 2017/7/17.
 */
public class ExportDictionaryControllerTest extends BaseTest{

    private static Logger logger = LoggerFactory.getLogger(ExportDictionaryControllerTest.class);

    @Resource
    private ExportDictionaryController exportDictionaryController;

    @Resource
    private CustomProperties customProperties;

    @Test
    public void testExportDictionary() throws Exception {
        long startTime = System.currentTimeMillis();
        exportDictionaryController.exportDictionary(htmlTemplateFile, module);
        long endTime = System.currentTimeMillis();

        logger.info("执行成功，总共耗时：" + ((endTime - startTime) / 1000)
                + "秒，请查看输出结果文件夹:" + customProperties.getExportFolder());
    }
}