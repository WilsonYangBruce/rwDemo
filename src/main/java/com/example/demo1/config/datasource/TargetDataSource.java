package com.example.demo1.config.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :yangjie
 * desc :b
 * @date :2020/3/25
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    DataSourceEnum value();//此处接收的是数据源的名称
}
