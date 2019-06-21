package sliit.arryList.Module;

public class customer {
    String CuId;
    String Cuname;
    String CuAddress;

    public customer(String cuId, String cuname, String cuAddress) {
        CuId = cuId;
        Cuname = cuname;
        CuAddress = cuAddress;
    }

    public customer() {
    }

    public String getCuId() {
        return CuId;
    }

    public void setCuId(String cuId) {
        CuId = cuId;
    }

    public String getCuname() {
        return Cuname;
    }

    public void setCuname(String cuname) {
        Cuname = cuname;
    }

    public String getCuAddress() {
        return CuAddress;
    }

    public void setCuAddress(String cuAddress) {
        CuAddress = cuAddress;
    }

    @Override
    public String toString() {
        return "CustermerClass{" +
                "CuId='" + CuId + '\'' +
                ", Cuname='" + Cuname + '\'' +
                ", CuAddress='" + CuAddress + '\'' +
                '}';
    }
}
