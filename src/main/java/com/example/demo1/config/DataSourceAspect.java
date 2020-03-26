package com.example.demo1.config;

/**
 * @author :yangjie
 * desc :0
 * @date :2020/3/25
 **/

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author Created by pangkunkun on 2017/12/18.
 */
@Component
@Aspect
@Slf4j
public class DataSourceAspect {

 /*   @Pointcut("execution( * com.example.demo1.service.*.*(..))")
    public void dataSourcePointCut() {

    }*/

    @Pointcut("@annotation(com.example.demo1.config.TargetDataSource)")
    public void dbPointCut() {
    }

    @Before("dbPointCut()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint, methodName);
        try {
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            if (method != null && method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
                String dataSourceName = targetDataSource.value();
                //如果为null，就使用默认的数据源
                if (StringUtils.isEmpty(dataSourceName)) {
                    DynamicDataSourceContextHolder.setDataSourceType("master");
                } else {
                    DynamicDataSourceContextHolder.setDataSourceType(dataSourceName);
                }
                log.debug("current thread " + Thread.currentThread().getName()
                        + " 数据源为 " + dataSourceName + " to ThreadLocal");
            } else {
                log.debug("switch datasource fail,use default");
            }
        } catch (Exception e) {
            log.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
        }
    }

    //执行完切面后，将线程共享中的数据源名称清空
    @After("dbPointCut()")
    public void after(JoinPoint joinPoint) {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }
}