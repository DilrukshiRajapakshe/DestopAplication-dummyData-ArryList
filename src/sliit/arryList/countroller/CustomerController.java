package sliit.arryList.countroller;

import sliit.arryList.Module.customer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerController {
    @FXML
    public AnchorPane CustomerForm;
    @FXML
    private TextField CustermerId;
    @FXML
    private TextField CustomerAddress;
    @FXML
    private TextField CustomerName;

    @FXML
    private TableView<customer> CustomerTable;

    static ArrayList<customer> list = new ArrayList<>();

    public void initialize(){

        CustomerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CuId"));
        CustomerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Cuname"));
        CustomerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CuAddress"));

        ObservableList<customer> items= FXCollections.observableArrayList(list);
        CustomerTable.setItems(items);

        CustomerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<customer>() {
            @Override
            public void changed(ObservableValue<? extends customer> observable, customer oldValue, customer newValue) {
                CustermerId.setText(newValue.getCuId());
                CustomerName.setText(newValue.getCuname());
                CustomerAddress.setText(newValue.getCuAddress());
                CustermerId.setEditable(false);
                CustomerName.setEditable(true);
                CustomerAddress.setEditable(true);
            }
        });

    }

    public void CreatNewCustomer(ActionEvent actionEvent) {
        CustermerId.setEditable(true);
        CustomerName.setEditable(true);
        CustomerAddress.setEditable(true);
        CustermerId.clear();
        CustomerName.clear();
        CustomerAddress.clear();
    }

    public void GoToTheBack(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/MainView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)CustomerForm.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void SaveCustomer(ActionEvent actionEvent) {
        String Cid=CustermerId.getText();
        String Cname=CustomerName.getText();
        String Cadd=CustomerAddress.getText();

        int x = CustomerTable.getSelectionModel().getSelectedIndex();
        if(Cid.trim().isEmpty()){
            System.out.println("Custermer Id is empty");
            return;
        }else if(Cname.trim().isEmpty()){
            System.out.println("Custermer name is empty");
            return;
        }else if(Cadd.trim().isEmpty()){
            System.out.println("Custermer address is empty");
            return;
        }

        customer c = new customer(Cid,Cname,Cadd);
        //Add Customer details
        if(CustomerTable.getSelectionModel().isEmpty()){
            for(int w=0;w<list.size();w++){
                customer cu = list.get(w);
                if(cu.getCuId().equals(Cid)){
                    new Alert(Alert.AlertType.ERROR,"Custermer Id is already in", ButtonType.OK).show();
                    return;
                }
                else{
                    new Alert(Alert.AlertType.INFORMATION,"You are successfully add a Custermer in database", ButtonType.OK).showAndWait();
                    list.add(c);
                    ObservableList<customer> items= FXCollections.observableArrayList(list);
                    CustomerTable.refresh();
                    CustomerTable.setItems(items);
                    CustermerId.setEditable(false);
                    CustomerName.setEditable(false);
                    CustomerAddress.setEditable(false);
                    return;
                }
            }
        }
        //update customer details
        else{
            for(int w=0;w<list.size();w++) {
                customer cu = list.get(w);
                if (cu.getCuId().equals(Cid)) {
                    cu.setCuname(Cname);
                    cu.setCuAddress(Cadd);
                    ObservableList<customer> items= FXCollections.observableArrayList(list);
                    CustomerTable.setItems(items);
                    CustomerTable.refresh();
                    CustermerId.setEditable(false);
                    CustomerName.setEditable(false);
                    CustomerAddress.setEditable(false);
                }
            }
        }
    }

    public void DeletedCustomer(ActionEvent actionEvent) {
        int rowNo = CustomerTable.getSelectionModel().getSelectedIndex();
        list.remove(rowNo);
        new Alert(Alert.AlertType.ERROR,"Customer Deleted", ButtonType.OK).show();
        CustermerId.setEditable(true);
        CustomerName.setEditable(true);
        CustomerAddress.setEditable(true);
        CustermerId.clear();
        CustomerName.clear();
        CustomerAddress.clear();
        ObservableList<customer> items= FXCollections.observableArrayList(list);
        CustomerTable.setItems(items);
        CustomerTable.refresh();
    }

    static {
        list.add(new customer("C001","Kasun","Galle"));
        list.add(new customer("C002","Ranga","Panadura"));
        list.add(new customer("C003","Nuwan","Kagalle"));
        list.add(new customer("C004","Kasun","Matara"));
    }
}
