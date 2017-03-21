
public abstract class PlayerPiece extends GamePiece{
	public int[][] legalMoves;
	
	public abstract int getLegalMoveX(int i);
	public abstract int getLegalMoveY(int i);
}
