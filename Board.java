/** The Game Board
 */
public class Board {
	private int boardSize;
	private GamePiece[][] boardState;
	
	/** initialting a new Board */
	public Board(int size){
		this.boardSize = size;
		this.boardState = new GamePiece[boardSize][boardSize];
	}
	
	/** Marks the board with a given content
	 * @param content The charater value of the piece
	 * @param x The x coordinate of the given content
	 * @param y The y coordinate of the given content
	 */
	public void markBoard(char content, int x, int y){
		GamePiece piece = null;
		
		/* Only four types of game pieces in the game */
		switch(content){
			case 'H': 
				piece = new Horizontal();
				break;
			case 'V': 
				piece = new Vertical();
				break;
			case '+':
				piece = new Cell(false);
				break;
			case 'B':
				piece = new Cell(true);
				break;
			default:
				break;
		}
		
		this.boardState[x][y] = piece;
	}
	
	/** Checks if the given coordinates are out of bound from the board
	 *  @param x The x coordinate
	 *  @param y The y coordinate
	 */ 
	public boolean outOfBond(int x, int y){
		return x < 0 || x >= boardSize || y < 0 || y >= boardSize;
	}
	
	/** returns the piece thats in the position of the given coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public GamePiece getPiece(int x, int y){
		return boardState[x][y];
	}
	
	/** returns the board size
	 */
	public int getBoardSize() {
		return boardSize;
	}
}
