package com.example.demo1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1.entity.StudentDo;
import org.springframework.stereotype.Repository;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/25
 **/
@Repository
public interface StudentDao extends BaseMapper<StudentDo> {

}
