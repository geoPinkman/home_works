import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        try{
            Connection connection = DriverManager.getConnection(url, "root", "password");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT \n" +
                    "course_name, COUNT(subscription_date) / 12 AS avg_subs_count\n" +
                    "FROM PurchaseList\n" +
                    "WHERE YEAR (subscription_date) = 2018\n" +
                    "GROUP BY course_name ");
            while (result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
