package dvdrental;

import dbconnectionsetup.DBSetup;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Compare2Tables extends DBSetup {
    @Test
    public void selectAllActor() throws SQLException {
//        String query1 = "SELECT first_name FROM public.actor limit 10";
//
//        String query2 = "SELECT first_name FROM public.customer limit 10";

            String querry = "SELECT first_name FROM public.actor intersect SELECT first_name FROM public.customer";
        Connection connection = setUp();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(querry);
        while (resultSet.next() ) {
                String actual = resultSet.getString("first_name");
                String expected = resultSet.getString("first_name");
                System.out.println(actual);
                 System.out.println(expected);
                System.out.println("---------");
                Assert.assertEquals(actual, expected);
            }
        }
    }

