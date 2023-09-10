package pages;

import org.apache.poi.xssf.usermodel.*;
import org.junit.*;

import java.io.*;

public class ExcelFile {
    String path = "Sample.xlsx";
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        System.out.println(worksheet.getRow(3).getCell(2));
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFCell cell = worksheet.createRow(0).createCell(0);
        cell.setCellValue(50);

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();
    }

}
