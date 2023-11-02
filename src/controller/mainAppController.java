package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    AnchorPane addWord;

    @FXML
    Button buttonGoBack;
    @FXML
    Button btnSearch;
    @FXML
    Button translateButton;
    @FXML
    Button btnHome;
    @FXML
    Button btnNote;
    @FXML
    Button btnGame;
    @FXML
    Button btnAdd;
    @FXML
    Button btnConfig;



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
        try {
            addWord = FXMLLoader.load(getClass().getResource("/view/addWord.fxml"));
            String css = this.getClass().getResource("/styleFile/inviButton.css").toExternalForm();
            addWord.getStylesheets().add(css);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setMainPane(searchPane);
    }

    public void btnFocus(Button button) {
        button.setStyle("-fx-background-color: linear-gradient(to right,#b4caff,#72c5ff, #7ee9ff);");
    }

    public void btnDefault() {
        buttonGoBack.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnSearch.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnAdd.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnGame.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnNote.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnHome.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        translateButton.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
        btnConfig.setStyle("-fx-background-color: #E0FFFF;-fx-background-radius: 0 20 20 0;");
    }

    public void setMainPane(AnchorPane pane) {
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);
    }

    public void setBtnHome(ActionEvent event) {
        btnDefault();
        btnFocus(btnHome);
    }

    public void setBtnSearch (ActionEvent event) {
        btnDefault();
        btnFocus(btnSearch);
        setMainPane(searchPane);
    }

    public void btnParagraphTranslate(ActionEvent event) {
        btnDefault();
        btnFocus(translateButton);
        setMainPane(translatePane);
    }

    public void setBtnNote(ActionEvent event) {
        btnDefault();
        btnFocus(btnNote);
    }

    public void setBtnGame(ActionEvent event) {
        btnDefault();
        btnFocus(btnGame);
    }

    public void setBtnAdd(ActionEvent event) {
        btnDefault();
        btnFocus(btnAdd);
        setMainPane(addWord);
    }

    public void setBtnConfig(ActionEvent event) {
        btnDefault();
        btnFocus(btnConfig);
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
