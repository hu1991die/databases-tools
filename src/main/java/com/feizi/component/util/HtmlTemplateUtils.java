package com.feizi.component.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by feizi Ruan on 2017/7/17.
 * Html模板导出工具类
 */
@Component
public final class HtmlTemplateUtils {
    private static Logger logger = LoggerFactory.getLogger(HtmlTemplateUtils.class);
    private static final String PROPERTIES_VELOCITY_KEY = "file.resource.loader.class";
    private static final String PROPERTIES_VELOCITY_VALUE = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";
    private static final String SOURCE_ENCODING = "UTF-8";

    /**
     * 初始化模板
     * @param htmlTemplateFile
     * @return
     * @throws Exception
     */
    public Template initTemplate(String htmlTemplateFile) throws Exception{
        Properties properties = new Properties();
        VelocityEngine velocityEngine = new VelocityEngine();
        properties.put(PROPERTIES_VELOCITY_KEY, PROPERTIES_VELOCITY_VALUE);
        properties.setProperty(Velocity.ENCODING_DEFAULT, SOURCE_ENCODING);
        properties.setProperty(Velocity.INPUT_ENCODING, SOURCE_ENCODING);
        properties.setProperty(Velocity.OUTPUT_ENCODING, SOURCE_ENCODING);

        velocityEngine.init(properties);
        return velocityEngine.getTemplate(htmlTemplateFile);
    }

    /**
     * 导出模板
     * @param template
     * @param velocityContext
     * @param filePath
     * @throws Exception
     */
    public void exportHtmlTemplate(Template template, VelocityContext velocityContext, String filePath) throws Exception{
        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        logger.info("===============filePath：" + filePath);

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath), SOURCE_ENCODING);
        out.write(writer.toString());
        out.close();

        logger.info("ok...导出html格式数据字典成功................");
    }
}
