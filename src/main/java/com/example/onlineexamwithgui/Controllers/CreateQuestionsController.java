package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Exams.Category;
import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.Exams.Question;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateQuestionsController {


    public Label questionNumber;
    public TextField titleText;
    public TextField option1Field;
    public TextField option2Field;
    public TextField option3Field;
    public TextField option4Field;
    public TextField marks;
    public ToggleGroup options;
    public Button next;
    public Button previous;
    public Label errorCreateQuestion;
    int index = 0;
    int state;

    List<Question> questions;

    private String title;
    private String category;
    private int duration;
    private Exam exam;

    public void initExamsQuestions(String title, String category, int duration, int length){

        state = 0;

        questions = Arrays.asList(new Question[length]);

        showQuestion(0);
        this.title = title;
        this.category = category;
        this.duration = duration;

    }

    public void initAddQuestion(Exam exam){
        state = 1;
        this.exam = exam;
        previous.setText("Back");
        next.setText("Save");
    }

    public void initEditExamQuestions(Exam exam){
        state = 2;
        this.questions = exam.getQuestions();
        this.exam = exam;
        showQuestion(0);
    }


    public void showQuestion(int index){
        questionNumber.setText("Enter Question Number #"+ (index+1));
        Question question = questions.get(index);
        if(question != null) {
            titleText.setText(question.getText());
            option1Field.setText(question.getOptions().get(0));
            option2Field.setText(question.getOptions().get(1));
            option3Field.setText(question.getOptions().get(2));
            option4Field.setText(question.getOptions().get(3));
            marks.setText(String.valueOf(question.getMarks()));
            options.selectToggle(options.getToggles().get(question.getCorrectAnswer()));
        }
        else{
            titleText.clear();
            option1Field.clear();
            option2Field.clear();
            option3Field.clear();
            option4Field.clear();
            marks.clear();
            options.selectToggle(null);
        }
        if(index == questions.size() - 1){
            next.setText("Save");
        }else{
            next.setText("Next");
        }
        previous.setDisable(index == 0);
       }
    public void onCreateExam(ActionEvent actionEvent) {

        if(state != 1) {
            try {
                Question question = getQuestion();
                questions.set(index, question);

            }catch (Exception _){}
            showQuestion(--index);
        }else{
            SceneController.changeScene(actionEvent, "AdminOptions.fxml");
        }
    }

    public void onNextQuestion(ActionEvent actionEvent) {
        try {
            Question question = getQuestion();
            if (options.getSelectedToggle() != null) {
                if (state != 1) {
                    questions.set(index, question);
                    if (index == questions.size() - 1) {
                        // Done
                        SceneController.changeScene(actionEvent, "AdminOptions.fxml");

                        int totalMarks = 0;
                        for (Question question1 : questions) {
                            totalMarks += question1.getMarks();
                        }
                        if (state == 0) {
                            Exam exam = new Exam(title, new Category(category), duration, totalMarks, questions);
                            State.exams.add(exam);
                        } else {
                            exam.setTotalMarks(totalMarks);
                            exam.setQuestions(questions);
                        }
                    } else {
                        showQuestion(++index);
                    }
                } else {
                    exam.addQuestion(question);
                    int totalMarks = 0;
                    for (Question question1 : exam.getQuestions()) {
                        totalMarks += question1.getMarks();
                    }
                    exam.setTotalMarks(totalMarks);
                    SceneController.changeScene(actionEvent, "AdminOptions.fxml");
                }
            } else {
                errorCreateQuestion.setText("Please Choose the Correct Answer!");
            }
        }catch (Exception e){
            errorCreateQuestion.setText("Please Enter Full Information!");
        }
    }

    private Question getQuestion() {
        String correctAnswerID = ((RadioButton) options.getSelectedToggle()).getId();
        int correctAnswerIndex = Integer.parseInt(correctAnswerID.substring(correctAnswerID.length() - 1)) - 1;

        ArrayList<String> optionsTexts = new ArrayList<>();
        optionsTexts.add(option1Field.getText());
        optionsTexts.add(option2Field.getText());
        optionsTexts.add(option3Field.getText());
        optionsTexts.add(option4Field.getText());

        Question question = new Question(titleText.getText(), optionsTexts, correctAnswerIndex, Integer.parseInt(marks.getText()));
        return question;
    }
}
