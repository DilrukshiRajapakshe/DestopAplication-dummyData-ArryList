package sliit.arryList.countroller;

import sliit.arryList.Module.OrderTable;
import sliit.arryList.Module.plaseOderViewTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PlaceOrderController {
    public TextField searchText;
    public AnchorPane placeOrderPage;
    //plaseOrderTable
    @FXML
    private TableView<plaseOderViewTable> plaseOrderTable;
    static ArrayList<plaseOderViewTable> list = new ArrayList<>();
    static ArrayList<plaseOderViewTable> list2 = new ArrayList<>();
    static ArrayList<OrderTable> list1 = new ArrayList<>();
    public void getTableInformation() {
        for (int a = 0; a < OrderController.listOder4.size(); a++) {
            plaseOderViewTable p = new plaseOderViewTable(OrderController.listOder4.get(a).getBillID(), OrderController.listOder4.get(a).getThatDay(), OrderController.listOder4.get(a).getCusID());
            list.add(p);
        }
        System.out.println(list);
        ObservableList<plaseOderViewTable> items = FXCollections.observableArrayList(list);
        plaseOrderTable.setItems(items);
        list.clear();
    }

    public void initialize() {

        plaseOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("BillID"));
        plaseOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ThatDay"));
        plaseOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CusID"));
        getTableInformation();

    }

    public void SearchOrderDetails(KeyEvent keyEvent) {

        String b = searchText.getText();

        for (int a = 0; a < OrderController.listOder4.size(); a++) {
            if (OrderController.listOder4.get(a).getBillID().startsWith(b)) {
                plaseOderViewTable p = new plaseOderViewTable(OrderController.listOder4.get(a).getBillID(), OrderController.listOder4.get(a).getThatDay(), OrderController.listOder4.get(a).getCusID());
                list.add(p);
                ObservableList<plaseOderViewTable> items = FXCollections.observableArrayList(list);
                System.out.println("aaaaaaaaaaa" + list);
                plaseOrderTable.setItems(items);
                plaseOrderTable.refresh();
            } else if (searchText.getText().trim().isEmpty()) {
                list.clear();
                ObservableList<plaseOderViewTable> items = FXCollections.observableArrayList(list);
                plaseOrderTable.setItems(items);
                plaseOrderTable.refresh();
                getTableInformation();
            }
        }
        list.clear();
    }

    public void ViewCustomerPlaseOrderDetails(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2){
            String bilID = getSellectedRowBillID();
            getSelectedRowItemID(bilID);
            getTableDataInCustomerOderInfo(bilID);
            Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/CustomerPlaseOrderView.fxml"));
            Scene se = new Scene(dashRoot);
            Stage primaryStage = (Stage)placeOrderPage.getScene().getWindow();
            primaryStage.setScene(se);
            primaryStage.show();
        }

    }

    public void goToBack(ActionEvent actionEvent) throws IOException {
        Scene se = new Scene(FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/MainView.fxml")));
        Stage primaryStage = (Stage)placeOrderPage.getScene().getWindow();
        primaryStage.setScene(se);
    }

    public  String getSellectedRowBillID(){
        int rowNo = plaseOrderTable.getSelectionModel().getSelectedIndex();
        for(int a=0;a<OrderController.listOder4.size();++a){
            if(a==rowNo) {
                String bilID = OrderController.listOder4.get(a).getBillID();
                System.out.println("@@@"+bilID);
                return bilID;

            }
        }
        return null;
    }


    public void getSelectedRowItemID(String bilID){
        System.out.println("@@@"+bilID);
        System.out.println("&&&&&&&"+OrderController.listOder5);
        for(int a=0;a<OrderController.listOder4.size();a++) {
            if (OrderController.listOder4.get(a).getBillID().equals(bilID)) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaa---------------");
                String Odate = OrderController.listOder4.get(a).getThatDay();
                System.out.println(Odate);
                String OcuId = OrderController.listOder4.get(a).getCusID();
                System.out.println(OcuId);
                plaseOderViewTable pv = new plaseOderViewTable(bilID,Odate,OcuId);
                list2.add(pv);
                System.out.println("$$$$"+list2);

            }
        }
    }

    public  void getTableDataInCustomerOderInfo(String bilID){
        System.out.println("1mmmmmmmmm---------------");
        System.out.println(OrderController.listOder5);
        System.out.println(ItemController.list);
        for(int a=0;a<OrderController.listOder5.size();a++) {
            System.out.println("2mmmmmmmmm---------------");
            if (OrderController.listOder5.get(a).getPlaseOderID().equals(bilID)) {
                System.out.println("3mmmmmmmmm---------------");
                String iID = OrderController.listOder5.get(a).getItemID();
                System.out.println(iID);
                int Oqty = OrderController.listOder5.get(a).getOqty();
                System.out.println(Oqty);
                System.out.println("4mmmmmmmmm---------------");
                for(int b=0;b<ItemController.list.size();b++) {
                    if (ItemController.list.get(b).getItemID().equals(iID)) {
                        System.out.println("5mmmmmmmmm---------------");
                        String Ides = ItemController.list.get(b).getItemDESCRIPTION();
                        double price = ItemController.list.get(b).getItemPRICE();
                        double tot = price * Oqty;
                        OrderTable od = new OrderTable(iID, Ides, price, Oqty, tot);
                        list1.add(od);
                        System.out.println("###" + list1);
                    }
                }
                System.out.println("6mmmmmmmmm---------------");
            }
            System.out.println("7mmmmmmmmm---------------");
        }
        System.out.println("8mmmmmmmmm---------------");
    }

}



