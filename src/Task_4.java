import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// Class representing a quiz question
class QuizQuestion {
    private final String question;
    private final List<String> options;
    private final int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

// Class representing the quiz
class Quiz {
    private final List<QuizQuestion> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        initializeQuestions();
    }

    // Add quiz questions here
    private void initializeQuestions() {
        List<String> options1 = new ArrayList<>();
        options1.add("A. Java");
        options1.add("B. Python");
        options1.add("C. C++");
        options1.add("D. JavaScript");
        questions.add(new QuizQuestion("Which programming language is known as the 'King of Programming'?", options1, 0));

        List<String> options2 = new ArrayList<>();
        options2.add("A. Red");
        options2.add("B. Green");
        options2.add("C. Blue");
        options2.add("D. Yellow");
        questions.add(new QuizQuestion("What color is a banana?", options2, 3));

        // Add more questions as needed
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : questions) {
            displayQuestion(question);
            int selectedOption = scanner.nextInt();
            if (selectedOption - 1 == question.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + question.getOptions().get(question.getCorrectOptionIndex()));
            }
        }
        scanner.close();
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        List<String> options = question.getOptions();
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Enter your choice (1-" + options.size() + "): ");
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class Task_4 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}
