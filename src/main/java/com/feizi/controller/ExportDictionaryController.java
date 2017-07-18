package com.feizi.controller;

import com.feizi.domain.ColumnInfo;
import com.feizi.domain.Module;
import com.feizi.domain.TableInfo;
import com.feizi.component.properties.CustomProperties;
import com.feizi.service.DatabaseStructureService;
import com.feizi.component.util.HtmlTemplateUtils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
@Controller
public class ExportDictionaryController {

    private static Logger logger = LoggerFactory.getLogger(ExportDictionaryController.class);

    @Resource
    private DatabaseStructureService databaseStructureService;

    @Resource
    private CustomProperties customProperties;

    @Resource
    private HtmlTemplateUtils htmlTemplateUtils;

    public void exportDictionary(String htmlTemplateFile, Module module) {
        //数据库名称
        String schemaName = customProperties.getSchemaName();

        //查询表结构列表集合
        List<TableInfo> tableInfoList = databaseStructureService.queryTableInfoList(schemaName, module);
        if(null != tableInfoList && tableInfoList.size() > 0){
            for (TableInfo tableInfo : tableInfoList){
                String tableName = tableInfo.getTableName();

                //根据数据表名称查询表结构列表集合
                List<ColumnInfo> columnInfoList = databaseStructureService.queryColumnInfoList(schemaName, tableName);
                tableInfo.setColumnInfoList(columnInfoList);
            }
        }

        export(htmlTemplateFile, module, tableInfoList);
    }


    public void findListForSearch(String htmlTemplateFile, Module module, String content) {

        List<TableInfo> resultTableList = new ArrayList<>();
        //数据库名称
        String schemaName = customProperties.getSchemaName();

        //查询表结构列表集合
        List<TableInfo> tableInfoList = databaseStructureService.queryTableInfoList(schemaName, module);
        if(null != tableInfoList && tableInfoList.size() > 0){
            for (TableInfo tableInfo : tableInfoList){
                String tableName = tableInfo.getTableName();

                //根据数据表名称查询表结构列表集合
                List<ColumnInfo> resultColumnInfoList = new ArrayList<>();
                boolean containsFlag = false;
                List<ColumnInfo> columnInfoList = databaseStructureService.queryColumnInfoList(schemaName, tableName);
                for (ColumnInfo columnInfo : columnInfoList) {
                    String columnComment = columnInfo.getColumnComment();
                    if(columnComment.indexOf(content) >= 0){
                        resultColumnInfoList.add(columnInfo);
                        containsFlag = true;
                    }
                }

                if (containsFlag) {
                    tableInfo.setColumnInfoList(resultColumnInfoList);
                    resultTableList.add(tableInfo);
                }

            }
        }

        export(htmlTemplateFile, module, resultTableList);
    }

    private void export(String htmlTemplateFile, Module module, List<TableInfo> tableInfoList){
        //获取上下文
        VelocityContext context = new VelocityContext();
        //设置模块名称
        context.put("module", module);
        //数据表集合
        context.put("tableInfoList", tableInfoList);

        try {
            //初始化velocity模板
            Template htmlTemplate = htmlTemplateUtils.initTemplate(htmlTemplateFile);

            //模块名称
            String moduleName = module.getModuleName();

            //根据velocity模板导出html页面
            htmlTemplateUtils.exportHtmlTemplate(htmlTemplate, context, customProperties.getExportFolder() + "/" + moduleName + ".html");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
