package com.baizhi;

import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpApplicationTests {
    @Autowired
    StudentDao studentDao;
    @Test
    public void contextLoads() throws IOException {
        //创建文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("test");
        //创建行
        HSSFRow row = sheet.createRow(0);
        //创建单元格
        HSSFCell cell = row.createCell(0);
        //给单元格设值
        cell.setCellValue(10.0);
        //写到本地
        workbook.write(new File("E:/aa.xls"));
    }

    @Test
    public void test2() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //通过workbook 创建日期格式
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        //通过workbook 创建样式格式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        HSSFSheet sheet = workbook.createSheet("test1");
        sheet.setColumnWidth(0, 20 * 256);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);
        workbook.write(new File("E:/bb.xls"));
    }

    @Test
    public void test3() throws IOException {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "xiaohuahua", "123456", new Date()));
        list.add(new Student(2, "xiaohuahua2", "123456", new Date()));
        list.add(new Student(3, "xiaohuahua3", "123456", new Date()));
        list.add(new Student(4, "xiaohuahua4", "123456", new Date()));
        list.add(new Student(5, "xiaohuahua5", "123456", new Date()));
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("楷体");
        font.setColor(Font.COLOR_RED);
        HSSFSheet sheet = workbook.createSheet("student");
        HSSFCellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFont(font);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        sheet.setColumnWidth(3, 20 * 256);
        String[] s = {"编号", "用户名", "密码", "生日"};

        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < s.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(cellStyle1);
            cell.setCellValue(s[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(list.get(i).getId());
            row1.createCell(1).setCellValue(list.get(i).getUsername());
            row1.createCell(2).setCellValue(list.get(i).getPassword());
            HSSFCell cell = row1.createCell(3);
           cell.setCellValue(list.get(i).getBir());
            cell.setCellStyle(cellStyle);
        }
        workbook.write(new File("E:/cc2.xls"));
    }


}
