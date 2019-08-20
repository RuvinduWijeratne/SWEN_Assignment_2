package source;


public class Square {
	private Location loc;
	private Player player;
	private boolean occupied=false;
	private boolean restricted=false;
	
	/**
	 * Constructor to create a square that holds a location
	 * @param l
	 */
	public Square(Location l) {
		this.loc = l;
	}
	/**
	 * Constructor to create a square that is restricted
	 * @param s
	 */
	public Square(String s) {
		this.restricted = true;
	}
	/**
	 * Return if the current square is occupied by another object
	 * @return
	 */
	public boolean isOccupied() {
		return occupied;
	}
	/**
	 * Return if the current square is restricted
	 * @return
	 */
	public boolean isRestricted() {
		return restricted;
	}
	/**
	 * Set the current square as occupied
	 * @param p
	 */
	public void setOccupied(Player p) {
		this.occupied = true;
		player = p;
	}
	/**
	 * Set the current square as NOT occupied
	 * @param i
	 */
	public void notOccupied(Player i) {
		this.occupied = false;
		player = null;
	}
	/**
	 * Return the location of the square
	 * @return
	 */
	public Location getLocation() {
		return loc;
	}
	/**
	 * Get the player currently on the sqaure
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * Return a string with the name of the object occupying the square
	 * @return
	 */
	public String drawSquare() {
		if(restricted) {
			return "X";
		}
		if(occupied) {
			return player.getCharacterName().getSymbol();
		}
		else {
			if(loc.isDoor()) {
				return "^";
			}
			else {
				return loc.getSymbol();
			}
		}
	}

	

	
}