package ss.week3.hotel;

/**
 * Hotel guest with a name and possibly a room.
 * 
 * @author Jasper Gerth
 * @version 1.0
 */
public class Guest {
	// ---------------------------Instance Variables
	private String name;
	private Room room;

	// ---------------------------Constructor
	/**
	 * Constructs a <code>Guest</code> with the <code>name</code> <code>n</code> 
	 * @param n The <code>name</code> of the <code>Guest</code>.
	 */
	public Guest(String n) {
		this.name = n;
	}

	// ---------------------------Queries
	/**
	 * Returns the <code>name</code> of the <code>Guest</code>.
	 * @return The <code>name</code> of the <code>Guest</code>
	 */
	/*@ pure*/public String getName() {
		return this.name;
	}

	/**
	 * Returns the <code>Room</code>
	 * @return The <code>Room</code> of the <code>Guest</code>
	 */
	public Room getRoom() {
		return this.room;
	}

	public String toString(){
		return "Guest " + this.name + " " + this.room.toString();
	}
	// ---------------------------Commands

	/**
	 * To check in a guest
	 * 
	 * @param r The <code>Room</code> to check in to;
	 * @return If the <code>Guest</code> is checked in
	 */
	public boolean checkin(Room r) {
		if (r.getGuest() == null && this.getRoom() == null) {
			r.setGuest(this);
			this.room = r;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To check out a <code>Guest</code>
	 * @return If the <code>checkout</code> succeeded
	 */
	public boolean checkout() {
		if (this.getRoom() == null) {
			return false;
		} else {
			this.room.setGuest(null);
			this.room = null;
			return true;
		}

	}
	

}
