
public class Cell extends GamePiece{
	private boolean blocked;
	
	public Cell(boolean blocked){
		this.blocked = blocked;
	}
	
	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public String toString(){
		if(blocked){
			return "B";
		}
		return "+";
	}
}
