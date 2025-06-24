import java.util.*;

public class Generics<T>{
String type;
T value;

	public Generics (String type, T value){
	//store this value in this variable
	this.type = type;
	this.value = value;
	
	}

	public void print(){
	//print name and type from constructor
	System.out.println("Entry: "+ "Type: " + type + ", Value: " + value);
	}

	public static void main(String[] args) {
	List<Generics<?>> list = new ArrayList<>();
	//now add diff entry in the list
	// ex: integer, 1 double, 1.0, string, boolean, char
	list.add(new Generics<>("Integer", 2));
	//add 4 more entries
	list.add(new Generics<>("String", "Hi"));
	list.add(new Generics<>("Double", 10.01));
	list.add(new Generics<>("Double",3.14));
	list.add(new Generics<>("Float",87.777));

		for (Generics<?> en : list) {
		//print all entry with print function
		en.print();
		}
	}
}
