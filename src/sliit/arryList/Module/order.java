package sliit.arryList.Module;

import java.util.ArrayList;

public class order {
    public String BillID;
    public String ThatDay;
    public String CusID;
    private ArrayList<OrderTable> orderDetails = new ArrayList<>();

    public order(String billID, String thatDay, String cusID) {
        BillID = billID;
        ThatDay = thatDay;
        CusID = cusID;
    }

    public order(String billID, String thatDay, String cusID, ArrayList<OrderTable> orderDetails) {
        BillID = billID;
        ThatDay = thatDay;
        CusID = cusID;
        this.orderDetails = orderDetails;
    }

    public order() {
    }

    public String getBillID() {
        ID i = new ID();
        BillID=i.idGenaraer();
        return BillID;
    }

    public ArrayList<OrderTable> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderTable> orderDetails) {
        this.orderDetails = orderDetails;
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
        return "order{" +
                "BillID='" + BillID + '\'' +
                ", ThatDay='" + ThatDay + '\'' +
                ", CusID='" + CusID + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
