package lab;

public class Time implements Comparable<Time>, Calculable<Time>{
	private int hours;
	private int mins;
	private int secs;
	
	
	
	public Time(int hours,int mins,int secs) {
		this.hours = hours;
		this.secs = secs;
		this.mins = mins;
		
		
	}
	
	public Time(Time t) {
		this.hours = t.getHours();
		this.mins = t.getMins();
		this.secs = t.getSecs();
	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public int getSecs() {
		return secs;
	}

	public void setSecs(int secs) {
		this.secs = secs;
	}

	
	@Override
	public Time add(Time t) {
		int totalSecs = this.secs + t.secs;
		if(totalSecs > 59) {
			this.mins++;
			totalSecs -=60;
		}
		
		int totalMins = this.mins + t.mins;
		if(totalMins > 59) {
			this.hours++;
			totalMins -=60;
		}
		
		int totalhours = this.hours + t.hours;
		
		if (totalhours > 23) {
			totalhours -= 24;
		}
		
		return new Time(totalhours,totalMins,totalSecs);
		}
	
	
	@Override
	public Time subtract (Time t) {
		int totalSecs = this.secs - t.secs;
		if(totalSecs < 0 ) {
			this.mins--;
			totalSecs += 60;
		}
		
		int totalMins = this.mins - t.mins;
		if(totalMins < 0) {
			this.hours--;
			totalMins += 60;
		}
		
		int totalHours = this.hours - t.hours;
		if(totalHours < 0) {
			totalHours += 24;
		}
		
		return new Time(totalHours, totalMins, totalSecs);
	}
	
	@Override
	public int compareTo(Time t) {
		int totalCurrentSecs = (this.hours * 3600) + (this.mins *60) + this.secs;
		int totalOtherSecs = (t.hours * 3600) + (t.mins *60) + t.secs;
		
		if(totalCurrentSecs > totalOtherSecs) {
			return 1;
		} else if(totalCurrentSecs == totalOtherSecs) {
			return 0;
		} else {
			return -1;
		}

	}
	
	@Override
	public String toString() {
		return this.hours + ":" +this.mins + ":" + this.secs;
	}
}
