/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		Huang Qian - 774496 - 262483611@qq.com
 */

/** GamePiece class
 */
public abstract class GamePiece extends Cell{
	
	public int[][] legalMoves;
	
	public final static int NUM_OF_POSSIBLE_MOVES = 3;
	
	public abstract int getLegalMoveX(int i);
	public abstract int getLegalMoveY(int i);
}
