package tyamanaka.slider;

/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		Huang Qian - 774496 - 262483611@qq.com
 */

/** Horizontal game piece class
 */
public class Horizontal extends GamePiece{
	
	/* Legal moves only Horizontal can make */
	public int[][] legalMoves = new int[][]{
		{-1,0}, //up
		{0,1}, //right
		{1,0} //down
	};
	
	/** returns the x value of the i'th possible move
	 */
	@Override
	public int getLegalMoveX(int i) {	
		return legalMoves[i][0];
	}
	
	/** returns the y value of the i'th possible move
	 */
	@Override
	public int getLegalMoveY(int i) {
		return legalMoves[i][1];
	}
}
