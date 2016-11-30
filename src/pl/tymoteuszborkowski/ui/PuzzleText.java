package pl.tymoteuszborkowski.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PuzzleText {

    private final TextField textField = new TextField();


    public PuzzleText(GridPane layout){
        textField.setVisible(false);
        GridPane.setConstraints(textField, 2, 0);
        layout.getChildren().addAll(textField);

    }

    public void fillTextField(String word){

        textField.setText(word);
        textField.setVisible(true);

    }






}
