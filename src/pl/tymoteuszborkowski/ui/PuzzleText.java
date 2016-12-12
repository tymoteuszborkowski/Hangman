package pl.tymoteuszborkowski.ui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.List;

public class PuzzleText {

    private final Label label = new Label();
    private final Font font = new Font("Serif", 18);

    public PuzzleText(GridPane layout){
        label.setMouseTransparent(true);
        label.setFocusTraversable(false);
        label.setVisible(false);
        label.setFont(font);
        GridPane.setConstraints(label, 2, 4,6, 1, HPos.CENTER, VPos.CENTER);
        layout.getChildren().addAll(label);

    }

    public void fillTextField(String word){

        System.out.println(word);
        String replaced = word.replaceAll("[a-zA-Z]", "_ ");
        label.setText(replaced);
        label.setVisible(true);

    }


    public void addProperLetter(char newChar, List<Integer> indexes){
        String text = label.getText();
        final StringBuilder replaced = new StringBuilder(text);
        for(int index : indexes){
            replaced.setCharAt(index*2, newChar);
        }
        label.setText(replaced.toString());
    }



}
