package pl.tymoteuszborkowski;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.tymoteuszborkowski.game.WordGenerator;
import pl.tymoteuszborkowski.ui.Buttons;

public class Initializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final GridPane layout = new GridPane();
        final Buttons buttons = new Buttons();

        final Button generateWordButton = buttons.generateWordButton();
        final Button[] keyboardButtons = buttons.addKeyboardButtons();

        Thread thread = new Thread(new WordGenerator());
        thread.start();


        layout.getChildren().addAll(keyboardButtons);
        layout.getChildren().addAll(generateWordButton);
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);

    Scene mainScene = new Scene(layout, 450, 750);
        layout.setAlignment(Pos.BASELINE_CENTER);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hangman");
        primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
