package pl.tymoteuszborkowski.ui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AnswerText {

    private final GridPane layout;

    public AnswerText(GridPane layout){
        this.layout = layout;
    }

    public  TextField addAnswerText(){
        final TextField answerText = new TextField();
        answerText.editableProperty().setValue(true);
        GridPane.setConstraints(answerText, 2, 6, 6,6, HPos.CENTER, VPos.CENTER);

        layout.getChildren().add(answerText);

        return answerText;
    }


}
