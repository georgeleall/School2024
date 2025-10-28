package abst;

public class Factory {

	public static void main(String[] args) {
		
		Car myCar = new Car("Ford Mustang", "Black", 22500);
		myCar.speed();
		myCar.paint();
		
		System.out.println();
		
		Truck myTruck = new Truck("Ford Ranger", "Silver", 400000);
		myTruck.speed();
		myTruck.paint();
		myTruck.drive();

	}

}
