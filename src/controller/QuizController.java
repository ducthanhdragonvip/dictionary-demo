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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    private int currentQuestionIndex = 0;
    private List<QuizSet> quizSets = new ArrayList<>();

    Random random = new Random();
    int selectedQuizIndex = random.nextInt(5);
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize() {
        loadQuizSets();
    }

    private void loadQuizSets() {
        /**
         *Bộ 1: Random
         */
        String[] questions1 = new String[] {
                "1. How many consonants are there in the English alphabet?",
                "2. Who invented the Light bulb",
                "3. In the Solar System, which is the farthest planet from the Sun?",
                "4. What is the largest moon in the Solar System?",
                "5. Which of these is 'not' a property of metal?",
                "6. Who discovered Pasteurisation?",
                "7. Hydrochloric acid (HCl) is produced by which part of the body?",
                "8. What is the fastest animal in the world?",
                "9. What is the complementary color of Red?",
                "10. When is World Environment Day?"
        };
        List<String> questionsSet1 = Arrays.asList(questions1);
        String[][] options1 = new String[][] {
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
        List<String[]> optionsSet1 = Arrays.asList(options1);
        String[] correctAnswers1 = new String[] {
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
        List<String> correctAnswersSet1 = Arrays.asList(correctAnswers1);

        /**
         * Bộ 2: Địa lý
         */
        String[] questions2 = new String[] {
                "1. What is the capital city of Australia?",
                "2. Which is the largest country in the world by area?",
                "3. Which countries does the Nile River flow through?",
                "4. What is the highest mountain in the world?",
                "5. Which country has the largest population in the world?",
                "6. What is the largest ocean in the world?",
                "7. What is the smallest continent in the world?",
                "8. What is the highest waterfall in the world?",
                "9. Which is the largest planet in our Solar System?",
                "10. Which country has the largest number of islands in the world?"
        };
        List<String> questionsSet2 = Arrays.asList(questions2);

        String[][] options2 = new String[][] {
                {"Sydney", "Melbourne", "Canberra", "Brisbane"},
                {"Canada", "China", "USA", "Russia"},
                {"Egypt and Sudan", "Egypt, Sudan, and Ethiopia", "Egypt and Uganda", "Egypt, Sudan, Uganda, and Ethiopia"},
                {"K2", "Kilimanjaro", "Everest", "Mont Blanc"},
                {"India", "USA", "Indonesia", "China"},
                {"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"},
                {"Australia", "South America", "Africa", "Europe"},
                {"Niagara Falls", "Iguazu Falls", "Victoria Falls", "Angel Falls"},
                {"Mars", "Saturn", "Jupiter", "Venus"},
                {"Philippines", "Indonesia", "Japan", "Greece"}
        };
        List<String[]> optionsSet2 = Arrays.asList(options2);

        String[] correctAnswers2 = new String[] {
                "Canberra",
                "Russia",
                "Egypt, Sudan, Uganda, and Ethiopia",
                "Everest",
                "China",
                "Pacific Ocean",
                "Australia",
                "Angel Falls",
                "Jupiter",
                "Indonesia"
        };
        List<String> correctAnswersSet2 = Arrays.asList(correctAnswers2);

        /**
         * Bộ 3: ẩm thực, công nghệ thông tin, khoa học vật lý,
         * sinh học, địa lý, văn học, kinh tế, đến động vật học và địa danh nổi tiếng
         */
        String[] questions3 = new String[] {
                "1. What is the main ingredient in traditional Japanese miso soup?",
                "2. In computer science, what does 'CPU' stand for?",
                "3. Who is known as the father of modern physics?",
                "4. What gas do plants absorb from the atmosphere for photosynthesis?",
                "5. Which country is known as the land of the rising sun?",
                "6. Who wrote the novel '1984'?",
                "7. What is the currency of the European Union?",
                "8. What is the largest mammal in the world?",
                "9. What is the name of the longest river in Africa?",
                "10. In which city is the famous Golden Gate Bridge located?"
        };
        List<String> questionsSet3 = Arrays.asList(questions3);

        String[][] options3 = new String[][] {
                {"Rice", "Noodles", "Tofu", "Soybeans"},
                {"Central Processing Unit", "Computer Processing Unit", "Central Performance Unit", "Computer Performance Unit"},
                {"Galileo Galilei", "Albert Einstein", "Isaac Newton", "Nikola Tesla"},
                {"Carbon Dioxide", "Oxygen", "Nitrogen", "Hydrogen"},
                {"China", "Japan", "South Korea", "Thailand"},
                {"George Orwell", "Aldous Huxley", "Ray Bradbury", "H.G. Wells"},
                {"Euro", "Pound Sterling", "Dollar", "Yen"},
                {"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
                {"Nile", "Congo", "Zambezi", "Niger"},
                {"New York", "San Francisco", "Los Angeles", "Seattle"}
        };
        List<String[]> optionsSet3 = Arrays.asList(options3);

        String[] correctAnswers3 = new String[] {
                "Soybeans",
                "Central Processing Unit",
                "Albert Einstein",
                "Carbon Dioxide",
                "Japan",
                "George Orwell",
                "Euro",
                "Blue Whale",
                "Nile",
                "San Francisco"
        };
        List<String> correctAnswersSet3 = Arrays.asList(correctAnswers3);

        /**
         * Bộ 4: hóa học, địa lý, lịch sử, nghệ thuật,
         * khoa học vũ trụ, văn học, sinh học và địa danh lịch sử
         */
        String[] questions4 = new String[] {
                "1. Which element is represented by the symbol 'O' in the periodic table?",
                "2. What is the capital of France?",
                "3. In what year did World War II end?",
                "4. Which artist is famous for the painting 'The Starry Night'?",
                "5. What is the largest planet in our Solar System?",
                "6. Who is the author of 'Pride and Prejudice'?",
                "7. What is the formula for water?",
                "8. What is the name of the world's largest coral reef system?",
                "9. In which country is the ancient city of Petra located?",
                "10. What type of animal is a 'Komodo dragon'?"
        };
        List<String> questionsSet4 = Arrays.asList(questions4);

        String[][] options4 = new String[][] {
                {"Iron", "Oxygen", "Gold", "Helium"},
                {"Paris", "Berlin", "Rome", "Madrid"},
                {"1945", "1944", "1939", "1942"},
                {"Vincent Van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"},
                {"Earth", "Jupiter", "Mars", "Saturn"},
                {"Jane Austen", "Charlotte Brontë", "Louisa May Alcott", "Emily Dickinson"},
                {"H2O", "CO2", "O2", "N2"},
                {"Great Barrier Reef", "Red Sea Coral Reef", "New Caledonia Barrier Reef", "Mesoamerican Barrier Reef"},
                {"Egypt", "Jordan", "Greece", "Italy"},
                {"Bird", "Reptile", "Mammal", "Amphibian"}
        };
        List<String[]> optionsSet4 = Arrays.asList(options4);

        String[] correctAnswers4 = new String[] {
                "Oxygen",
                "Paris",
                "1945",
                "Vincent Van Gogh",
                "Jupiter",
                "Jane Austen",
                "H2O",
                "Great Barrier Reef",
                "Jordan",
                "Reptile"
        };
        List<String> correctAnswersSet4 = Arrays.asList(correctAnswers4);

        /**
         * Bộ 5: văn học, khoa học, địa lý và nghệ thuật
         */
        String[] questions5 = new String[] {
                "1. Who wrote the play 'Romeo and Juliet'?",
                "2. What is the chemical symbol for gold?",
                "3. Which planet is known as the Red Planet?",
                "4. What is the hardest natural substance on Earth?",
                "5. Which ocean lies on the east coast of the United States?",
                "6. Who is known for the theory of relativity?",
                "7. What is the smallest bone in the human body?",
                "8. What is the capital of Japan?",
                "9. Who painted the Mona Lisa?",
                "10. What is the boiling point of water at sea level?"
        };
        List<String> questionsSet5 = Arrays.asList(questions5);

        String[][] options5 = new String[][] {
                {"William Shakespeare", "Charles Dickens", "Jane Austen", "Leo Tolstoy"},
                {"Ag", "Au", "Fe", "Pt"},
                {"Venus", "Mars", "Jupiter", "Saturn"},
                {"Diamond", "Quartz", "Ruby", "Amethyst"},
                {"Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"},
                {"Isaac Newton", "Albert Einstein", "Niels Bohr", "Stephen Hawking"},
                {"Femur", "Stapes", "Humerus", "Tibia"},
                {"Kyoto", "Osaka", "Tokyo", "Nagoya"},
                {"Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello"},
                {"90°C", "100°C", "110°C", "120°C"}
        };
        List<String[]> optionsSet5 = Arrays.asList(options5);

        String[] correctAnswers5 = new String[] {
                "William Shakespeare",
                "Au",
                "Mars",
                "Diamond",
                "Atlantic Ocean",
                "Albert Einstein",
                "Stapes",
                "Tokyo",
                "Leonardo da Vinci",
                "100°C"
        };
        List<String> correctAnswersSet5 = Arrays.asList(correctAnswers5);





        // Tạo bộ câu hỏi và thêm vào danh sách bộ câu hỏi
        QuizSet quizSet1 = new QuizSet(questionsSet1, optionsSet1, correctAnswersSet1);
        quizSets.add(quizSet1);

        QuizSet quizSet2 = new QuizSet(questionsSet2, optionsSet2, correctAnswersSet2);
        quizSets.add(quizSet2);

        QuizSet quizSet3 = new QuizSet(questionsSet3, optionsSet3, correctAnswersSet3);
        quizSets.add(quizSet3);

        QuizSet quizSet4 = new QuizSet(questionsSet4, optionsSet4, correctAnswersSet4);
        quizSets.add(quizSet4);

        QuizSet quizSet5 = new QuizSet(questionsSet5, optionsSet5, correctAnswersSet5);
        quizSets.add(quizSet5);

        // Thêm các bộ câu hỏi khác bằng cách tạo các đối tượng QuizSet tương tự cho mỗi bộ câu hỏi

        QuizSet selectedQuiz = quizSets.get(selectedQuizIndex);
        showQuestion(selectedQuiz);
    }

    private void showQuestion(QuizSet quizSet) {
        List<String> questions = quizSet.getQuestions();
        List<String[]> options = quizSet.getOptions();

        if (currentQuestionIndex < questions.size()) {
            question.setText(questions.get(currentQuestionIndex));
            opt1.setText(options.get(currentQuestionIndex)[0]);
            opt2.setText(options.get(currentQuestionIndex)[1]);
            opt3.setText(options.get(currentQuestionIndex)[2]);
            opt4.setText(options.get(currentQuestionIndex)[3]);
        }
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

    private boolean checkAnswer(String selectedAnswer) {
        String correctAnswer = quizSets.get(selectedQuizIndex).getCorrectAnswers().get(currentQuestionIndex);
        return selectedAnswer.equals(correctAnswer);
    }

    @FXML
    public void opt1clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt1.getText().toString());
        handleAnswer(isCorrect);
    }

    @FXML
    public void opt2clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt2.getText().toString());
        handleAnswer(isCorrect);
    }

    @FXML
    public void opt3clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt3.getText().toString());
        handleAnswer(isCorrect);
    }

    @FXML
    public void opt4clicked(ActionEvent actionEvent) {
        boolean isCorrect = checkAnswer(opt4.getText().toString());
        handleAnswer(isCorrect);
    }

    private void handleAnswer(boolean isCorrect) {
        if (isCorrect) {
            correct = correct + 1;
            playSound("/audio/correct_sound_effect.wav"); // Chơi âm thanh khi đúng
        } else {
            wrong = wrong + 1;
            playSound("/audio/wrong_sound_effect.wav"); // Chơi âm thanh khi sai
        }

        setOptionStyles(isCorrect);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> {
                    resetOptionStyles();

                    if (currentQuestionIndex == quizSets.get(selectedQuizIndex).getQuestions().size() - 1) {
                        try {
                            resultPane = FXMLLoader.load(getClass().getResource("/view/result.fxml"));
                            setMainPane(resultPane);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        // Chuyển sang câu hỏi tiếp theo trong bộ câu hỏi hiện tại
                        currentQuestionIndex++;
                        showQuestion(quizSets.get(selectedQuizIndex));
                    }
                })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void setOptionStyles(boolean isCorrect) {
        Button selectedOptionButton = null;
        if (isCorrect) {
            selectedOptionButton = getSelectedOptionButton();
            selectedOptionButton.setStyle("-fx-background-color: green; -fx-background-radius: 90px");
        } else {
            getSelectedOptionButton().setStyle("-fx-background-color: red; -fx-background-radius: 90px");
        }
    }

    private void resetOptionStyles() {
        for (Button optionButton : Arrays.asList(opt1, opt2, opt3, opt4)) {
            optionButton.setStyle("-fx-background-color: dodgerblue; -fx-background-radius: 90px");
        }
    }

    private Button getSelectedOptionButton() {
        if (opt1.isArmed()) {
            return opt1;
        } else if (opt2.isArmed()) {
            return opt2;
        } else if (opt3.isArmed()) {
            return opt3;
        } else if (opt4.isArmed()) {
            return opt4;
        }
        return null;
    }

}