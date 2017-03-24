import java.util.Scanner;

/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		add yours fam
 */
/** Main class which include the main method and the calculations of the legal moves
 */

public class LegalMoveProgram {
	
	private Scanner reader;
	
	/** Board state thats given to calculate the legal moves for player H and V */
	private Board boardConfiguration;
	
	/** Number of legal moves for Horizontal pieces; */
	private int numLegalHMoves = 0;
	
	/** Number of legal moves for Vertical pieces; */
	private int numLegalVMoves = 0;
	
	public LegalMoveProgram(){
		reader = new Scanner(System.in); // Reading from System.in
	}

	/** Main method which starts the program and prints the output */
	public static void main(String[] args) {
		LegalMoveProgram program = new LegalMoveProgram();
		program.read();
		program.calculateMoves();
		program.printResult();
	}
	
	/** Reads the input board state from System.In from the user
	*/
	public void read(){

		String inputLine;
		char piece;
		
		/* reads the initial board size and initializes the board with that size*/
		int boardSize = reader.nextInt();
		inputLine = reader.nextLine();
		boardConfiguration = new Board(boardSize);
		
		/* reads the board state given by System.in */
		for(int i = 0; i < boardSize; i++){
			
			inputLine = reader.nextLine();
	
			for(int j = 0; j < boardSize; j++){	
				piece = inputLine.charAt(j * 2); // times by 2 as there is a space bewteen each piece of the input
				boardConfiguration.markBoard(piece, i, j);
			}
		}
	}
	
	/** Calculates the legal moves player H and V can make 
	 */
	public void calculateMoves(){
		GamePiece piece = null;
		int size = boardConfiguration.getBoardSize();
		int temp = 0;
		
		for(int i = 0; i < size; i++){	
			for(int j = 0; j < size; j++){
				piece = boardConfiguration.getPiece(i,j);
				
				// if piece was a path/blocked path (cell) 
				// or blank piece then skip to next cell 
				if(piece instanceof Cell || piece == null)
					continue;
				
				/* Calculate the amount of legal moves the selected piece can make */
				temp = calculateLegalMoves(piece, i, j);
				
				if(piece instanceof Vertical)
					this.numLegalVMoves += temp;
				
				if(piece instanceof Horizontal)
					this.numLegalHMoves += temp;
			}
		}
	}
	
	/** Returns and calculates the amount of legal moves the inputed piece can make
	 * @param piece A player's game piece which is evaluated
	 * @param x The x coordinate of the piece
	 * @param y The y coordinate of the piece
	 */
	public int calculateLegalMoves(GamePiece piece, int x, int y){
		int move = 0;
		int tempX, tempY;
		//Downcast from GamePiece to PlayerPiece
		PlayerPiece playerPiece = (PlayerPiece) piece; 
	
		for(int i = 0; i < 3; i++){ // Need to change that number
			
			tempX = playerPiece.getLegalMoveX(i) + x;
			tempY = playerPiece.getLegalMoveY(i) + y;
			
			// if out of bound then illegal move
			if(!boardConfiguration.outOfBond(tempX, tempY)){
				GamePiece path = boardConfiguration.getPiece(tempX, tempY);
				// if it's a path and not a blocked cell, then legal move
				if(path instanceof Cell && !((Cell) path).isBlocked()){
					move ++;
				}
			}
		}
		return move;
	}
	
	/** Prints the results of number of legal moves each Player can make
	 */
	public void printResult(){
		System.out.println(numLegalHMoves);
		System.out.println(numLegalVMoves);
	}
}
