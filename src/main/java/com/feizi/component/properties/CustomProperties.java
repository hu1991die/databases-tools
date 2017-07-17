package com.feizi.component.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by feizi Ruan on 2017/7/17.
 */
@Component
public class CustomProperties {

    @Value("${com.feizi.schema.name}")
    private String schemaName;
    @Value("${com.feizi.export.folder}")
    private String exportFolder;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public void setExportFolder(String exportFolder) {
        this.exportFolder = exportFolder;
    }
}
