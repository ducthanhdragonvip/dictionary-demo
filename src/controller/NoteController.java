package controller;

import database.DictionaryData;
import database.NoteData;
import database.WordModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NoteController implements Initializable {
    @FXML
    ListView<WordModel> notesList;
    @FXML
    TextArea noteShowMeaning;
    private WordModel selectedWord;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noteShowMeaning.setEditable(false);
        notesList.getItems().addAll(NoteData.prefixSearch(""));
    }

    public void notesListClicked(MouseEvent e) {
        selectedWord = notesList.getSelectionModel().getSelectedItem();

        if (selectedWord != null) {
            noteShowMeaning.setText(selectedWord.getMeaning());
        } else {
            noteShowMeaning.setText("");
        }
    }

    public void deleteBtnClicked(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Image icon = new Image("image/icon1.png");
        ImageView warningPic = new ImageView(this.getClass().getResource("/image/warning.png").toString());
        warningPic.setFitWidth(100);
        warningPic.setFitHeight(100);
        alert.setGraphic(warningPic);
        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
        stageAlert.getIcons().add(icon);

        alert.setTitle("Alert");
        alert.setHeaderText("Bạn có muốn thêm từ không?");
        alert.setContentText("Click \"Có\" to exit, click \"Không\" to return ");

        String word = selectedWord.getWord();
        String meaning = selectedWord.getMeaning();
        if (selectedWord != null) {
            NoteData.delete(selectedWord);
            selectedWord = null;
            //Alert("Xoá dữ liệu thành công", "Xem lại danh sách từ !!", "/image/btnConfirm.png");
        } else {
            //Alert("Bạn chưa chọn dữ liệu trên bảng", "Hãy chọn dữ liệu trước !!", "/Image/warning.png");
        }
    }
}
