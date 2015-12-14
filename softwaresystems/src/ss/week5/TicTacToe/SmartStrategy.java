package ss.week5.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements Strategy {
	private static final String NAME = "SmartStrategy";
	private static final int MIDDLE = 4;

	public SmartStrategy() {
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		Board copy = b.deepCopy();
		int noWin = -1;
		int result;
		int iWin=noWin;
		int otherWin=noWin;
		boolean emptyMiddle = copy.isEmptyField(MIDDLE);
		
		if (!emptyMiddle)
		 iWin = directWin(copy, m, noWin);
		 if (!emptyMiddle && iWin==noWin)
		 otherWin = directWin(copy, m.other(), noWin);
		

		if (emptyMiddle) {
			result = MIDDLE;
		} else if (iWin != noWin) {
			result = iWin;
		} else if (otherWin != noWin) {
			result = otherWin;
		} else {
			List<Integer> emptyFields = emptyFields(b);
			result = (int) emptyFields.get((int) Math.floor(Math.random() * (emptyFields.size())));
		}

		////OUDE TRAGE SHIT
		/*int result;
		if (copy(b).isEmptyField(MIDDLE)) {
			result = MIDDLE;
		} else if (hasDirectWin(copy(b), m)) {
			result = isDirectWin(copy(b), m);
		} else if (hasDirectWin(copy(b), m.other())) {
			result = isDirectWin(copy(b), m.other());
		} else {
			List<Integer> emptyFields = emptyFields(b);
			result = (int) emptyFields.get((int) Math.floor(Math.random() * (emptyFields.size())));
		}*/
		return result;

	}
	/*
//// IS VAN OUDE TRAGE SHIT
	private Board copy(Board b) {
		return b.deepCopy();
	}
///IS VAN OUDE TRAGE SHIT
	private boolean hasDirectWin(Board b, Mark m) {
		boolean hasWin = false;

		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			if (b.isEmptyField(i)) {
				b.setField(i, m);
				if (b.isWinner(m)) {
					hasWin = true;
					break;
				}
				b.setField(i, Mark.EMPTY);
			}

		}
		return hasWin;
	}
//// IS VAN OUDE TRAGE SHIT
	private int isDirectWin(Board b, Mark m) {
		int isWin = 0;

		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			if (b.isEmptyField(i)) {
				b.setField(i, m);
				if (b.isWinner(m)) {
					isWin = i;
					break;
				}
				b.setField(i, Mark.EMPTY);
			}
		}
		return isWin;

	}*/

	private int directWin(Board b, Mark m, int noWin) {
		int isWin = noWin;

		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			if (b.isEmptyField(i)) {
				b.setField(i, m);
				if (b.isWinner(m)) {
					isWin = i;
					break;
				}
				b.setField(i, Mark.EMPTY);
			}
		}
		return isWin;

	}

	private static List<Integer> emptyFields(Board b) {
		List<Integer> emptyFields = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(j, i);
				j++;
			}
		}
		return emptyFields;
	}
}
