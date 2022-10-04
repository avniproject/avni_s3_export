import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {

    public static String getS3Url(String conceptUUID) {
        Connection c = null;
        Statement stmt = null;
        String uuid = "";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/openchs",
                            "openchs", "");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM individual limit  1;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("first_name");
                uuid = String.valueOf(rs.getInt("uuid"));

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return uuid;
    }

}