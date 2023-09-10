package utility.database_testing;

import org.junit.jupiter.api.*;
import utility.*;

import java.util.*;

public class DBTest {

    @Test
    public void test1(){
        DBUtils.createConnection();
        String query = "SELECT FirstName, LastName, JobTitle \n" +
                "FROM Person.Person p\n" +
                "INNER JOIN HumanResources.Employee hre on p.BusinessEntityID = hre.BusinessEntityID";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap.toString());

        List<Map<String, Object>> queryMap = DBUtils.getQueryResultMap(query);

        System.out.println(queryMap);

        DBUtils.destroy();
    }
}
