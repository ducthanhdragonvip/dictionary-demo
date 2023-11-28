package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
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

    @FXML
    private void initialize() {
        loadQuestions();
    }

    private String[] questions = {
            "1. How many consonants are there in the English alphabet?",
            "2. Who invented the Light bulb?",
            "3. In the Solar System, which is the farthest planet from the Sun?",
            "4. What is the largest moon in the Solar System?",
            "5. Which of these is 'not' a property of metal?",
            "6. Who discovered Pasteurisation?",
            "7. Hydrochloric acid (HCl) is produced by which part of the body?",
            "8. What is the fastest animal in the world?",
            "9. What is the complementary color of Red?",
            "10. When is World Environment Day?"
    };

    private String[][] options = {
            {"19", "20", "21", "22"},
            {"Thomas Alva Edison", "Alexander Fleming", "Charles Babbage", "Albert Einstein"},
            {"Jupiter", "Saturn", "Uranus", "Neptune"},
            {"Titan", "Ganymede", "Moon", "Europa"},
            {"Good Conduction", "Malleable", "Non Ductile", "Sonourous"},
            {"Alexander Fleming", "Louis Pasteur", "Simon Pasteur", "William Pasteur"},
            {"Small Intestine", "Liver", "Oesophagus", "Stomach"},
            {"Lion", "Blackbuck", "Cheetah", "Quarter Horse"},
            {"Blue", "Green", "Yellow", "Pink"},
            {"5th June", "5th July", "15th June", "25th June"}
    };

    private String[] correctAnswers = {
            "21",
            "Thomas Alva Edison",
            "Neptune",
            "Ganymede",
            "Non Ductile",
            "Louis Pasteur",
            "Stomach",
            "Cheetah",
            "Green",
            "5th June"
    };

    private void loadQuestions() {
        if (counter < questions.length) {
            question.setText(questions[counter]);
            opt1.setText(options[counter][0]);
            opt2.setText(options[counter][1]);
            opt3.setText(options[counter][2]);
            opt4.setText(options[counter][3]);
        }
    }

    boolean checkAnswer(String answer) {
        return answer.equals(correctAnswers[counter]);
    }

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