package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.DictionaryApp;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class mainAppController implements Initializable {
    @FXML
    AnchorPane mainPane;
    AnchorPane searchPane;
    AnchorPane translatePane;
    @FXML
    Button buttonGoBack;

    @FXML
    Button btnSearch;
    @FXML
    Button translateButton;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            searchPane = FXMLLoader.load(getClass().getResource("/view/searchScene.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            translatePane = FXMLLoader.load(getClass().getResource("/view/translatePane.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setMainPane(searchPane);
    }

    public void setMainPane(AnchorPane pane) {
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);
    }

    public void setBtnSearch (ActionEvent event) {
        setMainPane(searchPane);
    }

    public void btnParagraphTranslate(ActionEvent event) {
        setMainPane(translatePane);
    }

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
