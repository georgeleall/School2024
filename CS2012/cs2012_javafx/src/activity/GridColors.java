package activity;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridColors extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) {
		GridPane myGrid = new GridPane();
		myGrid.setAlignment(Pos.CENTER);
		
		myGrid.setHgap(5);
		myGrid.setVgap(5);
		
		Random ran = new Random();
		for(int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				Rectangle myRect = new Rectangle(100, 100);
				
				Color randomColor = Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
				
				myRect.setFill(randomColor);
				
				myGrid.add(myRect, col, row);
			}
		}
		
		Scene myScene = new Scene(myGrid, 350, 350);
		primaryStage.setTitle("Randomized Grid of Colors");
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

}
