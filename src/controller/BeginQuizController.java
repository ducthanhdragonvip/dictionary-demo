package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BeginQuizController implements Initializable {
    @FXML
    AnchorPane mainQuiz;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            quizPane = FXMLLoader.load(getClass().getResource("/view/QuizC.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    AnchorPane quizPane;
    @FXML
    private Button playquizbtn;

    public void setMainPane(AnchorPane pane) {
        mainQuiz.getChildren().clear();
        mainQuiz.getChildren().addAll(pane);
    }

    public void playquizgame(ActionEvent event) {
        setMainPane(quizPane);
    }


}
