import java.util.Scanner;

/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		Huang Qian - 774496 - 262483611@qq.com
 */

/** Main class which include the main method and the calculations of the 
	legal moves
 */

public class LegalMoveProgram {
	
	private Scanner reader;
	
	/** Board state thats given to calculate the legal moves */
	private Board boardConfiguration;
	
	/** Number of legal moves for Horizontal pieces; */
	private int numLegalHMoves = 0;
	
	/** Number of legal moves for Vertical pieces; */
	private int numLegalVMoves = 0;
	
	public LegalMoveProgram(){
		reader = new Scanner(System.in); // Reading from System.in
	}

	/** Main method which starts the program and prints the output 
	 */
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
		
		/* reads the board size and initializes the board with that size*/
		int boardSize = reader.nextInt();
		inputLine = reader.nextLine(); // to read the "\n" after first number
		boardConfiguration = new Board(boardSize);
		
		/* reads the board state given by System.in */
		for(int i = 0; i < boardSize; i++){
			
			inputLine = reader.nextLine();
	
			for(int j = 0; j < boardSize; j++){	
				piece = inputLine.charAt(j * 2); 
				/*times by 2 as there is a space between each 
				piece of the input*/
				boardConfiguration.markBoard(piece, i, j);
			}
		}
	}
	
	/** Calculates the legal moves player H and V can make 
	 */
	public void calculateMoves(){
		Cell item = null;
		int size = boardConfiguration.getBoardSize();
		int temp = 0;
		
		for(int y = 0; y < size; y++){	
			for(int x =  0; x < size; x++){
				item = boardConfiguration.getPiece(y, x);
				
				// if piece was a path/blocked path (cell) 
				// or blank piece then skip to next cell 
				if(item instanceof Path || item == null)
					continue;
				
				/* Calculate the amount of legal moves the selected piece can 
				 * make. The argument item is also downcasted to GamePiece
				 */
				temp = calculateLegalMoves((GamePiece)item, y, x);
				
				if(item instanceof Vertical)
					this.numLegalVMoves += temp;
				
				if(item instanceof Horizontal)
					this.numLegalHMoves += temp;
			}
		}
	}
	
	/** Returns and calculates the amount of legal moves the inputed piece 
	 *  can make
	 * @param piece A player's game piece which is evaluated
	 * @param x The x coordinate of the piece
	 * @param y The y coordinate of the piece
	 */
	public int calculateLegalMoves(GamePiece piece, int y, int x){
		int move = 0;
		int tempY, tempX;
		
		for(int i = 0; i < GamePiece.NUM_OF_POSSIBLE_MOVES; i++){
			
			tempY = piece.getLegalMoveY(i) + y;
			tempX = piece.getLegalMoveX(i) + x;

			// if out of bound then illegal move
			if(!boardConfiguration.outOfBond(tempY, tempX, piece)){
				Cell path = boardConfiguration.getPiece(tempY, tempX);
				// if the path is a out of board piece, then it can move off
				// the board to score a point thus legal move
				if(path == null){
					move ++;
				}
				// if it's a path and not a blocked cell, then legal move
				if(path instanceof Path && !((Path) path).isBlocked()){
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
