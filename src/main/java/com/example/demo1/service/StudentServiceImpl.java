package com.example.demo1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.config.TargetDataSource;
import com.example.demo1.dao.StudentDao;
import com.example.demo1.entity.StudentDo;
import org.springframework.stereotype.Service;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/25
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentDo>
        implements StudentService {

//    @TargetDataSource("master")
    @Override
    public IPage<StudentDo> getList(IPage<StudentDo> page) {
        return super.page(page);
    }

    @TargetDataSource("slave")
    @Override
    public StudentDo saveOne(StudentDo entity) {
        return save(entity) ? entity : null;
    }

}
