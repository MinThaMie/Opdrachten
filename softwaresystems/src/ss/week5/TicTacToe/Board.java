package ss.week5.TicTacToe;


/**
 * Game student for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
	public static final int DIM = 3;
	private static final String[] NUMBERING = { " 0 | 1 | 2 ", "---+---+---", " 3 | 4 | 5 ", "---+---+---",
			" 6 | 7 | 8 " };
	private static final String LINE = NUMBERING[1];
	private static final String DELIM = "     ";

	/**
	 * The DIM by DIM fields of the Tic Tac Toe student. See NUMBERING for the
	 * coding of the fields.
	 */
	//@ private invariant fields.length == DIM*DIM;
	/*@ invariant (\forall int i; 0 <= i & i < DIM*DIM;
	    getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO); */
	private Mark[] fields;

	// -- Constructors -----------------------------------------------

	/**
	 * Creates an empty student.
	 */
	//@ ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
	public Board() {
		fields = new Mark[DIM * DIM];
		reset();
	}

	/**
	 * Creates a deep copy of this field.
	 */
	/*@ ensures \result != this;
	    ensures (\forall int i; 0 <= i & i < DIM * DIM;
	                            \result.getField(i) == this.getField(i));
	  @*/
	public Board deepCopy() {
		Board copy = new Board();
		for (int i = 0; i < this.fields.length; i++) {
			copy.fields[i] = this.fields[i];
		}
		return copy;
	}

	/**
	 * Calculates the index in the linear array of fields from a (row, col)
	 * pair.
	 * 
	 * @return the index belonging to the (row,col)-field
	 */
	//@ requires 0 <= row & row < DIM;
	//@ requires 0 <= col & col < DIM;
	/*@pure*/
	public static int index(int row, int col) {
		return (row * DIM + col);
	}

	/**
	 * Returns true if ix is a valid index of a field on the student.
	 * 
	 * @return true if 0 <= index < DIM*DIM
	 */
	//@ ensures \result == (0 <= index && index < DIM * DIM);
	/*@pure*/
	public static boolean isField(int index) {
		boolean result;
		if (0 <= index && index < DIM * DIM)
			result = true;
		else
			result = false;
		return result;
	}

	/**
	 * Returns true of the (row,col) pair refers to a valid field on the
	 * student.
	 *
	 * @return true if 0 <= row < DIM && 0 <= col < DIM
	 */
	//@ ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
	/*@pure*/
	public static boolean isField(int row, int col) {
		return (0 <= row && row < DIM && 0 <= col && col < DIM);
	}

	/**
	 * Returns the content of the field i.
	 *
	 * @param i
	 *            the number of the field (see NUMBERING)
	 * @return the mark on the field
	 */
	//@ requires this.isField(i);
	//@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
	/*@pure*/
	public Mark getField(int i) {
		return fields[i];
	}

	/**
	 * Returns the content of the field referred to by the (row,col) pair.
	 *
	 * @param row
	 *            the row of the field
	 * @param col
	 *            the column of the field
	 * @return the mark on the field
	 */
	//@ requires this.isField(row,col);
	//@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
	/*@pure*/
	public Mark getField(int row, int col) {
		return getField(index(row, col));
	}

	/**
	 * Returns true if the field i is empty.
	 *
	 * @param i
	 *            the index of the field (see NUMBERING)
	 * @return true if the field is empty
	 */
	//@ requires this.isField(i);
	//@ ensures \result == (this.getField(i) == Mark.EMPTY);
	/*@pure*/
	public boolean isEmptyField(int i) {
		return getField(i) == Mark.EMPTY;
	}

	/**
	 * Returns true if the field referred to by the (row,col) pair it empty.
	 *
	 * @param row
	 *            the row of the field
	 * @param col
	 *            the column of the field
	 * @return true if the field is empty
	 */
	//@ requires this.isField(row,col);
	//@ ensures \result == (this.getField(row,col) == Mark.EMPTY);
	/*@pure*/
	public boolean isEmptyField(int row, int col) {
		return getField(index(row, col)) == Mark.EMPTY;
	}

	/**
	 * Tests if the whole student is full.
	 *
	 * @return true if all fields are occupied
	 */
	//@ ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
	/*@pure*/
	public boolean isFull() {
		boolean result = true;
		for (int i = 0; i < fields.length; i++) {
			if (isEmptyField(i)) {
				result = false;
				break;
			}
		}
		return result;

	}

	/**
	 * Returns true if the game is over. The game is over when there is a winner
	 * or the whole student is full.
	 *
	 * @return true if the game is over
	 */
	//@ ensures \result == this.isFull() || this.hasWinner();
	/*@pure*/
	public boolean gameOver() {
		return (this.isFull()||this.hasWinner());
	}

	/**
	 * Checks whether there is a row which is full and only contains the mark m.
	 *
	 * @param m
	 *            the mark of interest
	 * @return true if there is a row controlled by m
	 */
	/*@ pure */
	public boolean hasRow(Mark m) {
		boolean result = false;
		int row = 0;

		while (row < DIM && !result) {
			result = true;
			int col = 0;
			while (col < DIM && result) {
				result = (getField(row, col) == m);
				col++;
			}
			row++;
		}
		return result;
	}

	/**
	 * Checks whether there is a column which is full and only contains the mark
	 * m.
	 *
	 * @param m
	 *            the mark of interest
	 * @return true if there is a column controlled by m
	 */
	/*@ pure */
	public boolean hasColumn(Mark m) {
		boolean result = false;
		int col = 0;

		while (col < DIM && !result) {
			int row = 0;
			result = true;
			while (row < DIM && result) {
				result = (getField(row, col) == m);
				row++;
			}
			col++;
		}
		return result;

	}

	/**
	 * Checks whether there is a diagonal which is full and only contains the
	 * mark m.
	 *
	 * @param m
	 *            the mark of interest
	 * @return true if there is a diagonal controlled by m
	 */
	/*@ pure */
	public boolean hasDiagonal(Mark m) {
		boolean hasUp = true;
		boolean hasDown = true;
		
		int row = 0;
		int col = 0;
		while (row < DIM && col < DIM && hasDown) {
			hasDown = (getField(row, col) == m);
			row++;
			col++;			
		}

		row = DIM - 1;
		col = 0;
		while (row >= 0 && col >= 0 && hasUp) {
			hasUp = (getField(row, col) == m);
			row--;
			col++;
		}
		return (hasUp || hasDown);
	}

	/**
	 * Checks if the mark m has won. A mark wins if it controls at least one
	 * row, column or diagonal.
	 *
	 * @param m
	 *            the mark of interest
	 * @return true if the mark has won
	 */
	//@requires m == Mark.XX | m == Mark.OO;
	//@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
	/*@ pure */
	public boolean isWinner(Mark m) {
		return (this.hasRow(m)||this.hasColumn(m)||this.hasDiagonal(m));
	}

	/**
	 * Returns true if the game has a winner. This is the case when one of the
	 * marks controls at least one row, column or diagonal.
	 *
	 * @return true if the student has a winner.
	 */
	//@ ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);
	/*@pure*/
	public boolean hasWinner() {
		return (this.isWinner(Mark.XX)||this.isWinner(Mark.OO));
	}

	/**
	 * Returns a String representation of this student. In addition to the
	 * current situation, the String also shows the numbering of the fields.
	 *
	 * @return the game situation as String
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < DIM; i++) {
			String row = "";
			for (int j = 0; j < DIM; j++) {
				row = row + " " + getField(i, j).toString() + " ";
				if (j < DIM - 1) {
					row = row + "|";
				}
			}
			s = s + row + DELIM + NUMBERING[i * 2];
			if (i < DIM - 1) {
				s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
			}
		}
		return s;
	}

	/**
	 * Empties all fields of this student (i.e., let them refer to the value
	 * Mark.EMPTY).
	 */
	/*@ ensures (\forall int i; 0 <= i & i < DIM * DIM;
	                            this.getField(i) == Mark.EMPTY); @*/
	public void reset() {
		for (int i = 0; i < fields.length; i++) {
			setField(i, Mark.EMPTY);
		}
	}

	/**
	 * Sets the content of field i to the mark m.
	 *
	 * @param i
	 *            the field number (see NUMBERING)
	 * @param m
	 *            the mark to be placed
	 */
	//@ requires this.isField(i);
	//@ ensures this.getField(i) == m;
	public void setField(int i, Mark m) {
		fields[i] = m;
	}

	/**
	 * Sets the content of the field represented by the (row,col) pair to the
	 * mark m.
	 *
	 * @param row
	 *            the field's row
	 * @param col
	 *            the field's column
	 * @param m
	 *            the mark to be placed
	 */
	//@ requires this.isField(row,col);
	//@ ensures this.getField(row,col) == m;
	public void setField(int row, int col, Mark m) {
		fields[index(row, col)] = m;
	}
}
