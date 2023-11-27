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

//        int correct = QuizController.correct;

//        if (correct<2) {
//            remark.setText("Oh no..! You have failed the quiz. It seems that you need to improve your general knowledge. Practice daily! Check your results here.");
//        } else if (correct>=2 && correct<5) {
//            remark.setText("Oops..! You have scored less marks. It seems like you need to improve your general knowledge. Check your results here.");
//        } else if (correct>=5 && correct<=7) {
//            remark.setText("Good. A bit more improvement might help you to get better results. Practice is the key to success. Check your results here.");
//        } else if (correct==8 || correct==9) {
//            remark.setText("Congratulations! Its your hardwork and determination which helped you to score good marks. Check you results here.");
//        } else if (correct==10) {
//            remark.setText("Congratulations! You have passed the quiz with full marks because of your hardwork and dedication towards studies. Keep it up! Check your results here.");
//        }

  }

}
