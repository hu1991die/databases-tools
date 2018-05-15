# 数据库字典导出工具
#### 项目框架： SpringBoot + Mybatis
#### 模板引擎： FreeMarker
#### XML解析： xstream解析xml文件
#### 数据库： MySQL

### 基本思路
首先根据数据库的schema信息查询出所有的数据库表的集合，之后迭代表集合，再查询出每张数据表的列字段信息集合列表，之后通过封装成javaBean对象，再使用freemarker模板引擎导出HTML文件即可。

### 使用指南：
#### 1、配置文件说明：
> application.properties文件：配置数据库连接信息和schema名称以及导出的路径

> static/table-info.xml文件：配置导出的表信息

##### 2、application.properties配置信息：

    spring.datasource.url=jdbc\:mysql\://127.0.0.1\:3306/lmstest?characterEncoding\=utf8
    spring.datasource.username=root
    spring.datasource.password=123456
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    
    mybatis.check-config-location=true
    mybatis.config-location=classpath:mybatis-config.xml
    
    #user config
    com.feizi.schema.name=lmstest
    
    #export path
    com.feizi.export.folder=F:/htmlTemplate


**需要注意的是： 导出路径的文件夹需要提前创建好，否则会报错，不过可以自行改造**

#### 3、导出表信息配置（table-info.xml）：

1. 导出所有表

  > `<module name="所有模块" type="all"/>`
2. type类型为prefix，表示按照指定的table类型导出，比如eaxm前缀，则表示导出考试模块

  > `<module name="爱问模块" type="prefix" table="ask"/>`
3. type类型为table，表示按照指定的table表名导出，比如执行user_info,user_config

  > `<module name="考试模块" type="table" table="exam_info,user_info"/>`

#### 4、因为只是类似于一个工具类，只需要跑一个main方法即可，所以其实使用SpringBoot框架算是多余了，这里通过跑测试用例导出

##### 导出步骤：

> test/resources里面也需要拷贝相应的配置文件

> 执行com.feizi.controller.ExportDictionaryControllerTest测试用例的testExportDictionary()方法即可。

#### 5、执行效果：

![1](https://raw.githubusercontent.com/hu1991die/picture-server/master/1.png)