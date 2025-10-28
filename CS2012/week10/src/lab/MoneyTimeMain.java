package lab;
import java.util.ArrayList;
import java.util.Collections;


public class MoneyTimeMain {

	public static void main(String[] args) {
		
		Money m1 = new Money (1,30);
		Money m2 = new Money (2,50);
		Money m3 = m1.add (m2);
		Money m4 = new Money (m1);
		Money m5 = new Money (m2.getDollars(),m2.getCents());
		Money m6 = m3.subtract(m4);
		Money m7 = new Money (17,50);
		Money m8 = new Money (32,33);
		Money m9 = m8.subtract(m7);
		Money m10 = new Money (m8.getDollars(), m8.getCents());
		
		ArrayList<Money> moneyList = new ArrayList<>();
		moneyList.add(m1);
		moneyList.add(m2);
		moneyList.add(m3);
		moneyList.add(m4);
		moneyList.add(m5);
		moneyList.add(m6);
		moneyList.add(m7);
		moneyList.add(m8);
		moneyList.add(m9);
		moneyList.add(m10);
		
		System.out.println("MONEY LIST:");
		System.out.println();
		
		Collections.shuffle(moneyList);
		System.out.println("BEFORE SORTING");
		for(Money m: moneyList) {
			System.out.println(m.toString());
		}
		
		System.out.println();
		Collections.sort(moneyList);
		System.out.println("AFTER SORTING");
		for(Money m: moneyList) {
			System.out.println(m.toString());
		}
		System.out.println();

		ArrayList<Time> timeList = new ArrayList<>();
		timeList.add(new Time(3, 45, 20));
		timeList.add(new Time(15, 30, 43));
		timeList.add(timeList.get(0).add(timeList.get(1)));
		timeList.add(timeList.get(0).subtract(timeList.get(1)));
		timeList.add(new Time(timeList.get(1)));
		timeList.add(new Time (23, 12, 02));
		timeList.add(new Time(15, 07, 22));
		timeList.add(timeList.get(5));
		timeList.add(new Time(12, 05, 22));
		timeList.add(new Time(17, 58, 13));
		timeList.add(timeList.get(9).add(timeList.get(8)));
		
		
		System.out.println("TIME LIST:");
		System.out.println();
		
		Collections.shuffle(timeList);
		
		System.out.println("BEFORE SORTING");
		for(Time t: timeList) {
			System.out.println(t.toString());
		}
		
		System.out.println();
		Collections.sort(timeList);
		System.out.println("AFTER SORTING");
		for(Time t: timeList) {
			System.out.println(t.toString());
		}
		
	}
}
