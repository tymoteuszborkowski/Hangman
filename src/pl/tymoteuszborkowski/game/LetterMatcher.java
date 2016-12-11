package pl.tymoteuszborkowski.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.tymoteuszborkowski.ui.AnswerPopup;
import pl.tymoteuszborkowski.ui.AnswersCounter;
import pl.tymoteuszborkowski.ui.PuzzleText;

public class LetterMatcher {


    private final AnswersCounter answersCounter;
    private final PuzzleText puzzleText;
    private final Button[] keyboardBtns;
    private final GridPane layout;
    private final String word;
    private int match;

    private int badAnswer = 0;

    public LetterMatcher(Button[] keyboardBtns, String word, PuzzleText puzzleText, GridPane layout){
        answersCounter = new AnswersCounter(layout);
        this.keyboardBtns = keyboardBtns;
        this.word = word;
        this.puzzleText = puzzleText;
        this.layout = layout;


        for (Button button : keyboardBtns) {
            button.setDisable(false);
        }

    }

    public void waitForClick(){
        for (Button keyboardBtn : keyboardBtns) {
            keyboardBtn.setOnAction(event -> {
                String letter = keyboardBtn.getText().toLowerCase();
                 match = match(letter);
                if(match != -1){
                    puzzleText.addProperLetter(letter.toCharArray()[0], match);
                }else {
                    badAnswer++;
                    answersCounter.setBadAnswersLbl(badAnswer, word);
                }


                if(badAnswer > word.length()/2){
                    new AnswerPopup("You have to guess now!");
                    for (Button keyboardButton : keyboardBtns) {
                        keyboardButton.setDisable(true);
                    }
                    answersCounter.resetLabel();
                }
            });



        }


    }


    private int match(String letter){
        return word.indexOf(letter.toCharArray()[0]);
    }



}
