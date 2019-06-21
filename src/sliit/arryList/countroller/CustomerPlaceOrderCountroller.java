package sliit.arryList.countroller;

import sliit.arryList.Module.OrderTable;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerPlaceOrderCountroller {

    public AnchorPane placeOrderPage1;
    @FXML
    public TextField OrderID;
    @FXML
    public TextField CuName;
    @FXML
    public TextField Total;
    @FXML
    public TextField TodayDate;
    @FXML
    public TextField CuID;
    @FXML
    private TableView<OrderTable> RandomeOrderTable1;
    static ArrayList<OrderTable> list = new ArrayList<>();



    public void initialize() {

        RandomeOrderTable1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        RandomeOrderTable1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Descreption"));
        RandomeOrderTable1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Price"));
        RandomeOrderTable1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("OrdQTY"));
        RandomeOrderTable1.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("tot"));
        list=PlaceOrderController.list1;
        System.out.println(list);
        ObservableList<OrderTable> items = FXCollections.observableArrayList(list);
        RandomeOrderTable1.setItems(items);
        for(int a=0;a<PlaceOrderController.list2.size();a++){
            OrderID.setText(PlaceOrderController.list2.get(a).getBillID());
            TodayDate.setText(PlaceOrderController.list2.get(a).getThatDay());
            CuID.setText(PlaceOrderController.list2.get(a).getCusID());
            getCustermerName(PlaceOrderController.list2.get(a).getCusID());
            getTotal();
        }
        list.clear();

    }


    public void goToBack(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/MainView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)placeOrderPage1.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void PlaceOrderView(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/PlaseOderView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)placeOrderPage1.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
        System.out.println("fffff"+list);
    }

    public void getCustermerName(String Cid){
        for(int a=0;a<CustomerController.list.size();a++){
            if(CustomerController.list.get(a).getCuId().equals(Cid)) {
                CuName.setText(CustomerController.list.get(a).getCuname());
            }
        }

    }

    public void getTotal(){
        double tot =0;
        for(int a=0;a<PlaceOrderController.list1.size();a++){
            double t = PlaceOrderController.list1.get(a).getTot();
            tot=t+tot;
            Total.setText(String.valueOf(tot));
        }
    }






}
