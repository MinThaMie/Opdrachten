package ss.week2;

public class ThreeWayLamp {
	//--------------------------------Instance variables
	public String setting;
	public int counter = 0;
	public final int OFF = 0;
	public final int LOW = 1;
	public final int MEDIUM = 2;
	public final int HIGH = 3;

	//--------------------------------Constructor
	public ThreeWayLamp() {
	}

	//--------------------------------Queries
	//@ ensures \result == "OFF" || \result == "LOW" || \result =="MEDIUM" || \result == "HIGH";
	public String getSetting() {
		switch (counter) {
		case OFF:
			setting = "OFF";
			break;
		case LOW:
			setting = "LOW";
			break;

		case MEDIUM:
			setting = "MEDIUM";
			break;

		case HIGH:
			setting = "HIGH";
			break;

		default:
			setting = "OFF";
		}
		return setting;
	}

	//--------------------------------Commands
	//@ ensures counter==0 || counter==1 || counter==2 || counter==3;
	//@ ensures counter==1 ==> \old(counter)==0;
	//@ ensures counter==2 ==> \old(counter)==1;
	//@ ensures counter==3 ==> \old(counter)==2;
	//@ ensures counter==0 ==> \old(counter)==3;	
	public void click() {
		counter++;
		if (counter % 4 == 0) {
			counter = 0;
		}
	}

	//--------------------------------Main
	
}
