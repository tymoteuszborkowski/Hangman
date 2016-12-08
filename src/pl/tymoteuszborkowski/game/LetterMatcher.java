package pl.tymoteuszborkowski.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LetterMatcher {

    private final Button[] keyboardBtns;
    private final String word;
    private String actualLetter;

    private int counter = 0;

    public LetterMatcher(Button[] keyboardBtns, String word){
        this.keyboardBtns = keyboardBtns;
        this.word = word;

    }

    public boolean waitForClick(){
        for (Button keyboardBtn : keyboardBtns) {
            keyboardBtn.setOnAction(event -> {
                String letter = keyboardBtn.getText().toLowerCase();
            });
        }

        return true;
    }


    private boolean match(String letter){
        System.out.println(letter);
        return word.contains(letter);
    }


}
