package controller;

import database.NoteData;
import database.WordModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

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
        notesList.getItems().clear();
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
}
