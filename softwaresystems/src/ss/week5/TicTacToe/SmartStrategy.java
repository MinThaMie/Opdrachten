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

		int result;
		if (copy(b).isEmptyField(MIDDLE)) {
			result = MIDDLE;
		} else if (hasDirectWin(copy(b), m)) {
			result = isDirectWin(copy(b), m);
		} else if (hasDirectWin(copy(b), m.other())) {
			result = isDirectWin(copy(b), m.other());
		} else {
			List<Integer> emptyFields = emptyFields(b);
			result = (int) emptyFields.get((int) Math.floor(Math.random() * (emptyFields.size())));
		}
		return result;

	}

	private Board copy(Board b) {
		return b.deepCopy();
	}

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
