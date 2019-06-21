package sliit.arryList.countroller;

import ijse.dep.Module.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sliit.arryList.Module.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class OrderController {
    @FXML
    private TextField OrderID;
    @FXML
    private TextField CuID;
    @FXML
    private TextField ItemCord;
    @FXML
    private TextField AvailableQty;
    @FXML
    private TextField CuName;
    @FXML
    private TextField Descrefion;
    @FXML
    private TextField ItemPrice;
    @FXML
    private TextField OrderQty;
    @FXML
    private TextField Total;
    @FXML
    private TextField TodayDate;
    @FXML
    private Button OrderAdd;
    @FXML
    private Button PlaceOrder;
    @FXML
    private Button OrderRemove;
    @FXML
    private TableView<OrderTable> RandomeOrderTable;
    @FXML
    public AnchorPane PlaseOrderDesing;

    static ArrayList<OrderTable> listOder = new ArrayList<>();
    static ArrayList<OrderTable> listOder2 = new ArrayList<>();
    static ArrayList<plaseOderViewTable> listOder4 =  new ArrayList<>();
    static ArrayList<placesOrder> listOder5 = new ArrayList<>();

    public void initialize(){

        creatOderID();
        OrderID.setEditable(false);
        getDateANDTime();
        TodayDate.setEditable(false);

        System.out.println("Hiiiiiiiiiiii");
        RandomeOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        RandomeOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Description"));
        RandomeOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Price"));
        RandomeOrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("OrdQTY"));
        RandomeOrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("tot"));
        ObservableList<OrderTable> items= FXCollections.observableArrayList(listOder);
        RandomeOrderTable.setItems(items);
        calculateoOverRoll();
        RandomeOrderTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrderTable>(){

            @Override
            public void changed(ObservableValue<? extends OrderTable> observable, OrderTable oldValue, OrderTable newValue) {
                ItemCord.setText(String.valueOf(newValue.getItemID()));
                String ItemID = ItemCord.getText();
                Descrefion.setText(newValue.getDescreption());
                ItemPrice.setText(String.valueOf(newValue.getPrice()));
                AvailableQty.setText(String.valueOf(getItemAvQTY(ItemID)));
                OrderQty.setText(String.valueOf(newValue.getOrdQTY()));
            }
        });
        PlaceOrder.setDisable(true);
        OrderRemove.setDisable(true);
        OrderAdd.setDisable(true);
    }

    private void getDateANDTime() {
        Timeline systemDateTime = new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
            TodayDate.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        systemDateTime.setCycleCount(Animation.INDEFINITE);
        systemDateTime.play();
        //System.out.println(itemTemperArray);
    }

    public void GetCustermerName(KeyEvent keyEvent) {
        CuID.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    String customerID = CuID.getText();
                    for(int a=0;a< CustomerController.list.size();a++){
                        if(CustomerController.list.get(a) != null && customerID.equals(CustomerController.list.get(a).getCuId())){
                            String name=CustomerController.list.get(a).getCuname();
                            CuName.setText(name);
                        }
                    }
                }
            }

        });
    }

    public void getTheItemDescreftion(KeyEvent keyEvent) {
        ItemCord.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    String ItemID = ItemCord.getText();
                    getItemDetails(ItemID );
                }

            }
        });
    }

    public void EnableAddButton(KeyEvent keyEvent) {

        int Oqty = Integer.parseInt(OrderQty.getText());
        System.out.println(Oqty);
        String customerID = CuID.getText();
        String ItemID = ItemCord.getText();
        if(CuID.getText().trim().isEmpty()){
            System.out.println("Customer Id is empty");
            return;
        }else if(ItemCord.getText().isEmpty()){
            System.out.println("Item name is empty");
            return;
        }
        else if(OrderQty.getText().trim().isEmpty()){
            System.out.println("KKKKK");
            System.out.println("Order Qty is empty");
            return;
        }else {
            //PlaceOrder/OrderRemove/OrderAdd
            PlaceOrder.setDisable(false);
            OrderRemove.setDisable(false);
            OrderAdd.setDisable(false);
        }
    }
    public void EnableAddButton2(KeyEvent keyEvent) {

        if(CuID.getText().trim().isEmpty()){
            System.out.println("Customer Id is empty");
            return;
        }else if(ItemCord.getText().isEmpty()){
            System.out.println("Item name is empty");
            return;
        }
        else if(OrderQty.getText().trim().isEmpty()){
            System.out.println("Order Qty is empty");
            return;
        }else {
            PlaceOrder.setDisable(false);
            OrderRemove.setDisable(false);
            OrderAdd.setDisable(false);
        }
    }

    public void AddInformationTable(ActionEvent actionEvent) throws NumberFormatException{


        int Oqty = Integer.parseInt(OrderQty.getText());
        String customerID = CuID.getText();
        String ItemID = ItemCord.getText();
        String dis = Descrefion.getText();
        int qty = Integer.parseInt(AvailableQty.getText());
        double UnitPrice = Double.parseDouble(ItemPrice.getText());
        getItemDetails(ItemID);
        double tot =getTotal(Oqty,UnitPrice);

        boolean l= updateAndadd(ItemID);

        if(CuID.getText().trim().isEmpty()){
            System.out.println("Customer Id is empty");
            return;
        }else if(ItemCord.getText().isEmpty()){
            System.out.println("Item name is empty");
            return;
        }
        else if(OrderQty.getText().trim().isEmpty()){
            System.out.println("Order Qty is empty");
            return;
        }else {
//          add
            if (RandomeOrderTable.getSelectionModel().isEmpty()) {

                if(l){
                    OrderTable order = new OrderTable(ItemID, dis, UnitPrice, Oqty, tot);
                    new Alert(Alert.AlertType.INFORMATION, "You are successfully add a Custermer in database", ButtonType.OK).showAndWait();
                    listOder.add(order);
                    ObservableList<OrderTable> items = FXCollections.observableArrayList(listOder);
                    RandomeOrderTable.setItems(items);
                    RandomeOrderTable.refresh();
                    UpdateAvailableAmount(ItemID, Oqty);
                    calculateoOverRoll();
                    Clear();
                    return;
                }

                else {
                    //Oqty
                    for(int w=0;w<listOder.size();w++) {
                        OrderTable orderDe = listOder.get(w);
                        if(orderDe.getItemID().equals(ItemID)){
                            Oqty =orderDe.getOrdQTY()+ Oqty;
                        }
                    }
                    updatedItem(UnitPrice, Oqty,ItemID);
                    calculateoOverRoll();
                }
            }
            //update customer details
            else {
                int x = RandomeOrderTable.getSelectionModel().getSelectedIndex();
                updatedItem(UnitPrice, Oqty,ItemID);
            }

        }

    }

    public void RemovrTheInformationTable(ActionEvent actionEvent) {
        int rowNo = RandomeOrderTable.getSelectionModel().getSelectedIndex();
        listOder.remove(rowNo);
        ObservableList<OrderTable> items= FXCollections.observableArrayList(listOder);
        RandomeOrderTable.setItems(items);
        RandomeOrderTable.refresh();
        Clear();

    }

    public void AddTableData(ActionEvent actionEvent) {

        if(listOder.isEmpty()){
            new Alert(Alert.AlertType.INFORMATION,"First You want add item in table", ButtonType.OK).showAndWait();
            return;
        }else {

            String bilID = OrderID.getText();
            String date = TodayDate.getText();
            String customerID = CuID.getText();

            for(int a=0;a<listOder.size();a++){
                int Oq= listOder.get(a).getOrdQTY();
                String Iid = listOder.get(a).getItemID();
                placesOrder po = new placesOrder(bilID,date,customerID,Iid,Oq);
                listOder5.add(po);
                System.out.println("*******"+listOder5);
            }

            ObservableList<OrderTable> items = FXCollections.observableArrayList(listOder);
            items.clear();
            listOder.clear();
            RandomeOrderTable.setItems(items);
            RandomeOrderTable.refresh();

            creatOderID();
            OrderID.setEditable(false);
            getDateANDTime();
            TodayDate.setEditable(false);

            double tot=0.00;
            Total.setText(String.valueOf(tot));

            listOder.clear();

            Clear();
            CuID.clear();
            CuName.clear();
            CuID.setEditable(true);
            CuName.setEditable(true);

            plaseOderViewTable pl = new plaseOderViewTable(bilID,date,customerID);
            listOder4.add(pl);

        }
    }

    public void goToBack(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/MainView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)PlaseOrderDesing.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void PlaceOrderView(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/PlaseOderView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)PlaseOrderDesing.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
    public void getItemDetails(String ItemID ){
        for(int a=0;a< ItemController.list.size();a++){
            if(ItemController.list.get(a) != null && ItemID.equals(ItemController.list.get(a).getItemID())){
                String name=ItemController.list.get(a).getItemDESCRIPTION();
                Descrefion.setText(name);
                int qty = ItemController.list.get(a).getItemAMOUNT();
                AvailableQty.setText(String.valueOf(qty));
                double UnitPrice =ItemController.list.get(a).getItemPRICE();
                ItemPrice.setText(String.valueOf(UnitPrice));
            }
        }
    }

    public int getItemAvQTY(String ItemID ){
        for(int a=0;a< ItemController.list.size();a++){
            if(ItemController.list.get(a) != null && ItemID.equals(ItemController.list.get(a).getItemID())){
                int qty = ItemController.list.get(a).getItemAMOUNT();
                return qty;
            }
        }

        return 0;
    }

    public double getTotal(int Oqty,double UnitPrice ){
        double OneitemTotal=UnitPrice*Oqty;
        return OneitemTotal;
    }

    public boolean updateAndadd(String ItemID){
        for(int w=0;w<listOder.size();w++) {
            OrderTable orderDe = listOder.get(w);
            if(orderDe.getItemID().equals(ItemID)){
                return false;
            }
        }
        return  true;
    }

    public void calculateoOverRoll(){
        double tot= 0.00;
        for (int i = 0; i < listOder.size() ; i++) {

            tot=listOder.get(i).getTot()+tot;

        }
        Total.setText(String.valueOf(tot));
    }

    public void UpdateAvailableAmount(String Iid, int Oqty){
        int qty=0;
        for (int i = 0; i <ItemController.list.size()  ; i++) {
            item it = ItemController.list.get(i);
            if(it.getItemID().equals(Iid)){
                qty = it.getItemAMOUNT();
                if(qty >= Oqty){
                  qty = qty-Oqty;
                  it.setItemAMOUNT(qty);

                }else{
                    new Alert(Alert.AlertType.INFORMATION,"Item are Overload ", ButtonType.OK).showAndWait();

                }
            }
        }

    }

    public void Clear(){
        CuID.setEditable(false);
        CuName.setEditable(false);
        OrderID.setEditable(false);
        TodayDate.setEditable(false);
        RandomeOrderTable.refresh();
        OrderQty.clear();
        ItemCord.clear();
        Descrefion.clear();
        AvailableQty.clear();
        ItemPrice.clear();
    }

    public  void updatedItem(double UnitPrice,int Oqty,String ItemID){
        for(int w=0;w<listOder.size();w++) {
            OrderTable orderDe = listOder.get(w);
            if(orderDe.getItemID().equals(ItemID)){
                listOder.get(w).setOrdQTY(Oqty);
                double b= Oqty * UnitPrice;
                listOder.get(w).setTot(b);
                Clear();
            }
        }
        calculateoOverRoll();
        UpdateAvailableAmount(ItemID, Oqty);
    }


    public void   creatOderID(){
        LinkedList l= new LinkedList();
        int Size= l.size();
        ID i = new ID(Size);
        String Oid= i.idGenaraer();
        OrderID.setText(Oid);
    }



}
