package sliit.arryList.Module;

public class item {
    public String ItemID;
    public String ItemNAME;
    public String ItemDESCRIPTION;
    public int ItemAMOUNT;
    public double ItemPRICE;

    public item() {
    }

    public item(String itemID, String itemNAME, String itemDESCRIPTION, int itemAMOUNT, double itemPRICE) {
        ItemID = itemID;
        ItemNAME = itemNAME;
        ItemDESCRIPTION = itemDESCRIPTION;
        ItemAMOUNT = itemAMOUNT;
        ItemPRICE = itemPRICE;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getItemNAME() {
        return ItemNAME;
    }

    public void setItemNAME(String itemNAME) {
        ItemNAME = itemNAME;
    }

    public String getItemDESCRIPTION() {
        return ItemDESCRIPTION;
    }

    public void setItemDESCRIPTION(String itemDESCRIPTION) {
        ItemDESCRIPTION = itemDESCRIPTION;
    }

    public int getItemAMOUNT() { return ItemAMOUNT; }

    public void setItemAMOUNT(int itemAMOUNT) {
        ItemAMOUNT = itemAMOUNT;
    }

    public double getItemPRICE() { return ItemPRICE; }

    public void setItemPRICE(double itemPrice) { ItemPRICE = itemPrice; }

    @Override
    public String toString() {
        return "StockClass{" +
                "ItemID='" + ItemID + '\'' +
                ", ItemNAME='" + ItemNAME + '\'' +
                ", ItemDESCRIPTION='" + ItemDESCRIPTION + '\'' +
                ", ItemAMOUNT=" + ItemAMOUNT +
                ", ItemPRICE=" + ItemPRICE +
                '}';
    }
}
