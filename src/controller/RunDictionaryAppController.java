package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.DictionaryApp;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RunDictionaryAppController implements Initializable {
    private Button startButton;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonStartClick(MouseEvent mouseEvent) {
    // Lấy stage đang được scene đầu tiên dùng
        Stage getStage = (Stage) startButton.getScene().getWindow();
        try {
            Scene sceneUse = DictionaryApp.sceneStore.getAppScene();
            getStage.setTitle("Dictionary Eng-Vie v1.0");
            getStage.setScene(sceneUse);
            getStage.centerOnScreen();
            getStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitButtonClick(MouseEvent e) {
        // tHÔNG BÁO LÀ KIỂU CẢNH BÁO
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // LẤY BIỂU TƯỢNG THÔNG QUA STAGE HIỆN TẠI
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/image/translate-icon.png").toString()));
        // tạo ảnh cảnh báo trên alert
        ImageView warningPic = new ImageView(this.getClass().getResource("/image/warning.png").toString());
        warningPic.setFitWidth(50);
        warningPic.setFitHeight(50);
        alert.setGraphic(warningPic);
        // tạo thông tin alert khi thoát
        alert.setTitle("Thông báo");
        alert.setHeaderText("Bạn có muốn thoát chương trình ?");
        alert.setContentText("Bấm \"Có\" để thoát, bấm \"Quay lại\" để quay lại !");
        ButtonType yes = new ButtonType("Có", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("Quay lại", ButtonBar.ButtonData.NO);
        // Xử lí khi bấm các button
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes) {
            // Nếu bấm nút "Có" thì thoát chương trình
            System.exit(0);
        } else {
            // Nếu không thì quay trở lại Scene đang hiển thị
            alert.close();
        }
    }
}
