class flowerBouquet {
public String flowerName;
public String flowerColor;
// same way define flowerColor
public flowerBouquet(String flowerName, String flowerColor) {
	// assign values to constructor so that you can use in whole program
	this.flowerName = flowerName;
	this.flowerColor = flowerColor;
}
public String whichFlower() {
	// print flowername and flowercolor with given string
	return "The flower name is " +flowerName+" and the flower color is " +flowerColor;
}
public String sameFlower(flowerBouquet compare) {
// check in if condition if both flower has same color and name
	if(this.flowerName.equals(compare.flowerName) && this.flowerColor.equals(compare.flowerColor)){
	// print statement for match
	return "The flowers are the same.";
}
else {
	// print statement if not same
	return "The flowers are not the same.";
}
}
public static void main(String[] args) {
flowerBouquet f1 = new flowerBouquet("Rose", "red");
flowerBouquet f2 = new flowerBouquet("Sunflower", "yellow");
flowerBouquet f3 = new flowerBouquet("Rose", "pink");
flowerBouquet f4 = new flowerBouquet("Sunflower", "yellow");
flowerBouquet f5 = new flowerBouquet("Lily", "white");
// define 1 more object
	// print all methods output
System.out.println(f1.whichFlower());
System.out.println(f2.whichFlower());
System.out.println(f3.whichFlower());
System.out.println(f4.whichFlower());
System.out.println(f5.whichFlower());
System.out.println(f1.sameFlower(f2));
System.out.println(f1.sameFlower(f3));
System.out.println(f2.sameFlower(f4));
System.out.println(f1.sameFlower(f5));
}
}
