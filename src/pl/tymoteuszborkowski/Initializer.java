package pl.tymoteuszborkowski;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.tymoteuszborkowski.game.LetterMatcher;
import pl.tymoteuszborkowski.game.WordGenerator;
import pl.tymoteuszborkowski.ui.*;

public class Initializer extends Application {

    private LetterMatcher letterMatcher;
    private static int globalPoints = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final GridPane layout = new GridPane();
        final AnswersCounter answersCounter = new AnswersCounter(layout);
        final Buttons buttons = new Buttons();
        final PuzzleText puzzleText = new PuzzleText(layout);
        final AnswerText answerText = new AnswerText(layout);

        final Button guessButton = buttons.addGuessButton();
        final TextField answerTextField = answerText.addAnswerText();

        final Button generateWordButton = buttons.generateWordButton();
        final Button[] keyboardButtons = buttons.addKeyboardButtons();

        final WordGenerator wordGenerator = new WordGenerator();


        generateWordButton.setOnAction(event -> {

            answersCounter.resetLabel();
            final String word = wordGenerator.generateWord();
            puzzleText.fillTextField(word);
            letterMatcher = new LetterMatcher(keyboardButtons, word, puzzleText, layout);
            letterMatcher.waitForClick();



            guessButton.setOnAction(guessEvent -> {
                final String userAnswer = answerTextField.getText();

                if(userAnswer.equals(word)){
                    globalPoints++;
                    new AnswerPopup("Good Answer! Earned points: " + globalPoints);
                    answersCounter.setGoodAnswers(globalPoints);
                }else {
                    globalPoints = 0;
                    new AnswerPopup("Bad Answer! You lost your points :( ");
                }

            });

        });



        layout.getChildren().addAll(keyboardButtons);
        layout.getChildren().addAll(generateWordButton, guessButton);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

    final Scene mainScene = new Scene(layout, 450, 750);
        layout.setAlignment(Pos.BASELINE_CENTER);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hangman");
        primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
