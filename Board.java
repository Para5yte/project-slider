
public class Board {
	private int boardSize;
	private GamePiece[][] boardState;
	
	
	public Board(int size){
		this.boardSize = size;
		this.boardState = new GamePiece[boardSize][boardSize];
	}
	
	
	public void initiateBoard(){
		//for(int i; )
	}
	
	public void markBoard(char content, int x, int y){
		GamePiece piece = null;
		
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
	
	public void printBoard(){
		for(int i = 0; i < boardSize; i++){
			
			for(int j = 0; j < boardSize; j++){
				
				System.out.print(boardState[i][j].toString() + ' ');
			}
			System.out.print("\n");
		}
	}
	
	public boolean outOfBond(int x, int y){
		return x < 0 || x >= boardSize || y < 0 || y >= boardSize;
	}
	
	public GamePiece getPiece(int x, int y){
		return boardState[x][y];
	}
	
	public int getBoardSize() {
		return boardSize;
	}


	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
}