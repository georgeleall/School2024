package magic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainStart extends Application{

	Boolean buttonPressed = false;
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		MagicEightBall ball = new MagicEightBall();
		
		Button btn1 = new Button("Ask a question!");
		
		btn1.setText("Show Answer");
		
		EventHandler<ActionEvent> myBtnEvent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				buttonPressed =! buttonPressed;
				if(buttonPressed) {
					ball.showMessage();
					btn1.setText("Clear Answer");
				}else {
					ball.hideMessage();
					btn1.setText("Show Answer");
				}
				
			}
		};
		
		btn1.setOnAction(myBtnEvent);

		
		VBox vPane = new VBox(2);
		vPane.setAlignment(Pos.CENTER);
		vPane.getChildren().add(ball);
		vPane.getChildren().add(btn1);
		
		Scene scene = new Scene(vPane, 400, 500);
		primaryStage.setTitle("My Magic 8 Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
