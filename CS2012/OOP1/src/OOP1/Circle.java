package OOP1;

class Circle {

private double radius = 1.0;

private String color;


Circle() {
}


	Circle(double newRadius) {
		radius = newRadius;
}

	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
}

	public void setRadius(double radius) {
		this.radius = radius;
}

	public double getRadius() {
		return this.radius;
}

	public void setColor(String color) {
		this.color = color;
}

	public String getColor() {
		return this.color;
}

	public double getArea() {
		return radius * radius * 3.14159;
}


}

