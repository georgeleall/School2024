package lab;

import java.text.DecimalFormat;
import java.util.Random;

public class Money implements Comparable<Money>, Calculable<Money>{

	private int dollars;
	private int cents;
	
	
	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public Money(Money m) {
		this.dollars = m.dollars;
		this.cents = m.cents;
	}
	
	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
	}

	public int getCents() {
		return cents;
	}

	public void setCents(int cents) {
		this.cents = cents;
	}

	@Override
	public Money add(Money m) {
		int newCents = this.cents + m.cents;
		if(newCents > 99) {
			this.dollars++;
			newCents -= 100;
		}	
		return new Money(this.dollars + m.dollars, newCents);
	}
	
	@Override
	public Money subtract(Money m) {
		int newCents = this.cents - m.cents;
		if(newCents < 0) {
			this.dollars--;
			newCents += 100;
		}
		return new Money(this.dollars - m.dollars, newCents);
	}
	
	@Override
	public int compareTo(Money m) {
		int currentCents = (this.dollars * 100) + this.cents;
		int otherCents = (m.dollars * 100) + m.cents;
		if(currentCents > otherCents) {
			return 1;
		} else if(currentCents == otherCents) {
			return 0;
		}else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("$0.00");
		return df.format((double) this.dollars + (double) this.cents / 100);
	}
	
}

