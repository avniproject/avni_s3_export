import java.util.ArrayList;

public class S3Export {

    public static void main(String[] args) {

        ArrayList<TableAndColumnData> tableAndColumnNames = new ArrayList<>();

        tableAndColumnNames.add(new TableAndColumnData("work_order_site_audit", new ColumnData[]{new ColumnData("Image - Site", null), new ColumnData("Video - Machine", null)}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("farmer_farmer_interaction_", new ColumnData[]{new ColumnData("Image - Farmland", null)}, "farmer"));
        tableAndColumnNames.add(new TableAndColumnData("work_order_work_order_endline", new ColumnData[]{new ColumnData("Image of MB recording", null), new ColumnData("Post perspective image", null),}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("work_order", new ColumnData[]{new ColumnData("Pre perspective image", null),}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("work_order", new ColumnData[]{new ColumnData("Pre perspective image", null),}, "work_order"));

        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        postgreSQLJDBC.getS3Url(tableAndColumnNames);


    }
}

