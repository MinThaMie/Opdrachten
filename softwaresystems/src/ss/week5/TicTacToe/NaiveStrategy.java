package ss.week5.TicTacToe;

import java.util.ArrayList;
import java.util.List;


public class NaiveStrategy implements Strategy {
private final static String NAME = "Naive";

public NaiveStrategy(){}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		List<Integer> emptyFields=emptyFields(b);
		return (int) emptyFields.get((int) Math.floor(Math.random()*(emptyFields.size())));
	}
	
	private static List<Integer> emptyFields(Board b){
		List<Integer> emptyFields = new ArrayList<Integer>();
		int j=0;
		for (int i=0; i<(Board.DIM*Board.DIM);i++){
			if (b.isEmptyField(i)){
				emptyFields.add(j,i);
				j++;
			}
		}		
		return emptyFields;		
	}
	
}
