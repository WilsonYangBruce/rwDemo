package com.example.demo1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author tom
 */
@Data
@TableName(value = "student")
public class StudentDo {
    private String id;
    private String name;
    private int age;
}
