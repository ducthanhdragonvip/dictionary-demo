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
    private Label exampleLable;
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


            // The word on the website
            Element wordElement = doc.select("div.word-and-pronunciation h2").first();
            // Phiên âm

            Element pronunciationElement = doc.select("div.word-attributes span.word-syllables").first();
            //Noun, adjectives, verb
            Element partOfSpeechElement = doc.select("div.word-attributes span.main-attr").first();

            Element exampleLabelElement =  doc.select("body > div.outer-container > div > div.main-wrapper.clearfix > main > article > div.lr-cols-area.clearfix.sticky-column.d-flex > div.left-content > div > div.wod-definition-container > p:nth-child(3)").first();

            Element meaningElement = doc.select("div.wod-definition-container p:first-of-type").first();

            // Update your labels here
            wordLabel.setText(wordElement.text());
            pronunciationLabel.setText(pronunciationElement.text());
            partOfSpeechLabel.setText(partOfSpeechElement.text());
            exampleLable.setText(exampleLabelElement.text());
            meaningLabel.setText(meaningElement.text());
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
