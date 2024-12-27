package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.Exams.Question;
import com.example.onlineexamwithgui.Exams.Result;
import com.example.onlineexamwithgui.HelloApplication;
import com.example.onlineexamwithgui.Management.State;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExamController {
    public Label questionTitle;
    public Label marks;
    public ToggleGroup options;
    public Label examTitle;
    public Label timer;
    public Button nextButton;
    public Button previousButton;
    public RadioButton option1;
    public RadioButton option2;
    public RadioButton option3;
    public RadioButton option4;
    public Label errorExam;


    Exam exam;
    int questionIndex = 0;
    List<Integer> selectedOptions;

    int interval;

    public void initializeExam(Exam exam){
        interval = exam.getDuration() * 60;
        Timer examTimer = new Timer();

        examTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                interval--;
                int minutes = interval / 60;
                int seconds = interval % 60;
                Platform.runLater(() -> {
                    timer.setText("Timer: " +minutes + ":" + seconds);
                });

                if(interval == 0){
                    examTimer.cancel();
                    submit();
                }
            }
        }, 1000, 1000);



        examTitle.setText(exam.getTitle());
        selectedOptions = Arrays.asList(new Integer[exam.getQuestions().size()]);

        this.exam = exam;
        showQuestion(0);

    }

    public void showQuestion(int index){
        // Start Timer

        if(selectedOptions.get(index) != null){
            options.selectToggle(options.getToggles().get(selectedOptions.get(index)));
        }else{
            options.selectToggle(null);
        }
        Question question = exam.getQuestions().get(index);
        option1.setText(question.getOptions().getFirst());
        option2.setText(question.getOptions().get(1));
        option3.setText(question.getOptions().get(2));
        option4.setText(question.getOptions().getLast());
        questionTitle.setText(question.getText());
        marks.setText("Marks: "+ question.getMarks());
        if(index ==exam.getQuestions().size() - 1){
            nextButton.setText("Submit");
        }else{
            nextButton.setText("Next");
        }
        previousButton.setDisable(index == 0);
    }

    public void onNextQuestion(ActionEvent actionEvent) {
        try {
            String selectedOptionId = ((RadioButton) options.getSelectedToggle()).getId();
            int selectedOption = Integer.parseInt(selectedOptionId.substring(selectedOptionId.length() - 1)) - 1;
            selectedOptions.set(questionIndex, selectedOption);
            if (questionIndex < exam.getQuestions().size() - 1) {
                showQuestion(++questionIndex);
            } else {
                submit();
            }
        }catch (Exception e){
           errorExam.setText("Question Response Is Required!");
        }

    }
    public  void submit(){
        try {
            Result result = exam.returnResult(State.currentUser.getID() ,selectedOptions);
            State.results.add(result);
            Stage stage = (Stage) timer.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("result.fxml"));
            Parent root = loader.load();
            ((ResultController) loader.getController()).initResult(result);
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void onPreviousQuestion(ActionEvent actionEvent) {
            showQuestion(--questionIndex);
    }
}
