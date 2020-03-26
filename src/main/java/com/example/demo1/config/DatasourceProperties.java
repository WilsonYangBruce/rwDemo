package com.example.demo1.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/25
 **/
@Configuration
@ConfigurationProperties(prefix = "hikari")
@Slf4j
public class DatasourceProperties {
    private HikariDataSource master;
    private HikariDataSource slave;

    public HikariDataSource getMaster() {
        log.info("master----------------");
        return master;
    }

    public void setMaster(HikariDataSource master) {
        this.master = master;
    }

    public HikariDataSource getSlave() {
        log.info("slave----------------");
        return slave;
    }

    public void setSlave(HikariDataSource slave) {
        this.slave = slave;
    }
}
