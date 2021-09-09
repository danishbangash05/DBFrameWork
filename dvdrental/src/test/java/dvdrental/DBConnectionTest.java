package dvdrental;

import dbconnectionsetup.DBSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest extends DBSetup {
    @Test
    public void dbTest() throws SQLException {

        String query = "SELECT first_name FROM public.actor";

        Connection connect = setUp();

        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actual = resultSet.getString("first_name");
            //String act = resultSet.getString("last_name");
            Assert.assertEquals(actual,"Penelope" );
           // System.out.println(actual + " " + act);
            break;

        }

    }
}
