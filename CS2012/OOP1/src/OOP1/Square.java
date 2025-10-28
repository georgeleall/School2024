package OOP1;

public class Square {

	private double side;
	
	private String color;
	
	public Square(double side, String color) {
		this.side = side;
		this.color = color;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return this.side;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getArea() {
		return this.side * this.side;
	}
}
