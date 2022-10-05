public class ColumnData {
    private String columnName;
    private S3Data s3Data;

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public ColumnData(String columnName, S3Data s3URLByAddress) {
        this.columnName = columnName;
        this.s3Data = s3URLByAddress;
    }

    public S3Data getS3Data() {
        return s3Data;
    }

    public void setS3Data(S3Data s3Data) {
        this.s3Data = s3Data;
    }
}
