package main;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnakeMain extends Application{
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 500;
	private static final int RADIUS = 5;	
	private Pane root;	
	private Circle food;	
	private Text score;
	private Random ran = new Random();	
	private Snake snake;
	
	private void createFood() {
		this.food = new Circle(ran.nextInt(GAME_WIDTH), ran.nextInt(GAME_HEIGHT), RADIUS);
		this.food.setFill(Color.RED);
		this.root.getChildren().add(this.food);
	}
	
	private void createSnake() {
		this.snake = new Snake(GAME_WIDTH / 2, GAME_HEIGHT / 2, RADIUS + 2);
		this.root.getChildren().add(this.snake);
	}
	
	public boolean hit() {
		return this.food.intersects(this.snake.getBoundsInLocal());
	}
	
	public boolean gameOver() {
		return this.snake.hitSelf();
	}
	
	private void move() {
		Platform.runLater(() -> {
			this.snake.step();
			this.adjustLocation();
			if(hit()) {
				this.snake.eat(this.food);
				this.score.setText("" + this.snake.getLength());
				this.createFood();
			} else if(this.gameOver()) {
				this.root.getChildren().clear();
				this.root.getChildren().add(this.score);
				
				this.score.setText("" + this.snake.getLength());
				this.createFood();
				this.createSnake();
			}
		});
	}
	
	private void adjustLocation() {
		if(this.snake.getCenterX() < 0) {
			this.snake.setCenterX(GAME_WIDTH);
		} else if(this.snake.getCenterX() > GAME_WIDTH) {
			this.snake.setCenterX(0);
		}
		
		if(this.snake.getCenterY() < 0) {
			this.snake.setCenterY(GAME_HEIGHT);
		} else if (this.snake.getCenterY() > GAME_HEIGHT) {
			this.snake.setCenterY(0);
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.root = new Pane();
		this.root.setPrefSize(GAME_WIDTH, GAME_HEIGHT);
		
		this.score = new Text (0,32,"0");
		this.root.getChildren().add(this.score);
		this.createFood();
		this.createSnake();
		
		Runnable r = () -> {
			try {
				for(;;) {
					this.move();
					Thread.sleep(100/ (1 + this.snake.getLength() / 10));
				}
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Scene scene = new Scene(this.root);
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
			KeyCode code = event.getCode();
			
			if(code == KeyCode.UP) {
				this.snake.setDirection(Direction.UP);
			}else if(code == KeyCode.DOWN) {
				this.snake.setDirection(Direction.DOWN);	
			}else if(code == KeyCode.LEFT) {
				this.snake.setDirection(Direction.LEFT);
			}else if(code == KeyCode.RIGHT) {
				this.snake.setDirection(Direction.RIGHT);
			}
		});
		
		primaryStage.setTitle("Snake Game");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Thread th = new Thread(r);
		th.setDaemon(true);
		th.start();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
