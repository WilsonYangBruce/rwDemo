package com.example.demo1.config.datasource;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/26
 **/
public enum DataSourceEnum {
    /**
     *
     */
    MASTER("MASTER"),
    SLAVE("SLAVE");
    /**
     * 数据库名称
     */
    private String dbName;

    DataSourceEnum(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
}
