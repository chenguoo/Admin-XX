package com.javamokey.adminxx.common;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-24 17:21
 */
public class MpGenerator {

    public static void main(String[] args) {
        String packageName = "com.javamokey.adminxx.modules";
        String module = "sys";
        /*String[] entity = {"sys_config","sys_dept","sys_log","sys_menu",
                   "sys_oss","sys_role","sys_role_dept","sys_role_menu","sys_user","sys_user_role"};
        */
        module = "job";
        String[] entity = {"schedule_job","schedule_job_log"};
        generateByTables(packageName, module, entity);
    }

    private static void generateByTables(String packageName, String module, String... tableNames) {

        String dbUrl = "jdbc:mysql://localhost:3306/adminxx";

        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)// 不需要ActiveRecord特性的请改为false
                .setAuthor("Cheney")
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setOutputDir("d:\\mybatis-plus")
                .setFileOverride(true)
                .setBaseColumnList(true)
                .setServiceName("%sService");

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("")
                .setDriverName("com.mysql.jdbc.Driver");

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组


        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setModuleName(module)
                                .setController("controller")
                                .setEntity("entity")
                                .setMapper("mapper")
                                .setXml("mapping")
                ).execute();
    }
}
