package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;

public class ResultController {
    @FXML
    public Label markstext;
    @FXML
    AnchorPane beginPaneQuiz;
    @FXML
    AnchorPane resultPane;

    @FXML
    public ProgressIndicator correct_progress;
    @FXML
    private Button continueBtn;

    @FXML
    private void initialize() {
//        correcttext.setText("Correct Answers: " + String.valueOf(QuizController.correct));
//        wrongtext.setText("Wrong Answers: " + String.valueOf(QuizController.wrong));
        markstext.setText(QuizController.correct + "/10");

        float correctf = (float) QuizController.correct/10;
        correct_progress.setProgress(correctf);
        System.out.println(correctf);
    }
    public void setMainPane(AnchorPane pane) {
        resultPane.getChildren().clear();
        resultPane.getChildren().addAll(pane);
    }

    public void setContinueBtn(ActionEvent event) {
        try {
            beginPaneQuiz = FXMLLoader.load(getClass().getResource("/view/Quiz.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        QuizController.correct = 0;
        setMainPane(beginPaneQuiz);
    }
}
