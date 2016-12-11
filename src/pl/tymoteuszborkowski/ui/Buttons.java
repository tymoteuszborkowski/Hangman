package pl.tymoteuszborkowski.ui;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Buttons {

    public Button[] addKeyboardButtons(){
        final String[] keyboard = getLetters();
        final Button[] buttons = new Button[keyboard.length];

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new Button();
            buttons[i].setText(keyboard[i]);
            buttons[i].setDisable(true);
        }

        for (int i = 0x0, countRow = 0x0, countColumn = 0x39; i < buttons.length; i++) {

            GridPane.setConstraints(buttons[i], countRow, countColumn);
            countRow++;
            if(countRow == 9){
                countRow = 0;
                countColumn++;
            }
        }

        return buttons;
    }

    public Button generateWordButton(){
        final Button wordButton = new Button("Generate word");
        wordButton.setMinSize(50, 30);
        GridPane.setConstraints(wordButton, 3, 1, 3, 1, HPos.CENTER, VPos.CENTER);
        return wordButton;
    }

    public Button addGuessButton(){
        final Button button = new Button("Guess");
        button.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setConstraints(button, 4, 11, 3, 2, HPos.CENTER, VPos.CENTER);


        return button;
    }


    private static String[] getLetters(){
        String[] keyboard = new String[26];

        for(int i = 0x41; i <= 0x5A; i++){
            keyboard[i-0x41] = "" + (char) i;
        }

        return keyboard;
    }

}
