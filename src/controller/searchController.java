package controller;

import api.VoiceRss;
import database.DictionaryData;
import database.WordModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.events.Event;

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

    public void btnVoiceUKClick(MouseEvent mouseEvent) {
        if (selectedWord == null) {
            speak("Linda", "vi-vn", 0.85, "Bạn chưa chọn từ vựng, hãy chọn từ vựng trước !!");
        } else {
            speak("Alice", "en-gb", 0.85, selectedWord.getWord());
        }
    }

    public void btnVoiceUSClick(MouseEvent mouseEvent) {
        if (selectedWord == null) {
            speak("Chi", "vi-vn", 0.85, "Bạn chưa chọn từ vựng, hãy chọn từ vựng trước !!");
        } else {
            speak("Linda", "en-gb", 0.85, selectedWord.getWord());
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


}
