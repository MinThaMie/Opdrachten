package ss.week5.TicTacToe;

public class ComputerPlayer extends Player{
	//-----------------------------Instance Variables
private Strategy strategy;

	//-----------------------------Constructor
	public ComputerPlayer (Mark mark, Strategy strategy){
		super(strategy.getName() + "-" + mark.toString(),mark);
		this.strategy=strategy;
		
	}
	
	public ComputerPlayer (Mark mark){
		//ik wil hier graag NaiveStrategy.getName gebruiken maar dat kan niet omdat die niet static is, en ik kan die niet static makem omdat de interface dan gaat huilen
		super(NaiveStrategy.getName() + "-" + mark.toString() , mark);
		this.strategy = new NaiveStrategy();			
	}

	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, this.getMark());
	}
}
