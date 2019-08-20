package source;

import java.awt.Color;

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
	public String getSymbol() {
		return symbol;
	}
	/**
	 * Return the position of the location on the board
	 * @return
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * Return the name of the location
	 * @return
	 */
	public String getName() {
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
	public void setDoor() {
		isaDoor = true;
	}
	/**
	 * Check if the given piece of the location is a door
	 * @return
	 */
	public boolean isDoor() {
		return isaDoor;
	}

	public Color getColor() {
		if(name.equals("Kitchen")) {
			return new Color (0,51,102); //Dark Blue
		}
		else if (name.equals("Dining")) {
			return new Color (0,102,102); //Medium Green
		}
		else if (name.equals("Lounge")) {
			return new Color (255,255,153); //Light Yellow
		}
		else if (name.equals("Ball")) {
			return new Color (255,153,0); //Bright Orange
		}
		else if (name.equals("Hall")) {
			return new Color (153,0,0); //Maroon
		}
		else if (name.equals("Conservatory")) {
			return new Color (102,0,102); //Purple
		}
		else if (name.equals("Billiard")) {
			return new Color (255,0,255); //Pink
		}
		else if (name.equals("Library")) {
			return new Color (102,204,255); //Sea Blue
		}
		else if (name.equals("Study")) {
			return new Color (0,255,153); //Luminous Green
		}
		else {
			return Color.WHITE;
		}
	}
}
