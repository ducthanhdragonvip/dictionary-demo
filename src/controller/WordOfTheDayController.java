package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.time.LocalDate;

public class WordOfTheDayController {

    @FXML
    private Label wordLabel;
    @FXML
    private Label pronunciationLabel;
    @FXML
    private Label partOfSpeechLabel;
    @FXML
    private Label meaningLabel;
    @FXML
    private Label dayLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label yearLabel;

    @FXML
    public void initialize() {
        updateWordOfTheDay();
        updateDate();
    }

    private void updateWordOfTheDay() {
        try {
            Document doc = Jsoup.connect("https://www.merriam-webster.com/word-of-the-day").get();

            // The word itself is the first h1 element
            Element wordElement = doc.select("h1").first();
            // The pronunciation is in a div following the word, you might need to fine-tune this selector
            Element pronunciationElement = doc.select("div.word-and-pronunciation h2").first();
            // Parts of speech and meaning can be extracted similarly
            Element partOfSpeechElement = doc.select("div.word-attributes span.main-attr").first();
            Element meaningElement = doc.select("div.wod-definition-container p:first-of-type").first();

            // Update your labels here
            wordLabel.setText(wordElement.text());
            pronunciationLabel.setText(pronunciationElement.text());
            partOfSpeechLabel.setText(partOfSpeechElement.text());
            meaningLabel.setText(meaningElement.text());
            System.out.println(pronunciationElement.text());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    private void updateDate() {
        LocalDate today = LocalDate.now();
        dayLabel.setText(String.valueOf(today.getDayOfMonth()));
        monthLabel.setText(today.getMonth().toString());
        yearLabel.setText(String.valueOf(today.getYear()));
    }
}
