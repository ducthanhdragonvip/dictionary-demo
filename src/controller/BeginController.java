package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.DictionaryApp;

public class BeginController {
    @FXML
    private Button BeginButton;
    private Button playquizbtn;
//    @FXML
//    private void initialize() {
//        playquizbtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                try {
//                    Stage thisstage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
//                    thisstage.close();
//
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuizC.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = new Stage();
//                    stage.setScene(scene);
//                    stage.initStyle(StageStyle.TRANSPARENT);
//                    scene.setFill(Color.TRANSPARENT);
//                    stage.show();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }


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