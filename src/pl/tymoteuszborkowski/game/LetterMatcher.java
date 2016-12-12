package pl.tymoteuszborkowski.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.tymoteuszborkowski.ui.AnswerPopup;
import pl.tymoteuszborkowski.ui.AnswersCounter;
import pl.tymoteuszborkowski.ui.PuzzleText;

import java.util.ArrayList;
import java.util.List;

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
                List<Integer> indexes = match(letter);
                if(!indexes.isEmpty()){
                    puzzleText.addProperLetter(letter.toCharArray()[0], indexes);
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


    private List<Integer> match(String letterStr){
        List<Integer> indexes = new ArrayList<>();

        char letter = letterStr.toCharArray()[0];

        char[] wordChars = word.toCharArray();

        for(int i = 0; i < word.length(); i++){
            if(wordChars[i] == letter){
                indexes.add(i);
            }
        }
        return indexes;
    }



}
