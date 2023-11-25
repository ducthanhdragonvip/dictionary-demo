package controller;

import api.VoiceRss;
import database.DictionaryData;
import database.NoteData;
import database.WordModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class searchController implements Initializable {
    @FXML
    private AnchorPane anchorPaneTranslate;
    @FXML
    TextField inputWord;
    @FXML
    ListView<WordModel> wordList;
    @FXML
    TextArea textShowMeaning;
    private WordModel selectedWord;

    public Stage stage;
    NoteData Note;
    public void btnVoiceUKClick(MouseEvent mouseEvent) {
        if (selectedWord == null) {
            speak("Linda", "vi-vn", 0.85, "Bạn chưa chọn từ vựng, hãy chọn từ vựng trước !!");
        } else {
            speak("Amy", "en-gb", 0.85, selectedWord.getWord());
        }
    }

    public void btnVoiceUSClick(MouseEvent mouseEvent) {
        if (selectedWord == null) {
            speak("Chi", "vi-vn", 0.85, "Bạn chưa chọn từ vựng, hãy chọn từ vựng trước !!");
        } else {
            speak("Linda", "en-us", 0.85, selectedWord.getWord());
        }
    }

    private void speak(String name, String language, double speed, String word) {
        try {
            VoiceRss.Name = name;
            VoiceRss.language = language;
            VoiceRss.speed = speed;
            VoiceRss.speakWord(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textShowMeaning.setEditable(false);
        wordList.getItems().clear();
        wordList.getItems().addAll(DictionaryData.prefixSearch(""));
    }
    public void inputWordEventHandle(KeyEvent e) {
        wordList.getItems().clear();
        wordList.getItems().addAll(DictionaryData.prefixSearch(inputWord.getText()));
    }

    public void wordListClicked(MouseEvent e) {
        selectedWord = wordList.getSelectionModel().getSelectedItem();
        if (selectedWord != null) {
            textShowMeaning.setText(selectedWord.getMeaning());
        } else {
            textShowMeaning.setText("");
        }
    }

    public void addWordEventHandle(MouseEvent e) {
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
        if (alert.showAndWait().get() == ButtonType.OK) {
            insertWord(word,meaning);
            stageAlert.close();
        }
    }

    public void insertWord(String word, String meaning) {
        NoteData.insertWord(word, meaning);
    }
}
