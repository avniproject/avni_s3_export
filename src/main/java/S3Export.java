import java.util.ArrayList;

public class S3Export {

    public static void main(String[] args) {

        ArrayList<TableAndColumnData> tableAndColumnNames = new ArrayList<>();

        tableAndColumnNames.add(new TableAndColumnData("well", new ColumnData[]{new ColumnData("Well Image 1", null), new ColumnData("Well Image 2", null), new ColumnData("Well Image 3", null)}, "well"));
        tableAndColumnNames.add(new TableAndColumnData("well_regular_recording", new ColumnData[]{new ColumnData("Well Image 1", null), new ColumnData("Well Image 2", null)}, "well"));
        tableAndColumnNames.add(new TableAndColumnData("work_order_site_audit", new ColumnData[]{new ColumnData("Image - Monitoring Templates", null), new ColumnData("Image - Site", null), new ColumnData("Image - Machine", null), new ColumnData("Video - Machine", null), new ColumnData("Video - Monitoring Templates", null), new ColumnData("Video - Site", null)}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("farmer_farmer_interaction_", new ColumnData[]{new ColumnData("Image - Village", null), new ColumnData("Image - Farmland", null), new ColumnData("Upload Video - Village", null), new ColumnData("Video - Farmland", null)}, "farmer"));
        tableAndColumnNames.add(new TableAndColumnData("farmer_farmer_endline", new ColumnData[]{new ColumnData("Image of farmer with the farm", null)}, "farmer"));
        tableAndColumnNames.add(new TableAndColumnData("work_order_work_order_daily_recording_machine", new ColumnData[]{new ColumnData("Log book image 1", null), new ColumnData("Log book image 2", null)}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("work_order_work_order_endline", new ColumnData[]{new ColumnData("Image 2 of the site", null), new ColumnData("Image 1 of the site", null), new ColumnData("Image 3 of the site", null), new ColumnData("Image of MB recording", null), new ColumnData("Post work measurements image", null), new ColumnData("Post perspective image", null), new ColumnData("Video of Site", null),}, "work_order"));
        tableAndColumnNames.add(new TableAndColumnData("work_order", new ColumnData[]{new ColumnData("Image 1 of the site", null), new ColumnData("Image 3 of the site", null), new ColumnData("NOC/Work order image", null), new ColumnData("Image 2 of the site", null), new ColumnData("Permission letter image", null), new ColumnData("Pre perspective image", null), new ColumnData("Village institution agreement image (for contribu (546257213)", null), new ColumnData("Site marking image", null), new ColumnData("Machine contractor agreement image", null), new ColumnData("Video of Site", null)}, "work_order"));


        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        postgreSQLJDBC.getS3Url(tableAndColumnNames);


    }
}


