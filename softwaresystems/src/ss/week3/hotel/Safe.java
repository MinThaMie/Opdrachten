package ss.week3.hotel;

public class Safe {
	// -----------------------------Instance Variables
	private Password pass;
	private boolean isOpen;
	private boolean isActive;

	public static void main(String[] args) {
		new Safe().activate(null);
	}

	// -----------------------------Constructor
	//@ ensures getPassword()!=null && isActive()==false && isOpen()== false;
	public Safe() {
		pass = new Password();
		isOpen=false;
		isActive=false;
	}

	// -----------------------------Queries
	/*@ pure */public boolean isActive() {
		return isActive;
	}

	/*@ pure */public boolean isOpen() {
		return isOpen;
	}
//@ ensures \result!=null;
	/*@ pure */public Password getPassword() {
		return this.pass;
	}
	// -----------------------------Commands

	// Activates the safe if the password is correct
	//@ requires  pass!=null;	
	//@ ensures getPassword().testWord(pass) ==> isActive()==true;
	public void activate(String pass) {
		if (this.isActive == false) {
			this.isActive = getPassword().testWord(pass);

			assert isActive() == getPassword().testWord(pass);
		}
	}

	//@ ensures isActive()==false;
	//@ ensures isOpen()==false;
	public void deActivate() {
		this.isActive = false;
		this.isOpen = false;

		assert isOpen() == false;
		assert isActive() == false;
	}

	//@ requires getPassword().testWord(pass)==true;
	//@ requires isActive()==true;
	//@ ensures isOpen()==true;
	public void open(String pass) {
		if (this.isOpen == false)
			this.isOpen = (getPassword()).testWord(pass) && isActive;

		if ((getPassword()).testWord(pass) && isActive) {
			assert isOpen() == true;
			assert isActive() == true;
		} else {
			assert isOpen() == false;
		}
	}

	//@ ensures isOpen()==false;
	//@ ensures isActive()==\old(isActive());
	public void close() {
		this.isOpen = false;
		assert isOpen() == false;

	}
}
