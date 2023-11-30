package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Label Example;
    @FXML
    private TextArea contextLabel;
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



            Element meaningElement = doc.select("div.wod-definition-container p:first-of-type").first();

            Element exampleElement = doc.select("div.wod-definition-container p").get(1);

            Element contextElement = doc.select("div.wod-definition-container p:first-of-type").get(1);

            // Update your labels here
            wordLabel.setText(wordElement.text());
            pronunciationLabel.setText(pronunciationElement.text());
            partOfSpeechLabel.setText(partOfSpeechElement.text());
            meaningLabel.setText(meaningElement.text());
            contextLabel.setText(contextElement.text());

            if (exampleElement != null) {
                String exampleText = exampleElement.text();
                Example.setText(exampleText);
            } else {
                // Xử lý trường hợp không tìm thấy ví dụ
                Example.setText("Can not find example.");
            }
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
