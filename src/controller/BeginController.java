package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.DictionaryApp;

public class BeginController {
    @FXML
    private Button BeginButton;

    public void BeginButton(ActionEvent e) {
        Stage getStage = (Stage) BeginButton.getScene().getWindow();
        try {
            Scene sceneUse = DictionaryApp.sceneStore.getAppScene();
            getStage.setTitle("Dictionary v1.0");
            getStage.setScene(sceneUse);
            getStage.centerOnScreen();;
            getStage.show();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    public void exitButton(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Image icon = new Image("image/icon1.png");
        ImageView warningPic = new ImageView(this.getClass().getResource("/image/warning.png").toString());
        warningPic.setFitWidth(100);
        warningPic.setFitHeight(100);
        alert.setGraphic(warningPic);
        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
        stageAlert.getIcons().add(icon);

        alert.setTitle("Alert");
        alert.setHeaderText("Do you want to exit ?");
        alert.setContentText("Click \"OK\" to exit, click \"Cancel\" to return ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.exit(0);
        }
    }
}