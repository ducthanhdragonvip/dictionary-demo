package controller;
import java.util.List;

public class QuizSet {
    private List<String> questions;
    private List<String[]> options;
    private List<String> correctAnswers;

    public QuizSet(List<String> questions, List<String[]> options, List<String> correctAnswers) {
        this.questions = questions;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String[]> getOptions() {
        return options;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
