package ss.week2;

public class ThreeWayLampenum {
	// --------------------------------Instance variables

	

	private enum state {
		OFF, LOW, MEDIUM, HIGH
	};

	public state setting;

	// --------------------------------Constructor
	public ThreeWayLampenum() {
		setting = state.OFF;
	}

	// --------------------------------Queries

	public String getSetting() {
		return setting.toString();
	}

	// --------------------------------Commands
	// 
	public void click() {
		switch (setting){
		case OFF:
			setting = state.LOW;
			break;
		case LOW:
			setting = state.MEDIUM;
			break;
		case MEDIUM:
			setting = state.HIGH;
			break;
		case HIGH:
			setting = state.OFF;
			break;
		}		
		
	}
	// --------------------------------Main

}
