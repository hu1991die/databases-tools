package com.feizi;

import com.feizi.component.config.ModuleParser;
import com.feizi.domain.Module;
import com.feizi.domain.ModuleList;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

    //velocity的模板路径
    protected String htmlTemplateFile;
    //定义导出的模块
    protected Module module;

    @Before
    public void setUp() throws Exception {
        //定义velocity的模板路径
        htmlTemplateFile = "/templates/html-template.vm";

        //解析ModuleList
        ModuleList moduleList = ModuleParser.getModuleList("/static/table-info.xml");
        if (null != moduleList){
            module = moduleList.getModuleList().get(0);
        }
    }
}
