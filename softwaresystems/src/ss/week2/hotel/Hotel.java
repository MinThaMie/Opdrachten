package ss.week2.hotel;

public class Hotel {
	// -----------------------------Instance Variables
	String name;

	private Room room1;
	private Room room2;
	private Password hotelpass;

	// -----------------------------Constructor

	public Hotel(String hotelname) {
		name = hotelname;
		hotelpass = new Password();
		room1 = new Room(1);
		room2 = new Room(2);
		assert room1 != null;
		assert room2 != null;
	}

	// -----------------------------Queries

	//@ ensures \result!=null ==> \result.getGuest()==null;
	/*@ pure */public Room getFreeRoom() {
		Room result;
		if (room1.getGuest() == null) {
			result = room1;
			assert result != null;
		} else if (room2.getGuest() == null) {
			result = room2;
			assert result != null;
		} else {
			result = null;
		}
		return result;
	}

	//@ ensures \result.getGuest()==null || \result==null;
	/*@ pure */public Room getRoom(String guestName) {
		Room result;

		if (room1.getGuest() != null && guestName.equals(room1.getGuest().getName())) {
			result = room1;
			assert result != null;
		} else if (room2.getGuest() != null && guestName.equals(room2.getGuest().getName())) {
			result = room2;
			assert result != null;
		} else {
			result = null;
		}
		return result;
	}

	/*@ pure */public Password getPassword() {
		assert hotelpass != null;
		return hotelpass;
	}

	/*@ pure */public String toString() {
		String room1string;
		String room2string;
		if (room1.getGuest() != null) {
			room1string = ("Room 1, has guest " + (room1.getGuest().getName()) + " and the safe is "
					+ ((room1.getSafe().isActive()) ? "active" : "not active") + " and "
					+ ((room1.getSafe().isOpen()) ? "open" : "not open") + "\n");
		} else {
			room1string = ("Room 1 is empty");
		}
		if (room2.getGuest() != null) {
			room2string = ("Room 2, has guest " + (room2.getGuest().getName()) + " and the safe is "
					+ ((room2.getSafe().isActive()) ? "active" : "not active") + " and "
					+ ((room2.getSafe().isOpen()) ? "open" : "not open") + "\n");
		} else {
			room2string = ("Room 2 is empty");
		}

		assert (room1string.contains("guest") || room1string.contains("empty"));
		assert (room2string.contains("guest") || room2string.contains("empty"));

		return room1string + room2string;

	}

	/*@ pure */public String getName() {
		assert name != null;
		return name;
	}

	/*@ pure */ private boolean isFull() {
		assert room1 != null;
		assert room2 != null;

		return !((room1.getGuest() == null) || (room2.getGuest() == null));
	}

	/*@ pure */ private boolean isAlreadyGuest(String guestName) {
		assert guestName != null;
		return !(getRoom(guestName) == null);
	}

	// -----------------------------Commands
	//@ requires pass!=null;
	//@ requires guestName!=null;
	//@ ensures \result==null || \result.getGuest().getName()==guestName;
	public Room checkIn(String pass, String guestName) {
		assert pass != null;

		Room result;

		if ((this.getPassword().testWord(pass)) && (this.isFull() == false)
				&& (this.isAlreadyGuest(guestName) == false)) {

			Room room = getFreeRoom();

			room.setGuest(new Guest(guestName));
			result = room;
		} else {
			result = null;
		}
		return result;
	}

	//@ ensures getRoom(guestName)==null;
	//@ ensures getRoom(guestName).getSafe().isActive()==false;
	//@ ensures getRoom(guestName).getGuest()==null;
	public void checkOut(String guestName) {
		Room room = getRoom(guestName);
		
		if (room != null) {
			room.getSafe().deActivate();
			room.getGuest().checkout();
			room.setGuest(null);

			assert room.getSafe().isActive() == false;
			assert room.getGuest() == null;

		}
	}

}
