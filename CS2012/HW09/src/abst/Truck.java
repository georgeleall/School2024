package abst;

import java.util.Random;

public class Truck extends Vehicle{
	
	String name;
	String color;
	double weight;
	int carspeed;
	int miles;
	

	public Truck(String name, String color, double weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	
	@Override
	void speed() {
		Random spd = new Random();
        Random weightd = new Random();
        
        weight = 1000 + weightd.nextInt(4001);
        double randomCspeed = 100 + spd.nextInt(501); 
        
        carspeed = (int) Math.max(randomCspeed, randomCspeed/weight);
        
    	System.out.println("Car Name: " + name + " " + "Car Speed: " + carspeed);
		
	}
	
	
	@Override
	void paint() {
		String[] paint = {"Red", "Black", "Blue", "Grey", "Silver"};
		Random CPaint = new Random();
		int randCidx = CPaint.nextInt(paint.length);
		String color2 = paint[randCidx];

		
		System.out.println("Car Name: " + name + " " + "Current Color: "+ color + " "+ "New Color: " + color2);
		
	}
	

public void drive() {
	Random randmiles = new Random();
	
	miles = 100 + randmiles.nextInt(1001);
	
	System.out.println("Truck Name: " + name + " " +"Miles Driven: " + miles);
}

	
	public Truck(double weight) {
		this.weight = weight;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCarspeed() {
		return carspeed;
	}

	public void setCarspeed(int carspeed) {
		this.carspeed = carspeed;
	}	
	
	@Override
	public String toString() {
	    return "Truck Name: " + name + ", Color: " + color + ", Speed: " + carspeed + " MPH"+ ", Weight: " + weight 
	    		+ " Miles Driven: " + miles;
	}

}