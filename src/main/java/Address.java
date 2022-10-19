public class Address {
    private String state;
    private String district;
    private String taluka;
    private String gpVillage;
    private String dam;

    public Address(String state, String district, String taluka, String gpVillage, String dam) {
        this.state = state;
        this.district = district;
        this.taluka = taluka;
        this.gpVillage = gpVillage;
        this.dam = dam;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getGpVillage() {
        return gpVillage;
    }

    public void setGpVillage(String gpVillage) {
        this.gpVillage = gpVillage;
    }

    public String getDam() {
        return dam;
    }

    public void setDam(String dam) {
        this.dam = dam;
    }
}
