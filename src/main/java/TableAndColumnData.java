public class TableAndColumnData {
    private String tableName;

    private ColumnData[] columnData;
    private String subjectTableName;

    public TableAndColumnData(String tableName, ColumnData[] columnData, String subjectName) {
        this.tableName = tableName;
        this.columnData = columnData;
        this.subjectTableName = subjectName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getSubjectTableName() {
        return subjectTableName;
    }

    public ColumnData[] getColumnNameAndS3URL() {
        return columnData;
    }

}
