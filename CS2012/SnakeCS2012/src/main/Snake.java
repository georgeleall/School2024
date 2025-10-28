package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.List;
import java.util.ArrayList;

public class Snake extends Circle{
	//centerXProperty() --> defines the horizontal POS of the center of the circle
	//centerYProperty() --> defines the vertical POS of the center of the circle
	
	private List <Circle> tails;
	private int length = 0;
	private Direction currentDirection;
	private static final int STEP = 8;

	
	public Snake (double centerX, double centerY, double radius) {
		super(centerX,  centerY, radius);
		this.tails = new ArrayList<>();
		this.currentDirection = Direction.UP;
	}
	
	public Direction getDirection() {
		return this.getDirection();
	}
	
	public void setDirection(Direction dir) {
		this.currentDirection = dir;
	}
	
	public int getLength() {
		return this.tails.size();
	}
	
	//This method will represent the movement of the snake
	public void step() {
		for(int i = this.length - 1; i >= 0; i--) {
			if (i == 0) {
				this.tails.get(i).setCenterX(getCenterX());
				this.tails.get(i).setCenterY(getCenterY());
			} else {
				this.tails.get(i).setCenterX(this.tails.get(i - 1).getCenterX());
				this.tails.get(i).setCenterY(this.tails.get(i - 1).getCenterY());
			}
		}
		
		if(this.currentDirection == Direction.UP) {
			this.setCenterY(getCenterY() - STEP);
		}else if(this.currentDirection == Direction.DOWN) {
			this.setCenterY(getCenterY() + STEP);
		}else if(this.currentDirection == Direction.LEFT) {
			this.setCenterX(getCenterX() - STEP);
		}else {
			this.setCenterX(getCenterX() + STEP);
		}
		
	}
	
	private Circle lastTail() {
		if (this.length == 0) {
			return this;
		} else {
			return this.tails.get(this.length - 1);
		}
	}
	
	public void eat(Circle food) {
		Circle tail = this.lastTail();
		food.setCenterX(tail.getCenterX());
		food.setCenterY(tail.getCenterY());
		food.setFill(Color.BLACK);
		this.tails.add(this.length++, food);
	}
	
	public boolean hitSelf() {
		for (int i = 0; i < this.length; i++) {
			if(this.getCenterX() == this.tails.get(i).getCenterX() && 
					this.getCenterY() == this.tails.get(i).getCenterY()) {
				return true;
			}
		}
		return false;
	}
}
