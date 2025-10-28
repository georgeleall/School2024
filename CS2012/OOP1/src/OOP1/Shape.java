package OOP1;

public class Shape {

	public static void main(String[] args) {
		Circle circle1 = new Circle(5.0, "Brown");
		Circle circle2 = new Circle(7.5, "Purple");
		
		System.out.println(circle1.getRadius());
		System.out.println(circle1.getColor());
		System.out.println(circle1.getArea());
		
		System.out.println(circle2.getRadius());
		System.out.println(circle2.getColor());
		System.out.println(circle2.getArea());
		
		
		Square square1= new Square(2.2,"Red");
		Square square2= new Square(4.5,"Green");
		
		System.out.println(square1.getSide());
		System.out.println(square1.getColor());
		System.out.println(square1.getArea());
		
		System.out.println(square2.getSide());
		System.out.println(square2.getColor());
		System.out.println(square2.getArea());
	
		
		Rectangle rect1 = new Rectangle(2.0,3.0, "Pink");
		Rectangle rect2 = new Rectangle(4.0,7.0, "Beige");
		
		System.out.println(rect1.getHeight());
		System.out.println(rect1.getWidth());
		System.out.println(rect1.getColor());
		System.out.println(rect1.getArea());
		
		System.out.println(rect2.getHeight());
		System.out.println(rect2.getWidth());
		System.out.println(rect2.getColor());
		System.out.println(rect2.getArea());
	}

}
