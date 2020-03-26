package com.example.demo1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1.entity.StudentDo;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/25
 **/
public interface StudentService extends IService<StudentDo> {
    /**
     * 列表
     * @param page
     * @return
     */
    IPage<StudentDo> getList(IPage<StudentDo> page);

    /**
     * 保存
     *
     * @param entity student
     * @return student
     */
    StudentDo saveOne(StudentDo entity);

}
