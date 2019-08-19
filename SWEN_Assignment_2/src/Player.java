

public class Player{

	private Position pos;
	private Character name;
	private boolean suggest;
	
	public Player(Character c, Position p) {
		this.name = c;
		this.pos = p;	
	}
	/**
	 * Get the current position of the player
	 * @return
	 */
	protected Position getPos() {
		return pos;
	}
	/**
	 * Get the character represented by the player
	 * @return
	 */
	protected Character getCharacterName() {
		return name;
	}
	/**
	 * Set the new position of the player
	 * @param newPos
	 */
	protected void setPos(Position newPos) {
		pos = newPos;
	}
	/**
	 * Indicate to the player that it is his time to suggest or that he has finished his suggestion
	 * @param 
	 */
	protected void timeToSuggest(Boolean answer) {
		suggest = answer;
	}
	/**
	 * Check if the player can suggest at a given moment
	 * @return
	 */
	protected boolean canSuggest() {
		return suggest;
	}

}