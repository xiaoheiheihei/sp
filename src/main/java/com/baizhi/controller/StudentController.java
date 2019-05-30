package com.baizhi.controller;

import com.baizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("insert")
    public String sava(){
        return null;
    }
}
