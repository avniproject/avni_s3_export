public class S3Data {
    private String s3Url;

    private Address address;


    public S3Data(String s3Url, Address address) {
        this.s3Url = s3Url;
        this.address = address;
    }

    public String getS3Url() {
        return s3Url;
    }

    public void setS3Url(String s3Url) {
        this.s3Url = s3Url;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
