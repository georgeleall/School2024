package activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DeckOfCards extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Random ran = new Random();
		
		List<Image> imgs = new ArrayList<>();
		List<ImageView> imgV = new ArrayList<>();
		
		for(int i = 0; i < 7; i++) {
			imgs.add(new Image(new File("/Users/george/Documents/CS2012/cs2012_creativity/images/cards/" + ran.nextInt(53) + 
					".png").toURI().toString()));
			
			imgV.add(new ImageView(imgs.get(i)));
		}
		
		fixRatio(imgV);
		
		FlowPane fp = new FlowPane();
		fp.setPadding(new Insets(8));
		fp.setHgap(5);
		fp.setVgap(5);
		
		for(ImageView ig: imgV) {
			fp.getChildren().add(ig);
		}
		
		Scene myScene = new Scene(fp, 800, 800);
		
		primaryStage.setScene(myScene);
		primaryStage.setTitle("Random 7 Cards");
		primaryStage.show();
	}
	
	public void fixRatio(List<ImageView> imgV) {
		for(ImageView ig: imgV) {
			ig.setFitWidth(170);		
			ig.setFitHeight(270);
			ig.setPreserveRatio(false);

		}
	}

}
