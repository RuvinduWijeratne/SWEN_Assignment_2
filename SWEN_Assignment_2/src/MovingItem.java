

public abstract class MovingItem {
	
	private String name ;
	private String symbol;
	private Position position;
	
	
	public MovingItem(String name, String sym, Position pos) {
		this.name = name;
		this.symbol=sym;
		this.position = pos;
	}

	/**
	 * Return the name of the item
	 * @return
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Return the symbol used to represent the item on the board
	 * @return
	 */
	protected String getSymbol() {
		return symbol;
	}
	
	/**
	 * Return the position of the item
	 * @return
	 */
	protected Position getPosition() {
		return position;
	}
}