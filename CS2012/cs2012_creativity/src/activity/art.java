package activity;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class art extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Random ran = new Random();

        Circle circle = new Circle();
        circle.setRadius(100.0f); 

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(5650);

        Rectangle rect2 = new Rectangle();
        rect2.setHeight(300);
        rect2.setWidth(400);
        rect2.setRotate(0);
        
        Rectangle rect3 = new Rectangle();
        rect3.setHeight(200);
        rect3.setWidth(60);
        rect3.setRotate(0);
        rect3.setFill(Color.BROWN);
        
        Rectangle rect4 = new Rectangle();
        rect4.setHeight(390);
        rect4.setWidth(100);
        rect4.setRotate(0);
        rect4.setFill(Color.BURLYWOOD);
        
        Ellipse eli2 = new Ellipse();
        eli2.setRadiusX(75);
        eli2.setRadiusY(25);
        eli2.setFill(Color.GREEN);
        
        Ellipse eli3 = new Ellipse();
        eli3.setRadiusX(85);
        eli3.setRadiusY(35);
        eli3.setFill(Color.GREEN);
        eli3.setRotate(45);
        
        Ellipse eli4 = new Ellipse();
        eli4.setRadiusX(80);
        eli4.setRadiusY(35);
        eli4.setFill(Color.GREEN);
        eli4.setRotate(90);
        
        Ellipse eli5 = new Ellipse();
        eli5.setRadiusX(80);
        eli5.setRadiusY(35);
        eli5.setFill(Color.GREEN);
        eli5.setRotate(220);
        
        Ellipse eli = new Ellipse();
        eli.setRadiusX(100);
        eli.setRadiusY(50);
        eli.setFill(Color.WHITESMOKE);
        
        
        Text text = new Text();
        text.setFont(new Font(45));
        text.setText("George Leal"); 
        text.setFill(Color.BLACK);

        Color randomColor = Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
        Color randomColor1 = Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
        Color randomColor2 = Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));

        circle.setFill(Color.YELLOW);
        rectangle.setFill(randomColor1);
        rect2.setFill(randomColor2);
        


        StackPane portrait = new StackPane();
        portrait.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));
        
        
        StackPane.setAlignment(rect2, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(eli2, Pos.CENTER_LEFT);
        StackPane.setAlignment(eli3, Pos.CENTER_LEFT);
        StackPane.setAlignment(eli4, Pos.CENTER_LEFT);
        StackPane.setAlignment(eli5, Pos.CENTER_LEFT);
        StackPane.setAlignment(rect4, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(rectangle, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(rect3, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(circle, Pos.TOP_LEFT);
        StackPane.setAlignment(eli, Pos.CENTER);
        StackPane.setAlignment(text, Pos.BOTTOM_RIGHT);
        
        portrait.getChildren().addAll(rect2, rect4, eli, circle, rect3, rectangle, eli2, eli3, eli4, eli5, text);
        

        Scene myScene = new Scene(portrait, 800, 800);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Portrait");
        primaryStage.show();
    }
}
