import java.util.ArrayList;

public class S3Export {

    public static void main(String[] args) {

        ArrayList<TableAndColumnData> tableAndColumnNames = new ArrayList<>();
        tableAndColumnNames.add(new TableAndColumnData("well",new ColumnData[]{new ColumnData("Well Image 1", null)}));

        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        postgreSQLJDBC.getS3Url(tableAndColumnNames);

    }
}
