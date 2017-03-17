
public class Vertical extends PlayerPiece {

	public int[][] legalMoves = new int[][]{
		{-1,0},
		{0,1}, 
		{0,-1}
	};
	
	public String toString(){
		return "V";
	}

	@Override
	public int getLegalMoveX(int i) {
		
		return legalMoves[i][0];
	}
	
	@Override
	public int getLegalMoveY(int i) {
		
		return legalMoves[i][1];
	}
}
