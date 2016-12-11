package pl.tymoteuszborkowski.ui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class AnswersCounter {

    private final Label pointsLabel = new Label();
    private final Label badAnswersLbl = new Label();
    private final Label howManyTries = new Label();

    public AnswersCounter(GridPane layout){
        GridPane.setConstraints(pointsLabel,0 ,10,5,2, HPos.LEFT, VPos.BASELINE);
        GridPane.setConstraints(badAnswersLbl,0 ,11,5,2, HPos.LEFT, VPos.BASELINE);
        GridPane.setConstraints(howManyTries,0 ,12, 5,2, HPos.LEFT, VPos.BASELINE);
        layout.getChildren().addAll(pointsLabel, badAnswersLbl, howManyTries);
    }


    public void setBadAnswersLbl(int badAnswers, String word){
        badAnswersLbl.setText("Bad answers: " + badAnswers);
        howManyTries.setText("You have: " + (Math.abs((((word.length()/2))-badAnswers)+1)) + " tries.");
    }
    public void setGoodAnswers(int goodAnswers){
        pointsLabel.setText("Points: " + goodAnswers);

    }

    public void resetLabel(){
        howManyTries.setText("");
        badAnswersLbl.setText("");
    }
}
