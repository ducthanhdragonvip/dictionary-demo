package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class QuizController  {
    @FXML
    AnchorPane mainPaneQuiz;
    @FXML
    AnchorPane resultPane;

    public void setMainPane(AnchorPane pane) {
        mainPaneQuiz.getChildren().clear();
        mainPaneQuiz.getChildren().addAll(pane);
    }
    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    public void playSound(String soundFilePath) {
        try {
            URL soundFileUrl = getClass().getResource(soundFilePath);
            File soundFile = new File(soundFileUrl.toURI());

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException | java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
        if (counter == 0) { //Question 1
            question.setText("1. How many consonants are there in the English alphabet?");
            opt1.setText("19");
            opt2.setText("20");
            opt3.setText("21");
            opt4.setText("22");
        }
        if (counter == 1) { //Question 2
            question.setText("2. Who invented the Light bulb?");
            opt1.setText("Thomas Alva Edison");
            opt2.setText("Alexander Fleming");
            opt3.setText("Charles Babbage");
            opt4.setText("Albert Einstein");
        }
        if (counter == 2) { //Question 3
            question.setText("3. In the Solar System, farthest planet from the Sun is");
            opt1.setText("Jupiter");
            opt2.setText("Saturn");
            opt3.setText("Uranus");
            opt4.setText("Neptune");
        }
        if (counter == 3) { //Question 4
            question.setText("4. Largest moon in the Solar System?");
            opt1.setText("Titan");
            opt2.setText("Ganymede");
            opt3.setText("Moon");
            opt4.setText("Europa");
        }
        if (counter == 4) {//Question 5
            question.setText("5. Which of these is 'not' a property of metal?");
            opt1.setText("Good Conduction");
            opt2.setText("Malleable");
            opt3.setText("Non Ductile");
            opt4.setText("Sonourous");
        }
        if (counter == 5) { //Question 6
            question.setText("6. Who discovered Pasteurisation?");
            opt1.setText("Alexander Fleming");
            opt2.setText("Louis Pasteur");
            opt3.setText("Simon Pasteur");
            opt4.setText("William Pasteur");
        }
        if (counter == 6) { //Question 7
            question.setText("7. Hydrochloric acid (HCl) is produced by -?");
            opt1.setText("Small Intestine");
            opt2.setText("Liver");
            opt3.setText("Oesophagus");
            opt4.setText("Stomach");
        }
        if (counter == 7) { //Question 8
            question.setText("8. The fastest animal in the world is -");
            opt1.setText("Lion");
            opt2.setText("Blackbuck");
            opt3.setText("Cheetah");
            opt4.setText("Quarter Horse");
        }
        if (counter == 8) { //Question 9
            question.setText("9. Complementary colour of Red is -");
            opt1.setText("Blue");
            opt2.setText("Green");
            opt3.setText("Yellow");
            opt4.setText("Pink");
        }
        if (counter == 9) { //Question 10
            question.setText("10. World Environment Day is on -");
            opt1.setText("5th June");
            opt2.setText("5th July");
            opt3.setText("15th June");
            opt4.setText("25th June");
        }

    }

    @FXML
    public void opt1clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt1.getText().toString());
        if (isCorrect) {
            correct = correct + 1;
            opt1.setStyle("-fx-background-color: green; -fx-background-radius: 90px");
            playSound("/audio/correct_sound_effect.wav"); // Chơi âm thanh khi đúng
        } else {
            wrong = wrong + 1;
            opt1.setStyle("-fx-background-color: red; -fx-background-radius: 90px");
            playSound("/audio/wrong_sound_effect.wav"); // Chơi âm thanh khi sai
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    opt1.setStyle("-fx-background-color: dodgerblue; -fx-background-radius: 90px");

                    if (counter == 9) {
                        try {
                            resultPane = FXMLLoader.load(getClass().getResource("/view/result.fxml"));
                            setMainPane(resultPane);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        counter++;
                        loadQuestions();
                    }
                })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }


    boolean checkAnswer(String answer) {

        if (counter == 0) {
            if (answer.equals("21")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 1) {
            if (answer.equals("Thomas Alva Edison")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 2) {
            if (answer.equals("Neptune")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 3) {
            if (answer.equals("Ganymede")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 4) {
            if (answer.equals("Non Ductile")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 5) {
            if (answer.equals("Louis Pasteur")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 6) {
            if (answer.equals("Stomach")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 7) {
            if (answer.equals("Cheetah")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 8) {
            if (answer.equals("Green")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 9) {
            if (answer.equals("5th June")) {
                return true;
            } else {
                return false;
            }
        }
        return false;


    }

    @FXML
    public void opt2clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt2.getText().toString());
        if (isCorrect) {
            correct = correct + 1;
            opt2.setStyle("-fx-background-color: green; -fx-background-radius: 90px");
            playSound("/audio/correct_sound_effect.wav"); // Chơi âm thanh khi đúng
        } else {
            wrong = wrong + 1;
            opt2.setStyle("-fx-background-color: red; -fx-background-radius: 90px");
            playSound("/audio/wrong_sound_effect.wav"); // Chơi âm thanh khi sai
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    opt2.setStyle("-fx-background-color: dodgerblue; -fx-background-radius: 90px");

                    if (counter == 9) {
                        try {
                            resultPane = FXMLLoader.load(getClass().getResource("/view/result.fxml"));
                            setMainPane(resultPane);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        counter++;
                        loadQuestions();
                    }
                })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    @FXML
    public void opt3clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt3.getText().toString());
        if (isCorrect) {
            correct = correct + 1;
            opt3.setStyle("-fx-background-color: green; -fx-background-radius: 90px");
            playSound("/audio/correct_sound_effect.wav"); // Chơi âm thanh khi sai
        } else {
            wrong = wrong + 1;
            opt3.setStyle("-fx-background-color: red; -fx-background-radius: 90px");
            playSound("/audio/wrong_sound_effect.wav"); // Chơi âm thanh khi sai
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    opt3.setStyle("-fx-background-color: dodgerblue; -fx-background-radius: 90px");

                    if (counter == 9) {
                        try {
                            resultPane = FXMLLoader.load(getClass().getResource("/view/result.fxml"));
                            setMainPane(resultPane);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        counter++;
                        loadQuestions();
                    }
                })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    @FXML
    public void opt4clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt4.getText().toString());
        if (isCorrect) {
            correct = correct + 1;
            opt4.setStyle("-fx-background-color: green; -fx-background-radius: 90px");
            playSound("/audio/correct_sound_effect.wav"); // Chơi âm thanh khi sai
        } else {
            wrong = wrong + 1;
            opt4.setStyle("-fx-background-color: red; -fx-background-radius: 90px");
            playSound("/audio/wrong_sound_effect.wav"); // Chơi âm thanh khi sai
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    opt4.setStyle("-fx-background-color: dodgerblue; -fx-background-radius: 90px");

                    if (counter == 9) {
                        try {
                            resultPane = FXMLLoader.load(getClass().getResource("/view/result.fxml"));
                            setMainPane(resultPane);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        counter++;
                        loadQuestions();
                    }
                })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }
}
