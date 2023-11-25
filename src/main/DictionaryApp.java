package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.io.IOException;


public class DictionaryApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    public Stage stage;
    public static SceneStore sceneStore = new SceneStore();

    @Override
    public void start(Stage primaryStage) throws Exception{
        /* make stage */
        stage = primaryStage;
        try {
            Stage stage = new Stage();
            stage.setTitle("Dictionary App v1.0");
            Image icon = new Image("image/icon.png");
            stage.getIcons().add(icon);
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.setScene(sceneStore.getStartScene());
            stage.setOnCloseRequest(event -> {event.consume();
                CloseRequest(stage);});
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CloseRequest(Stage stage)  {
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
            stage.close();
        }
    }
}