/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		Huang Qian - 774496 - 262483611@qq.com
 */

/** The Game Board
 */
public class Board {
	private int boardSize;
	private Cell[][] boardState;
	
	/** Initializing a new Board */
	public Board(int size){
		this.boardSize = size;
		this.boardState = new Cell[boardSize][boardSize];
	}
	
	/** Marks the board with a given content
	 * @param content The character value of the piece
	 * @param x The x coordinate of the given content
	 * @param y The y coordinate of the given content
	 */
	public void markBoard(char content, int y, int x){
		Cell piece = null;
		
		/* Only four types of game pieces in the game */
		switch(content){
			case 'H': 
				piece = new Horizontal();
				break;
			case 'V': 
				piece = new Vertical();
				break;
			case '+':
				piece = new Path();
				break;
			case 'B':
				piece = new Path(true);
				break;
			default:
				break;
		}
		
		this.boardState[y][x] = piece;
	}
	
	/** Checks if the given coordinates are out of bound from the board
	 *  @param x The x coordinate
	 *  @param y The y coordinate
	 */ 
	public boolean outOfBond(int y, int x, GamePiece piece){
		if(piece instanceof Horizontal){
			/* Horizontal can move right off the board to score a point */
			return x < 0 || x > boardSize || y < 0 || y >= boardSize;
		}
		else{ // if piece instanceof Vertical
			/* Veritcal can move top off the board to score a point */
			return x < 0 || x >= boardSize || y < -1 || y >= boardSize;
		}
	}
	
	/** returns the piece thats in the position of the given coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Cell getPiece(int y, int x){
		if( x == boardSize || y == -1){
			return null;		
		}
		return boardState[y][x];
	}
	
	/** returns the board size
	 */
	public int getBoardSize() {
		return boardSize;
	}
}
