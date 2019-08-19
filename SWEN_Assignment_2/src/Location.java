

public abstract class Location {
	private String name;
	private String symbol;
	private Position position;
	private boolean isaDoor ;
	
	public Location(String name, String symbol, Position position) {
		this.name = name;
		this.symbol = symbol;
		this.position = position;
	}
	
	/**
	 * Return the symbol used to represent the location
	 * @return
	 */
	protected String getSymbol() {
		return symbol;
	}
	/**
	 * Return the position of the location on the board
	 * @return
	 */
	protected Position getPosition() {
		return position;
	}
	/**
	 * Return the name of the location
	 * @return
	 */
	protected String getName() {
		return name;
	}
	/**
	 * Set the new position of the location
	 * @param p
	 */
	protected void setPosition(Position p) {
		position = p;
	}
	/**
	 * Set a piece of the location as a door
	 */
	protected void setDoor() {
		isaDoor = true;
	}
	/**
	 * Check if the given piece of the location is a door
	 * @return
	 */
	protected boolean isDoor() {
		return isaDoor;
	}
}
