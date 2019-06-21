package sliit.arryList.Module;

public class plaseOderViewTable {
    public String BillID;
    public String ThatDay;
    public String CusID;

    public plaseOderViewTable(String billID, String thatDay, String cusID) {
        BillID = billID;
        ThatDay = thatDay;
        CusID = cusID;
    }

    public plaseOderViewTable() {
    }

    public String getBillID() {
        return BillID;
    }

    public void setBillID(String billID) {
        BillID = billID;
    }

    public String getThatDay() {
        return ThatDay;
    }

    public void setThatDay(String thatDay) {
        ThatDay = thatDay;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String cusID) {
        CusID = cusID;
    }

    @Override
    public String toString() {
        return "plaseOderViewTable{" +
                "BillID='" + BillID + '\'' +
                ", ThatDay='" + ThatDay + '\'' +
                ", CusID='" + CusID + '\'' +
                '}';
    }
}
