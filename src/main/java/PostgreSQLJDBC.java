import java.sql.*;
import java.util.ArrayList;


public class PostgreSQLJDBC {

    private static final String addressSQLSelectPart = "\"State\", \"District\", \"Taluka\", \"GP/Village\", \"Dam\" ";
    private static final String subjectMetaDataSQLSelectPart = "first_name, registration_date as date ";
    private static final String encounterMetaDataSQLSelectPart = "first_name, encounter_date_time as date ";


    public String getS3Url(ArrayList<TableAndColumnData> tableAndColumnData) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/openchs?currentSchema=rwbniti", "openchs", "password")) {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();

            for (TableAndColumnData tableAndColumnDataEntry : tableAndColumnData) {
                String sql;
                for (ColumnData columnData : tableAndColumnDataEntry.getColumnNameAndS3URL()) {

                    if (tableAndColumnDataEntry.getSubjectName().equals(tableAndColumnDataEntry.getTableName())) {
                        sql = getSqlForSubject(tableAndColumnDataEntry, columnData);
                    } else {
                        sql = getSqlForEncounters(tableAndColumnDataEntry, columnData);
                    }

                    ResultSet resultSet = statement.executeQuery(sql);
                    int counter = 0;
                    while (resultSet.next()) {
                        counter = counter + 1;
                        String columnS3Url = resultSet.getString(columnData.getColumnName());
                        System.out.println("Column S3 URL mil gaya na bhai" + columnS3Url);
                        Address address = new Address(resultSet.getString("State"), resultSet.getString("District"), resultSet.getString("Taluka"), resultSet.getString("GP/Village"), resultSet.getString("Dam"));
                        S3Data s3Data = new S3Data(resultSet.getString(columnData.getColumnName()), address);
                        MetaData metaData = new MetaData(resultSet.getString("first_name"), resultSet.getString("date"));
                        columnData.setS3Data(s3Data);
                        S3Exporter.S3Export(address, s3Data, counter, metaData, columnData.getColumnName());
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

        return "something;";
    }

    private String getSqlForSubject(TableAndColumnData tableAndColumnDataEntry, ColumnData columnData) {
        String sql = new StringBuilder().append("Select ")
                .append("\"" + columnData.getColumnName() + "\" , ")
                .append(addressSQLSelectPart + " ,")
                .append(subjectMetaDataSQLSelectPart)
                .append(" from ")
                .append(tableAndColumnDataEntry.getTableName())
                .append(" join address on address.id = " + tableAndColumnDataEntry.getTableName() + ".address_id")
                .append(" where " + "\"" + columnData.getColumnName() + "\" notnull")
                .toString();
        System.out.println("SQL-->" + sql);
        return sql;
    }

    private String getSqlForEncounters(TableAndColumnData tableAndColumnDataEntry, ColumnData columnData) {
        String sql = new StringBuilder().append("Select ")
                .append(tableAndColumnDataEntry.getTableName() + ".\"" + columnData.getColumnName() + "\" , ")
                .append(addressSQLSelectPart + " ,")
                .append(encounterMetaDataSQLSelectPart)
                .append("from ")
                .append(tableAndColumnDataEntry.getTableName())
                .append(" join address on address.id = " + tableAndColumnDataEntry.getTableName() + ".address_id")
                .append(" join " + tableAndColumnDataEntry.getSubjectName() + " sub on sub.id = " + tableAndColumnDataEntry.getTableName() + ".individual_id")
                .append(" where " + tableAndColumnDataEntry.getTableName() + ".\"" + columnData.getColumnName() + "\" notnull")
                .toString();
        System.out.println("SQL-->" + sql);
        return sql;
    }

}