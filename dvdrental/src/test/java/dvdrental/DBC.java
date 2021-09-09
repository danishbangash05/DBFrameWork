package dvdrental;

import dbconnectionsetup.DBSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBC extends DBSetup {
    @Test
    public void selectAllActor() throws SQLException {
        String query = "SELECT * FROM public.actor limit 10";

        Connection connection = setUp();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actor_id = resultSet.getString("actor_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String last_update = resultSet.getString("last_update");
            System.out.println(actor_id + " " + first_name + " " + last_name + " " + last_update);

            String actual = resultSet.getString("first_name");
            Assert.assertEquals(actual, first_name);
            System.out.println(actual);
        }
    }
}
