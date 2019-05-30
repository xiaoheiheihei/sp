package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStudent {
    @Autowired
    StudentDao studentDao;

    @Test
    public void test1() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("E:/cc2.xls"));
        HSSFSheet sheet = workbook.getSheet("student");
        ArrayList<Student> list = new ArrayList<>();
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            int id = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
            String username = sheet.getRow(i).getCell(1).getStringCellValue();
            String password = sheet.getRow(i).getCell(2).getStringCellValue();
            Date bir = sheet.getRow(i).getCell(3).getDateCellValue();
            list.add(new Student(id, username, password, bir));
        }
        System.out.println(list);
        studentDao.insert(list);
    }
    @Test
    public void test2()throws Exception{
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "xiaohuahua", "123456", new Date()));
        list.add(new Student(2, "xiaohuahua2", "123456", new Date()));
        list.add(new Student(3, "xiaohuahua3", "123456", new Date()));
        list.add(new Student(4, "xiaohuahua4", "123456", new Date()));
        list.add(new Student(5, "xiaohuahua5", "123456", new Date()));
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("1","张三",list));
        teachers.add(new Teacher("2","李四",list));
        System.out.println(teachers);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生", "学生信息表"), Teacher.class, teachers);
            workbook.write(new FileOutputStream("E:/teacher1.xls"));
    }

}
