package com.example.demo1.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1.entity.StudentDo;
import com.example.demo1.result.ResultEntity;
import com.example.demo1.result.ResultTool;
import com.example.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :yangjie
 * desc :
 * @date :2020/3/25
 **/
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResultEntity getAllStudent(@RequestParam(value = "pageSize", required = false, defaultValue = "10") long pageSize,
                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") long pageNum) {
        Page<StudentDo> page = new Page<>(pageNum, pageSize);
        return ResultTool.ok(studentService.getList(page));
    }

    @PostMapping()
    public ResultEntity insert() {
        StudentDo studentDo = new StudentDo();
        studentDo.setAge(100);
        studentDo.setName("读写分离");
        studentService.saveOne(studentDo);
        return ResultTool.ok(studentDo);
    }
}
