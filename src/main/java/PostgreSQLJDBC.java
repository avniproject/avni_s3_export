import java.sql.*;
import java.util.ArrayList;


public class PostgreSQLJDBC {

    private static final String addressSQLSelectPart = "\"State\", \"District\", \"Taluka\", \"GP/Village\", \"Dam\" ";

    public String getS3Url(ArrayList<TableAndColumnData> tableAndColumnData) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/openchs?currentSchema=rwbniti", "openchs", "password")) {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            for (TableAndColumnData tableAndColumnDataEntry : tableAndColumnData) {
                for (ColumnData columnData : tableAndColumnDataEntry.getColumnNameAndS3URL()) {
                    String sql = new StringBuilder().append("Select ")
                            .append("\"" + columnData.getColumnName() + "\" , ")
                            .append(addressSQLSelectPart)
                            .append("from ")
                            .append(tableAndColumnDataEntry.getTableName())
                            .append(" join address on address.id = " + tableAndColumnDataEntry.getTableName() + ".address_id;")
                            .toString();
                    System.out.println("SQL ----> "+sql);
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        String columnS3Url = resultSet.getString(columnData.getColumnName());
                        System.out.println("Column S3 URL mil gaya na bhai" + columnS3Url);
                        System.out.println("Column S3 URL mil gaya na bhai" + resultSet.getString("State"));
                        Address address = new Address(resultSet.getString("State"),resultSet.getString("District"), resultSet.getString("Taluka"),
                                resultSet.getString("GP/Village"), resultSet.getString("Dam"));
                        S3Data s3Data = new S3Data(resultSet.getString(columnData.getColumnName()), address);
                        columnData.setS3Data(s3Data);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

        return "something;";
    }

}