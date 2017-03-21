
public class Horizontal extends PlayerPiece{
	
	public int[][] legalMoves = new int[][]{
		{1,0},
		{0,1}, 
		{-1,0}
	};
	
	public String toString(){
		return "H";
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
