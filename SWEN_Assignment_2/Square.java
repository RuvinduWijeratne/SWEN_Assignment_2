package ruvindhu;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Square extends JPanel{
	private Location loc;
	private Player player;
	private boolean occupied=false;
	private boolean restricted=false;
	
	private int tileID;
	private static final Dimension TITLE_PANEL_DIMENSION = new Dimension (10,10);
	
	/**
	 * Constructor to create a square that holds a location
	 * @param l
	 */
	public Square(Location l) {
		super(new GridBagLayout());
		this.loc = l;
		setPreferredSize(TITLE_PANEL_DIMENSION);
		validate();	
	}
	
	/**
	 * Constructor to create a square that is restricted
	 * @param s
	 */
	public Square(String s) {
		super(new GridBagLayout());
		this.restricted = true;
		setPreferredSize(TITLE_PANEL_DIMENSION);
		validate();
		
	}
	
	/**
	 * 
	 */
	public void draw() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		if(restricted) {
			//return "X";
			setBackground(Color.DARK_GRAY);
			return;
		}
		if(occupied) {
			setBackground(Color.RED);
		}
		else {
			if(loc.isDoor()) {
				setBackground(Color.WHITE);
			}
			else {
				//return loc.getSymbol();
				setBackground(loc.getColor());
			}
		}
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
	public Location getLoc() {
		return loc;
	}
	/**
	 * Get the player currently on the sqaure
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

}