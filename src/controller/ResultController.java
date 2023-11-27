package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class ResultController {
    @FXML
    public Label markstext;

    @FXML
    public ProgressIndicator correct_progress;

    @FXML
    private void initialize() {
//        correcttext.setText("Correct Answers: " + String.valueOf(QuizController.correct));
//        wrongtext.setText("Wrong Answers: " + String.valueOf(QuizController.wrong));
        markstext.setText(QuizController.correct + "/10");

        float correctf = (float) QuizController.correct/10;
        correct_progress.setProgress(correctf);
        System.out.println(correctf);
  }

}
