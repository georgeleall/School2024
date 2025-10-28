package inter;

import java.util.Random;

public class Car implements Vehicle {

	private String name;
	private String color;
	private int weight;
	private int speed;
	
	
	public Car(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public void speed() {
		Random spd = new Random();
		double randomCspeed = 100 + spd.nextInt(501); 
        int speed = (int) Math.max(randomCspeed, randomCspeed/weight);
        
        System.out.println("Name: " + name + " Speed: " + speed + " MPH");
	}
	
	
	@Override
	public void paint() {
		String[] paint = {"Red", "Black", "Blue", "Grey", "Silver"};
		Random CPaint = new Random();
		int randCidx = CPaint.nextInt(paint.length);
		String color2 = paint[randCidx];
		
		System.out.println("Name: " + name + " Color: " + color + " New Color: " + color2);

	}
	
	@Override
	public String toString() {
	    return "Car Name: " + name + ", Color: " + color + ", Speed: " + speed + " MPH"+ ", Weight: " + weight;
	}	
	
}
