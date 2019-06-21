package sliit.arryList.countroller;

import sliit.arryList.Module.item;
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

public class ItemController {
    @FXML
    public AnchorPane InventryFrom;
    @FXML
    private TextField ItemId;
    @FXML
    private TextField ItemName;
    @FXML
    private TextField ItemDescription;
    @FXML
    private TextField ItemAmount;
    @FXML
    private TextField ItemPrice;
    @FXML
    private TableView<item> ItemTable;
    static ArrayList<item> list = new ArrayList<>();
    public void initialize(){

        ItemTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        ItemTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ItemNAME"));
        ItemTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ItemDESCRIPTION"));
        ItemTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ItemAMOUNT"));
        ItemTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("ItemPRICE"));
        ObservableList<item> items= FXCollections.observableArrayList(list);
        ItemTable.setItems(items);

        ItemTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<item>() {
            @Override
            public void changed(ObservableValue<? extends item> observable, item oldValue, item newValue) {
                ItemId.setText(newValue.getItemID());
                ItemName.setText(newValue.getItemNAME());
                ItemDescription.setText(newValue.getItemDESCRIPTION());
                ItemAmount.setText(String.valueOf(newValue.getItemAMOUNT()));
                ItemPrice.setText(String.valueOf(newValue.getItemPRICE()));
                ItemId.setEditable(false);
                ItemName.setEditable(true);
                ItemDescription.setEditable(true);
                ItemAmount.setEditable(true);
                ItemPrice.setEditable(true);
            }
        });

    }

    public void CreatNewItem(ActionEvent actionEvent) {
        ItemId.setEditable(true);
        ItemName.setEditable(true);
        ItemDescription.setEditable(true);
        ItemAmount.setEditable(true);
        ItemPrice.setEditable(true);
        ItemId.clear();
        ItemName.clear();
        ItemDescription.clear();
        ItemAmount.clear();
        ItemPrice.clear();
    }

    public void GoToTheBack(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/MainView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)InventryFrom.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void SaveItem(ActionEvent actionEvent) {
        String Iid=ItemId.getText();
        String Iname=ItemName.getText();
        String Ides = ItemDescription.getText();
        int Iqty= Integer.parseInt(ItemAmount.getText());
        double Iprice = Double.parseDouble(ItemPrice.getText());


        int x = ItemTable.getSelectionModel().getSelectedIndex();
        if(Iid.trim().isEmpty()){
            System.out.println("Item Id is empty");
            return;
        }else if(Iname.trim().isEmpty()){
            System.out.println("Item name is empty");
            return;
        }else if(Ides.trim().isEmpty()){
            System.out.println("Item description is empty");
            return;
        }else if(ItemAmount.getText().trim().isEmpty()){
            System.out.println("Item qty is empty");
            return;
        }else if(ItemPrice.getText().trim().isEmpty()){
            System.out.println("Item price is empty");
            return;
        }
        item i = new item(Iid,Iname,Ides,Iqty,Iprice);
        //Add Customer details
        if(ItemTable.getSelectionModel().isEmpty()){
            for(int w=0;w<list.size();w++){
                item cu = list.get(w);
                if(cu.getItemID().equals(Iid)){
                    new Alert(Alert.AlertType.ERROR,"Item is already in", ButtonType.OK).show();
                    return;
                }
                else{
                    new Alert(Alert.AlertType.INFORMATION,"You are successfully add a Custermer in database", ButtonType.OK).showAndWait();
                    list.add(i);
                    ObservableList<item> items= FXCollections.observableArrayList(list);
                    ItemTable.setItems(items);
                    ItemTable.refresh();
                    ItemName.setEditable(false);
                    ItemDescription.setEditable(false);
                    ItemAmount.setEditable(false);
                    ItemId.setEditable(false);
                    ItemPrice.setEditable(false);
                    return;
                }
            }
        }
        //update customer details
        else{
            for(int w=0;w<list.size();w++) {
                item it = list.get(w);
                if (it.getItemID().equals(Iid)) {
                    it.setItemNAME(Iname);
                    it.setItemDESCRIPTION(Ides);
                    it.setItemAMOUNT(Iqty);
                    it.setItemPRICE(Iprice);
                    ObservableList<item> items= FXCollections.observableArrayList(list);
                    ItemTable.setItems(items);
                    ItemTable.refresh();
                    ItemName.setEditable(false);
                    ItemDescription.setEditable(false);
                    ItemAmount.setEditable(false);
                    ItemId.setEditable(false);
                    ItemPrice.setEditable(false);
                }
            }
        }
    }

    public void DeletedItem(ActionEvent actionEvent) {
        int rowNo = ItemTable.getSelectionModel().getSelectedIndex();
        list.remove(rowNo);
        new Alert(Alert.AlertType.ERROR,"Customer Deleted", ButtonType.OK).show();
        ItemName.setEditable(true);
        ItemDescription.setEditable(true);
        ItemAmount.setEditable(true);
        ItemId.setEditable(true);
        ItemPrice.setEditable(true);
        ItemId.clear();
        ItemName.clear();
        ItemDescription.clear();
        ItemAmount.clear();
        ItemPrice.clear();
        ObservableList<item> items= FXCollections.observableArrayList(list);
        ItemTable.setItems(items);
        ItemTable.refresh();
    }
    static {
        list.add(new item("I001", "Mouse","q", 25, 50.00));
        list.add(new item("I002", "Keyboard","a", 35, 500.00));
        list.add(new item("I003", "Monitors","z", 55, 5078.00));
        list.add(new item("I004", "Subwoofers","w", 35, 50.90));
    }
}
