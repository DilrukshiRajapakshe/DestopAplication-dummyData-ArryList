package sliit.arryList.Module;

public class CustomerPlacesOrderDetail {

    public String BillID;
    public String ThatDay;
    public String CusID;
    public String CusName;
    public String ItemID;
    public String Description;
    public double Price;
    public int OrdQTY;
    public double tot;
    public double fullTot;
    public CustomerPlacesOrderDetail() {
    }

    public CustomerPlacesOrderDetail(String billID, String thatDay, String cusID, String cusName, String itemID,
                                     String description, double price, int ordQTY, double tot, double FullToot) {
        BillID = billID;
        ThatDay = thatDay;
        CusID = cusID;
        CusName = cusName;
        ItemID = itemID;
        Description = description;
        Price = price;
        OrdQTY = ordQTY;
        this.tot = tot;
        fullTot =FullToot;
    }

    public double getFullTot() {
        return fullTot;
    }

    public void setFullTot(double fullTot) {
        this.fullTot = fullTot;
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

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getOrdQTY() {
        return OrdQTY;
    }

    public void setOrdQTY(int ordQTY) {
        OrdQTY = ordQTY;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return "CustomerPlacesOrderDetail{" +
                "BillID='" + BillID + '\'' +
                ", ThatDay='" + ThatDay + '\'' +
                ", CusID='" + CusID + '\'' +
                ", CusName='" + CusName + '\'' +
                ", ItemID='" + ItemID + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", OrdQTY=" + OrdQTY +
                ", tot=" + tot +
                '}';
    }
}
