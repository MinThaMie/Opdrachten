package ss.week3;

public class Multiplication implements OperatorWithIdentity {

	
	//-----------------------------Instance Variables

	//-----------------------------Constructor

	//-----------------------------Queries
	 @Override
	public int operate(int left, int right) {
		return left*right;
	}

	 @Override
	public int identity() {
		return 1;
	}

	//-----------------------------Commands
}
