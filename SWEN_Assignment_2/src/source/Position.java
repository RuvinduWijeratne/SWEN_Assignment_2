package source;


public class Position {
	

	private int x;
	private int y;
	
	public Position(int y, int x) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Return the X value of the position
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * Return the Y value of the position
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Set the given X value as the current X value
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Set the given Y value as the current Y value
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}