/**
 * 
 */
package ss.week2;

/**
 * @author Jasper Gerth
 *
 */
public class Rectangle {
	// -----------------------------Instance Variables
	// @ private invariant width>=0;
	private int width;
	// @ private invariant length>=0;
	private int length;

	// -----------------------------Constructor
	// create a new <code>Rectangle</code> with the specified length and width.
	// Length and width must be non negative.
	// @ requires length>=0;
	// @ requires width>=0;
	// @ ensures length()==length;
	// @ ensures width()==width;
	public Rectangle(int length, int width) {
		assert length >= 0 : "Enter integer zero or greater for length";
		assert width >= 0;

		this.length = length;
		this.width = width;

		assert this.length == length;
		assert this.width == width;
	}

	// -----------------------------Queries
	// The length of this <code>Rectangle</code>
	// @ ensures \result>=0;
	/* @ pure */public int length() {
		assert length >= 0 : length = 0;
		return length;
	}

	// The width of this <code>Rectangle</code>
	// @ ensures \result>=0;
	/* @ pure */public int width() {
		assert width >= 0;
		return width;
	}

	// The area of this <code>Rectangle</code>
	// @ ensures \result>0 && \result == length()*width();
	/* @ pure */public int area() {
		assert length * width >= 0;
		return length * width;
	}

	// The perimeter of this <code>Rectangle</code>
	// @ ensures \result>=0;
	/* @ pure */public int perimeter() {
		assert 2 * length + 2 * width >= 0;
		return 2 * length + 2 * width;
	}

	// -----------------------------Commands
}
