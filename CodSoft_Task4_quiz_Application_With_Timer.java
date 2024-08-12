import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class CodSoft_Task4_quiz_Application_With_Timer {
    static class Question {
        String question;
        String[] options;
        int correctAnswer;
        public Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }
    static class Quiz {
        private List<Question> questions;
        private int score;
        private int currentQuestionIndex;
        private List<Boolean> results;
        private boolean answered;
        private Timer timer;
        public Quiz() {
            questions = new ArrayList<>();
            results = new ArrayList<>();
            score = 0;
            currentQuestionIndex = 0;
            answered = false;
        }
        public void addQuestion(Question question) {
            questions.add(question);
        }
        public void start() {
            Scanner scanner = new Scanner(System.in);
            while (currentQuestionIndex < questions.size()) {
                Question currentQuestion = questions.get(currentQuestionIndex);
                displayQuestion(currentQuestion);
                answered = false;
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!answered) {
                            System.out.println("\nTime's up!");
                            results.add(false);
                            currentQuestionIndex++;
                            if (currentQuestionIndex < questions.size()) {
                                start();
                            } else {
                                showResults();
                            }
                        }
                    }
                }, 10000); 
                System.out.print("Enter your answer (1-4): ");
                int answer = scanner.nextInt();
                timer.cancel();
                answered = true;
                if (answer == currentQuestion.correctAnswer) {
                    score++;
                    results.add(true);
                } else {
                    results.add(false);
                }
                currentQuestionIndex++;
            }
            showResults();
        }
        private void displayQuestion(Question question) {
            System.out.println(question.question);
            for (int i = 0; i < question.options.length; i++) {
                System.out.println((i + 1) + ". " + question.options[i]);
            }
        }
        private void showResults() {
            System.out.println("\nQuiz Finished!");
            System.out.println("Your final score is: " + score + "/" + questions.size());
            for (int i = 0; i < questions.size(); i++) {
                String result = results.get(i) ? "Correct" : "Incorrect";
                System.out.println("Question " + (i + 1) + ": " + result);
            }
        }
    }
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the default value of a boolean variable?",
                new String[]{"true", "false", "null", "0"}, 2));
        quiz.addQuestion(new Question("Which data type is used to create a variable that should store text?",
                new String[]{"String", "int", "char", "float"}, 1));
        quiz.addQuestion(new Question("Which method must be implemented by all threads?",
                new String[]{"start()", "stop()", "run()", "main()"}, 3));
        quiz.addQuestion(new Question("Which class is the superclass of all classes in Java?",
                new String[]{"Object", "Class", "System", "Runtime"}, 1));
        quiz.addQuestion(new Question("Which keyword is used to define a constant variable?",
                new String[]{"const", "final", "static", "define"}, 2));
        quiz.addQuestion(new Question("What is the size of an int variable in Java?",
                new String[]{"4 bytes", "8 bytes", "2 bytes", "1 byte"}, 1));
        quiz.addQuestion(new Question("Which operator is used to compare two values?",
                new String[]{"=", "==", "equals", "!="}, 2));
        quiz.addQuestion(new Question("Which of these are selection statements in Java?",
                new String[]{"break", "continue", "for()", "if()"}, 4));
        quiz.addQuestion(new Question("Which package contains the Random class?",
                new String[]{"java.util", "java.lang", "java.io", "java.net"}, 1));
        quiz.addQuestion(new Question("Which method can be used to find the length of a string in Java?",
                new String[]{"getSize()", "length()", "getLength()", "size()"}, 2));
        quiz.start();
    }
}

