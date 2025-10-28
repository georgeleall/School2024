package magic;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MagicEightBall extends StackPane {

	WiseSayings ws;
	Circle blackCircle;
	Circle blueCircle;
	Text message;
	
	Label lab = new Label("Circle", new Circle(50, 50, 25));
	
	public MagicEightBall() {
		
		ws = new WiseSayings();
		
		Circle blackCircle = new Circle(100, 100, 150);
		blackCircle.setFill(Color.BLACK);
		this.getChildren().add(blackCircle);
		
		Circle blueCircle = new Circle(100, 100, 50);
		blueCircle.setFill(Color.BLUE);
		this.getChildren().add(blueCircle);
		
		message = new Text("ask a\n" + "question");
		message.setFont(Font.font(20));
		message.setFill(Color.WHITE);
		message.setText("8 Ball");
		this.getChildren().add(message);
		
	}
	
	public void showMessage() {
		message.setFill(Color.WHITE);
		message.setText(ws.getRandomSaying());
		
	}
	
	public void hideMessage() {
		message.setFill(Color.TRANSPARENT);
		
		
	}
	
}
