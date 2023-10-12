package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.DictionaryApp;

import javafx.event.ActionEvent;

public class mainAppController {
    @FXML
    AnchorPane mainPane;

    @FXML
    Button buttonGoBack;

    public void setButtonGoBack(ActionEvent event) {
        Stage getStage =(Stage) mainPane.getScene().getWindow();
        try {
            Scene sceneUse = DictionaryApp.sceneStore.getStartScene();
            getStage.setTitle("Dictionary v1.0");
            getStage.setScene(sceneUse);
            getStage.centerOnScreen();
            getStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
