package utility.database_testing;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.assertj.core.api.*;
import org.assertj.core.api.Assert;
import org.junit.*;
import utility.*;

import java.io.*;
import java.util.*;

public class ReportTest {
    String path = "Sample.xlsx";
    FileInputStream fis = new FileInputStream(path);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    SoftAssertions softly = new SoftAssertions();

    public ReportTest() throws IOException {}

    @Test
    public void WeeklySalaries() throws AssertionError{
        XSSFSheet worksheet = workbook.getSheet("Weekly Salaries");

        List<String> headers = new ArrayList<>();
        Iterator <Cell> headerIterator = worksheet.getRow(1).cellIterator();
        while(headerIterator.hasNext()){
            Cell cell = headerIterator.next();
            headers.add(cell.toString());
        }

        Iterator<Row> rowIterator = worksheet.iterator();
        List<Map<String, Object>> rowList = new ArrayList<>();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator <Cell> cellIterator = row.cellIterator();
            Map<String, Object> rowMap = new LinkedHashMap<>();
            for (int i = 0;cellIterator.hasNext();i++) {
                Cell cell = cellIterator.next();
                if(cell.toString().equals(headers.get(i))){break;}
                rowMap.put(headers.get(i),cell);
            }
            if(!rowMap.isEmpty()){rowList.add(rowMap);}
        }

        DBUtils.createConnection();
        String query= "EXEC dbo.WeeklySalaries;";
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);

        Iterator<Map<String, Object>> it1 = rowList.iterator();
        Iterator<Map<String, Object>> it2 = queryResultMap.iterator();

        while(it1.hasNext() && it2.hasNext())  {
            String s1 = it1.next().toString();
            String s2 = it2.next().toString();

            softly.assertThat(s1).isEqualTo(s2);
        }
        softly.assertAll();


    }
}
