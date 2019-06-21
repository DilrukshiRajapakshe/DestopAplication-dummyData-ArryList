package sliit.arryList.Module;

public class OrderTable {

    public String ItemID;
    public String Descreption;
    public double Price;
    public int OrdQTY;
    public double tot;

    public OrderTable() {
    }

    public OrderTable(String itemID, String descreption, double price, int ordQTY, double tot) {
        ItemID = itemID;
        Descreption = descreption;
        Price = price;
        OrdQTY = ordQTY;
        this.tot = tot;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getDescreption() {
        return Descreption;
    }

    public void setDescreption(String descreption) {
        Descreption = descreption;
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
        return "OrderTable{" +
                "ItemID='" + ItemID + '\'' +
                ", Description='" + Descreption + '\'' +
                ", Price=" + Price +
                ", OrdQTY=" + OrdQTY +
                ", tot=" + tot +
                '}';
    }
}
