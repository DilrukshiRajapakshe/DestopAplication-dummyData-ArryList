package sliit.arryList.countroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public AnchorPane MainFrame;
    public void GoToCustemerManagement(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/CustermerView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void GoToTheInventryManagement(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/ItemView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        //primaryStage.show();
    }

    public void GotoThePlaseOrder(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/arryList/View/OderView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        //primaryStage.show();
    }
}
