package pl.tymoteuszborkowski.ui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class PuzzleText {

    private final Label label = new Label();
    private final Font font = new Font("Serif", 18);

    public PuzzleText(GridPane layout){
        label.setMouseTransparent(true);
        label.setFocusTraversable(false);
        label.setVisible(false);
        label.setFont(font);
        GridPane.setConstraints(label, 2, 4,4, 1, HPos.CENTER, VPos.CENTER);
        layout.getChildren().addAll(label);

    }

    public void fillTextField(String word){

        String replaced = word.replaceAll("[a-zA-Z]", " _ ");
        label.setText(replaced);
        label.setVisible(true);

    }






}
