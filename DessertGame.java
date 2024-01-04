import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

	private int score = 0;
	
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        
        // TODO: Step 7-10
        Button dessert = new Button("Dessert");
        Button d1 = new Button("Desert");
        Button d2 = new Button("Desert");
        Button d3 = new Button("Desert");
        Button d4 = new Button("Desert");
        Button d5 = new Button("Desert");
        Button d6 = new Button("Desert");
        Button d7 = new Button("Desert");
        Button[] buttons = new Button[8];
        buttons[0] = dessert;
        buttons[1] = d1;
        buttons[2] = d2;
        buttons[3] = d3;
        buttons[4] = d4;
        buttons[5] = d5;
        buttons[6] = d6;
        buttons[7] = d7;
        
        Random rand = new Random();
        randomizeButtonPositions(rand, buttons);
        exitButton.requestFocus();
        
        for (Button b : buttons) {
        	b.setOnAction(event -> {
        		randomizeButtonPositions(rand, buttons);
        		if(b.equals(dessert)) {
        			score++;
        		} else { 
        			score--;
        		}
        		scoreLabel.setText("Score: " + score);
        		exitButton.requestFocus();
        			});
        	pane.getChildren().add(b);
        }
        
        stage.setScene(scene);
        stage.show();
    }

    private static void randomizeButtonPositions(Random rand, Button[] buttons) {
    	for (Button b : buttons) {
    		b.setLayoutX(rand.nextDouble() * 600);
    		b.setLayoutY(rand.nextDouble() * 400);
    	}
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}