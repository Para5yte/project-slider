import java.util.Scanner;

public class LegalMoveProgram {
	Scanner reader;
	Board boardConfiguration;
	/** Number of legal moves for Horizontal pieces; */
	private int numLegalHMoves = 0;
	/** Number of legal moves for Vertical pieces; */
	private int numLegalVMoves = 0;
	
	public LegalMoveProgram(){
		reader = new Scanner(System.in); // Reading from System.in
	}

	public static void main(String[] args) {
		
		LegalMoveProgram program = new LegalMoveProgram();
		program.read();
		program.calculateMoves();
		program.printResult();
	}
		
	public void read(){

		String inputLine;
		char piece;
		
		int boardSize = reader.nextInt();
		inputLine = reader.nextLine();
		boardConfiguration = new Board(boardSize);
			
		for(int i = 0; i < boardSize; i++){
			
			inputLine = reader.nextLine();
			
			for(int j = 0; j < boardSize; j++){
				
				piece = inputLine.charAt(j * 2);
				boardConfiguration.markBoard(piece, i, j);
			}
		}
		boardConfiguration.printBoard();
	}
	
	public void calculateMoves(){
		GamePiece piece = null;
		int size = boardConfiguration.getBoardSize();
		int temp = 0;
		
		for(int i = 0; i < size; i++){
			
			for(int j = 0; j < size; j++){
				piece = boardConfiguration.getPiece(i,j);
				if(piece instanceof Cell || piece == null){
					continue;
				}
				
				temp = calculateLegalMoves(piece, i, j);
				
				if(piece instanceof Vertical){
					this.numLegalVMoves += temp;
				}
				
				if(piece instanceof Horizontal){
					this.numLegalHMoves += temp;
				}
			}
		}
	}
	
	public int calculateLegalMoves(GamePiece piece, int x, int y){
		int move = 0;
		int tempX, tempY;
		PlayerPiece playerPiece = (PlayerPiece) piece;
		
		for(int i = 0; i < 3; i++){
			
			
			tempX = playerPiece.getLegalMoveX(i) + x;
			tempY = playerPiece.getLegalMoveY(i) + y;
			
			if(!boardConfiguration.outOfBond(tempX, tempY)){
				GamePiece path = boardConfiguration.getPiece(tempX, tempY);
				if(path instanceof Cell && !((Cell) path).isBlocked()){
					move ++;
				}
			}
		}
		
		return move;
	}
	
	public void printResult(){
		System.out.println(numLegalHMoves);
		System.out.println(numLegalVMoves);
	}
}
