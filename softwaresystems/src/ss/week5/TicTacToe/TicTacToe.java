package ss.week5.TicTacToe;


/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	private static Player player1;
	private static Player player2;

	private static Game spel;
	private static final String NAIVEPC = "-N";

	public static void main(String[] args) {

		if (args[0].equals(NAIVEPC)) {
			player1 = new ComputerPlayer(Mark.OO, new NaiveStrategy());}
		else{
			player1=new HumanPlayer(args[0],Mark.OO);
		}
		
		if (args[1].equals(NAIVEPC)){
			player2=new ComputerPlayer(Mark.XX, new NaiveStrategy());
		}else{
			player2= new HumanPlayer(args[1],Mark.XX);
		}			

		spel = new Game(player1, player2);
		spel.start();

	}

}
