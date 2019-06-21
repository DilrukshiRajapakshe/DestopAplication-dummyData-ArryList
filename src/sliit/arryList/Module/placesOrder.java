package sliit.arryList.Module;

import java.util.Date;

public class placesOrder {
    private String PlaseOderID;
    private String OderDate;
    private String CuId;
    private String ItemID;
    private int Oqty;

    public placesOrder(String plaseOderID, String oderDate, String cuId, String itemID, int oqty) {
        PlaseOderID = plaseOderID;
        OderDate = oderDate;
        CuId = cuId;
        ItemID = itemID;
        Oqty = oqty;
    }

    public placesOrder() {
    }

    public String getPlaseOderID() {
        return PlaseOderID;
    }

    public void setPlaseOderID(String plaseOderID) {
        PlaseOderID = plaseOderID;
    }

    public String getOderDate() {
        return OderDate;
    }

    public void setOderDate(String oderDate) {
        OderDate = oderDate;
    }

    public String getCuId() {
        return CuId;
    }

    public void setCuId(String cuId) {
        CuId = cuId;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public int getOqty() {
        return Oqty;
    }

    public void setOqty(int oqty) {
        Oqty = oqty;
    }

    @Override
    public String toString() {
        return "placesOrder{" +
                "PlaseOderID=" + PlaseOderID +
                ", OderDate=" + OderDate +
                ", ItemID='" + ItemID + '\'' +
                ", CuId='" + CuId + '\'' +
                ", Oqty=" + Oqty +
                '}';
    }
}
