package com.baizhi.service;

import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public Integer insert(List<Student> list) {
        Integer insert = studentDao.insert(list);
        return insert;
    }
}
