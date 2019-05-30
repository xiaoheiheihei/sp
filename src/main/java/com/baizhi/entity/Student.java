package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Student {
    @ExcelIgnore
    private Integer id;
    @Excel(name = "姓名")
    private String username;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "生日",format = "yyyy-MM-dd")
    private Date bir;
}
