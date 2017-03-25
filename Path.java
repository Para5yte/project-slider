/** Comp30024 - Project Part A
 *  Group members:
 *		Takemitsu Yamanaka - 757038 - tyamanaka@student.unimelb.edu.au
 * 		Huang Qian - 774496 - 262483611@qq.com
 */

/** Game board path
 */
public class Path extends Cell{
	private boolean blocked;
	
	/** Initializes a new open path object */
	public Path(){
		this.blocked = false;
	}
	
	/** Initializes a new blocked path object */
	public Path(boolean blocked){
		this.blocked = blocked;
	}
	
	/** Returns whether if this path is a blocked or open path
	 */
	public boolean isBlocked() {
		return blocked;
	}
}
