package ss.week5.TicTacToe;

import java.util.List;


public class NaiveStrategy implements Strategy {
private final String NAME = "Naive";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		String possibleFields = emptyFields(b);
		int numField=(int) Math.floor( Math.random()*(possibleFields.length()))+1;
		return possibleFields.charAt(numField);
	}
	
	private static String emptyFields(Board b){
		String result="";
		for (int i=0;i<(Board.DIM*Board.DIM);i++){
			if (b.isField(i) && b.isEmptyField(i))
				result= result +((Integer) i).toString();
		}
		return result;
		
	}
	
}
