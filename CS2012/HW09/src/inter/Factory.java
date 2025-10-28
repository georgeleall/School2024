package inter;

public class Factory {

	public static void main(String[] args) {
		
		Car myCar = new Car("Ford Mustang","Black", 22344);
		myCar.speed();
		myCar.paint();
		
		System.out.println();
		
		Truck myTruck = new Truck("Ford Ranger", "Silver", 35000);
		myTruck.speed();
		myTruck.paint();
	}

}
