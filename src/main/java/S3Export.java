import java.util.ArrayList;

public class S3Export {

    public static void main(String[] args) {

        ArrayList<TableAndColumnData> tableAndColumnNames = new ArrayList<>();
        tableAndColumnNames.add(new TableAndColumnData("well", new ColumnData[]{new ColumnData("Well Image 1", null)}, "well"));
        tableAndColumnNames.add(new TableAndColumnData("work_order", new ColumnData[]{new ColumnData("Image 1 of the site", null)}, "work_order"));

        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        postgreSQLJDBC.getS3Url(tableAndColumnNames);


    }
}
