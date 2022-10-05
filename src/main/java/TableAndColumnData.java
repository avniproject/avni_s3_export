public class TableAndColumnData {
    private String tableName;

    private ColumnData[] columnData;

    public TableAndColumnData(String tableName, ColumnData[] columnData) {
        this.tableName = tableName;
        this.columnData = columnData;
    }

    public String getTableName() {
        return tableName;
    }

    public ColumnData[] getColumnNameAndS3URL() {
        return columnData;
    }

}
