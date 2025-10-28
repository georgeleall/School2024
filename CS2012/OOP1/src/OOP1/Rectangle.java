package OOP1;

public class Rectangle {

	private double width;
	
	private double height;
	
	private String color;



	public Rectangle(double width, double height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
}