package dvdrental;

import dbconnectionsetup.DBSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class List5Actors extends DBSetup {
    @Test
    public void selectAllActor() throws SQLException {
        String query = "SELECT first_name FROM public.actor limit 5";

        Connection connection = setUp();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<String> actors = new ArrayList<>();
//        System.out.println("Length of an Array List is : " + studentList.size());
        actors.add(0, "Penelope");
        actors.add(1, "Nick");
        actors.add(2, "Ed");
        actors.add(3, "Jennifer");
        actors.add(4, "Johnny");
        for (int i = 0; i < actors.size(); i++) {
            while (resultSet.next()) {
                //String actor_id = resultSet.getString("actor_id");
//                String first_name = resultSet.getString("first_name");
//
                // String last_name = resultSet.getString("last_name");
                //String last_update = resultSet.getString("last_update");
                // System.out.println(actor_id + " " + first_name + " " + last_name + " " + last_update);

                String actual = resultSet.getString("first_name");
                String expected = actors.get(i);
                System.out.println(actual);
                System.out.println(expected);
                System.out.println("---------");
                Assert.assertEquals(actual, expected);
                break;

            }
        }
    }
}
