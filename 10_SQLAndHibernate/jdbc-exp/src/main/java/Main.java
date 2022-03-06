import java.sql.*;

public class Main {
    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "qmis";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select \n" +
                    "course_name AS NameOfCourses,\n" +
                    "timestampdiff(month, MIN(subscription_date), \n" +
                    "MAX(subscription_date)) / count(*) AS AVG\n" +
                    "from purchaselist\n" +
                    "group by course_name;\n");
            while (resultSet.next())
            {
                String coursesName = resultSet.getString("NameOfCourses");
                double avg = resultSet.getDouble("AVG");
                System.out.println(coursesName + "/ /" + avg);
            }
            resultSet.close();
            connection.close();
            statement.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
