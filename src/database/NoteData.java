package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NoteData implements Initializable {
    private static int idMax = 0;
    private static final RadixTree<WordModel> tree = new RadixTree<>();

    @FXML
    static ListView<WordModel> notesList;
    @FXML
    TextArea textShowMeaning;
    private WordModel selectedWord;

    static {
        importFromDatabase();
    }

    public void initialize(URL location, ResourceBundle resources) {
        reset();
    }

    public static void insertWord(String word, String meaning) {
        idMax ++;
        tree.insert(new String(word + String.valueOf(idMax)).toLowerCase(),new WordModel(idMax, word, meaning));
        MysqlConnector.addingNote(idMax, word, meaning);
    }

    public static void delete(WordModel word) {
        tree.delete(new String(word.getWord() + String.valueOf(word.getIndex())).toLowerCase());
        MysqlConnector.deleteNote(word.getIndex());
        reset();
    }
    public static void update(WordModel word, String newMeaning) {
        word.setMeaning(newMeaning);
        MysqlConnector.updateNote(word.getIndex(), newMeaning);
    }

    public static ArrayList<WordModel> prefixSearch(String prefix) {
        prefix = prefix.toLowerCase();
        return tree.prefixSearch(prefix, 100);
    }

    public static void importFromDatabase() {
        ArrayList<WordModel> wordModels = new ArrayList<>();
        MysqlConnector.takeNoteData(wordModels);
        for (WordModel w : wordModels) {
            idMax = Math.max(w.getIndex(), idMax);
            tree.insert(new String(w.getWord() + String.valueOf(w.getIndex())).toLowerCase(), w);
        }
    }

    public static void reset() {
        if(notesList != null) notesList.getItems().addAll(NoteData.prefixSearch(""));
    }
}
