package controller;

import database.DictionaryData;
import database.WordModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.AutoCompletionBinding;

import java.net.URL;
import java.util.*;

public class searchController implements Initializable {
    @FXML
    private AnchorPane anchorPaneTranslate;
    @FXML
    TextField inputWord;
    @FXML
    ListView<WordModel> wordList;
    private AutoCompletionBinding<WordModel> autoCompletionBinding;

    private Set<WordModel> pos1 = new HashSet<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        wordList.getItems().clear();
        wordList.getItems().addAll(DictionaryData.prefixSearch(""));
    }
    public void inputWordEventHandle(KeyEvent e) {
        pos1.addAll(DictionaryData.prefixSearch(inputWord.getText()));
        wordList.getItems().clear();
        wordList.getItems().addAll(DictionaryData.prefixSearch(inputWord.getText()));
    }


}
