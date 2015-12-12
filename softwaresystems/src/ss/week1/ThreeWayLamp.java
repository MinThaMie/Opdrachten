package ss.week1;

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
		//System.out.println("The setting of the lamp is now " + setting);
	}

	//--------------------------------Commands
	public void click() {
		counter++;
		if (counter % 4 == 0) {
			counter = 0;
		}
		//counter = (counter +1) % 4;
	}

	//--------------------------------Main
	
}
