package activity;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TwoButtonVBox extends Application {
	
	public static void main(String []args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Label l1 = new Label("Text at the top of the VBox Stack");
		Label l2 = new Label("Text at the bottom of the VBox Stack");
		
		Button b1 = new Button ("This is Button 1");
		Button b2 = new Button ("This is Button 2");
		
		HBox buttonHolder = new HBox(b1, b2);
		buttonHolder.setAlignment(Pos.CENTER);
		//buttonHolder.setBackground(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY));
		
		
		VBox mainBox = new VBox();
		mainBox.setAlignment(Pos.CENTER);
		
		mainBox.getChildren().add(l1);
		mainBox.getChildren().add(l2);
		mainBox.getChildren().add(buttonHolder);
		
		
		b1.setOnAction((event) ->{
			l1.setText("BUTTON 1 PUSHED");
			l2.setText("Text at the bottom of the VBox Stack");
		});
		
		b2.setOnAction((event) ->{
			l2.setText("BUTTON 2 PUSHED");
			l1.setText("Text at the top of the VBox Stack");
		});
		
		Scene myScene = new Scene(mainBox, 400, 400);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	
}
