package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class paragraphTranslateController implements Initializable {
    @FXML
    Button btnTrans;

    @FXML
    private TextArea paraContent;
    @FXML
    private TextArea paraTransed;
    @FXML
    private Text langFrom;
    @FXML
    private Text langTo;

    public void initialize(URL location, ResourceBundle resources) {
        btnTrans.setFocusTraversable(false);
    }

    // Mở hướng dẫn sử dụng

    public void btnShowIntroClick(MouseEvent mouseEvent) {
        try {
            String s = System.getProperty("user.dir");
            File introFile = new File(s + "\\src\\intro\\file.txt");
            if (introFile.exists()) {
                Desktop.getDesktop().open(introFile);
            } else {
                showAlert("Không tìm thấy file", "Hãy thử lại", "/image/warning.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String alertContent, String guideContent, String icon) {
        // Tạo thông báo là kiểu cảnh báo
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // Lấy biểu tượng qua stage
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/Image/warning.png").toString()));
        // tạo ảnh cảnh báo trên alert
        ImageView warningPic = new ImageView(this.getClass().getResource(icon).toString());
        warningPic.setFitWidth(50);
        warningPic.setFitHeight(50);
        alert.setGraphic(warningPic);
        // tạo thông tin alert
        alert.setTitle("Thông báo");
        alert.setHeaderText(alertContent);
        alert.setContentText(guideContent);
        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        // Xử lí khi bấm các button
        alert.getButtonTypes().setAll(buttonTypeOK);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK) {
            alert.close();
        }
    }

    // Chỉnh ngôn ngữ
    @FXML
    private void btnChangeLanguageEventHandle(ActionEvent e) {
        String s1 = null;
        s1 = langFrom.getText().toString();
        String s2 = null;
        s2 = langTo.getText().toString();
        langFrom.setText(s2);
        langTo.setText(s1);
        paraContent.setText("");
        paraTransed.setText("");
    }

    // Dịch
    public void btnTranslateParagraphEventHandle(ActionEvent event) {
        String paragraphs = paraContent.getText().toString().toLowerCase();
        if (!paragraphs.isEmpty()) {
            String s1 = langFrom.getText().toString();
            String s2 = langTo.getText().toString();
            String result = (String) api.GGTranslateAPI.googleTranslate(splitString(s1), splitString(s2), paragraphs);
            paraTransed.setText(result);
        } else {
            showAlert("Bạn chưa nhập văn bản cần dịch", "Hãy nhập văn bản !", "/image/warning.png");
        }
    }

    private String splitString(String word) {
        String[] child = word.split("-");
        return child[0].trim();
    }
}
