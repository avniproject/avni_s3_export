public class TableAndColumnData {
    private String tableName;

    private ColumnData[] columnData;
    private String subjectName;

    public TableAndColumnData(String tableName, ColumnData[] columnData, String subjectName) {
        this.tableName = tableName;
        this.columnData = columnData;
        this.subjectName = subjectName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public ColumnData[] getColumnNameAndS3URL() {
        return columnData;
    }

}
