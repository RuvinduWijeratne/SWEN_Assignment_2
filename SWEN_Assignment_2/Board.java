package ruvindhu;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Board extends JPanel {
	private Square[][] squares;
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension (600,400);
	
	/**
	 * List of Players in each room
	 */
	private Map<String,ArrayList<Player>> playersInRoom = 
			new HashMap <String,ArrayList<Player>>() {
		{
		put("K",new ArrayList<Player>());
		put("B",new ArrayList<Player>());
		put("C",new ArrayList<Player>());
		put("D",new ArrayList<Player>());
		put("I",new ArrayList<Player>());
		put("Y",new ArrayList<Player>());
		put("L",new ArrayList<Player>());
		put("H",new ArrayList<Player>());
		put("S",new ArrayList<Player>());
		}
	};
	
	/**
	 * Setup the BoardPanel
	 */
	public Board(){
		super(new GridLayout(25,24));
		setPreferredSize(BOARD_PANEL_DIMENSION);
	}

	/**
	 * Initialize the board and all its rooms and paths
	 */
	public void initialiseBoard() {
		squares = new Square [25][24];
		
		/*** KITCHEN ***/
		for(int row=0; row<6; row++) {
			for(int col=0; col<6; col++) {
				squares[row][col] = new Square(new Room("Kitchen","K",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Kitchen Door
		squares[5][4].getLoc().setDoor();

		/*** DINING ***/
		for(int row=8; row<16; row++) {
			for(int col=0; col<6; col++) {
				squares[row][col] = new Square(new Room("Dining","D",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Dining Door 1
		squares[15][4].getLoc().setDoor();
		//Dining Door 2
		squares[11][5].getLoc().setDoor();

		/*** LOUNGE **/
		for(int row=19; row<25; row++) {
			for(int col=0; col<6; col++) {
				squares[row][col] = new Square(new Room("Lounge","L",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Lounge Door
		squares[19][5].getLoc().setDoor();

		/*** BALL ***/
		for(int row=0; row<6; row++) {
			for(int col=9; col<15; col++) {
				squares[row][col] = new Square(new Room("Ball","B",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Ball Door 1
		squares[4][9].getLoc().setDoor();
		//Ball Door 2
		squares[5][11].getLoc().setDoor();
		//Ball Door 3
		squares[5][13].getLoc().setDoor();
		//Ball Door 4
		squares[3][14].getLoc().setDoor();

		/*** HALL ***/
		for(int row=19; row<25; row++) {
			for(int col=9; col<15; col++) {
				squares[row][col] = new Square(new Room("Hall","H",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Hall Door 1
		squares[19][11].getLoc().setDoor();
		//Hall Door 2
		squares[19][12].getLoc().setDoor();


		/*** Conservatory ***/
		for(int row=0; row<6; row++) {
			for(int col=18; col<24; col++) {
				squares[row][col] = new Square(new Room("Conservatory","C",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Conservatory Door 1
		squares[5][18].getLoc().setDoor();

		/*** Billiard ***/
		for(int row=8; row<12; row++) {
			for(int col=18; col<24; col++) {
				squares[row][col] = new Square(new Room("Billiard","I",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Billiard Door 1
		squares[9][18].getLoc().setDoor();

		/*** Library ***/
		for(int row=14; row<17; row++) {
			for(int col=18; col<24; col++) {
				squares[row][col] = new Square(new Room("Library","Y",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Library Door 1
		squares[15][18].getLoc().setDoor();

		/*** Study Room ***/
		for(int row=19; row<25; row++) {
			for(int col=18; col<24; col++) {
				squares[row][col] = new Square(new Room("Study","S",new Position(row,col)));
				//this.add(squares[row][col]);
			}
		}
		//Study Door 1
		squares[21][18].getLoc().setDoor();
		
		/** RESTRICTED AREA ***/
		for(int row=9; row<15; row++) {
			for(int col=10; col<14; col++) {
				squares[row][col] = new Square("restricted");
				//this.add(squares[row][col]);
			}
		}
	
		/*** Paths ***/
		for(int row=0; row<squares.length; row++) {
			for(int col=0; col<squares[0].length; col++) {
				Square s = squares[row][col];
				if(s==null) {
					squares[row][col] = new Square(new Path("Path",".",new Position(row,col)));
					//this.add(squares[row][col]);
				}
			}
		}	
	}
	
	/**
	 * Draw the squares on the board in a GUI.
	 */
	public void drawBoard() {
		for(int row=0; row<squares.length; row++) {
			for(int col = 0; col<squares[0].length; col++) {
				this.add(squares[row][col]);
				squares[row][col].draw();
			}
		}
	}
	
	/**
	 * Return the board
	 * @return
	 */
	public Board getBoard() {
		return this;
	}
	
	/**
	 * Return the squares in the board
	 * @return
	 */
	public Square[][] getSquares() {
		return this.squares;
	}
	
	/**
	 * Move the player X number of steps in the given the direction.
	 * Check validity of each step before moving.
	 * Return true, if successful
	 * @param player
	 * @param steps
	 * @param direction
	 * @return 
	 */
	public boolean move(Player player, int steps,String direction) {
		String dirToMove = direction;
		Position startingPos = player.getPos(); 
		Position currentPos = null; 
		Position nextPos = null;	
		
		if(steps<=0) {
			System.out.println("Please enter a valid number of steps\n");
			return false; 
		}
		
		currentPos = player.getPos(); 
		for(int i=1;i<=steps; i++) {
			nextPos = isValidMove(player,currentPos, dirToMove); 
			if(nextPos==null) {
				return false; 
			}
			currentPos = nextPos;
		}
		
		//If it reaches this stage, then the path from start to finish is free. So move.
		this.getSquares()[startingPos.getY()][startingPos.getX()].notOccupied(player);
		player.setPos(currentPos);
		this.getSquares()[currentPos.getY()][currentPos.getX()].setOccupied(player);
		return true;
	}
		
	/**
	 * Check if the next move is valid. 
	 * Return the next position if it is valid. Null if it isn't.
	 * @param player
	 * @param currentPos
	 * @param direction
	 * @return
	 */
	public Position isValidMove(Player player,Position currentPos,String direction) {
		Position newPos = null;
		if(direction.equalsIgnoreCase("N")) 
		{	newPos = new Position((currentPos.getY()-1),currentPos.getX());
		} else if(direction.equalsIgnoreCase("S")) {
			newPos = new Position((currentPos.getY()+1),currentPos.getX());
		} else if(direction.equalsIgnoreCase("E")) {
			newPos = new Position((currentPos.getY()),currentPos.getX()+1);
		} else if(direction.equalsIgnoreCase("W")) {
			newPos = new Position((currentPos.getY()),currentPos.getX()-1);
		}
		
		if(newPos.getX()<0 || newPos.getX()>=24 || newPos.getY()<0 || newPos.getY()>=25) {
			System.out.println("Cannot move any further in that direction\n");
			return null;
		}
		
		Square s = this.getSquares()[newPos.getY()][newPos.getX()];
		if(s.isOccupied()) {
			System.out.printf("Cell occupied by %s. Cannot pass through.\n\n",s.getPlayer().getCharacterName().getName());
			return null;
		}
		if(s.isRestricted()) {
			System.out.printf("Restricted Area. Cannot pass through.\n\n");
			return null;
		}
		if(!s.getLoc().getName().equals("Path")) {
			//If it is a door, enter and keep the player in the room
			if(s.getLoc().isDoor()) {
				addToRoom(s.getLoc().getSymbol(),player);
				player.timeToSuggest(true);
				System.out.printf("%s has entered the %s\n\n",player.getCharacterName().getName(),s.getLoc().getName());
			}
			//If it is not a door
			//	i) The player is already in the room OR
			//	ii)The player is outside and trying to enter through the wall
			//So if the player is not in the room already, don't let him enter.
			else if(!isInRoom(s.getLoc().getSymbol(),player)) {
				System.out.printf("Cannot enter the %s. No door is present\n\n",s.getLoc().getName());
				return null;
			}
		}
		
		return newPos;
	}
	/**
	 * Add the player to the room
	 * @param room
	 * @param player
	 */
	public void addToRoom(String room, Player player) {
		playersInRoom.get(room).add(player);
	}
	
	/**
	 * Check if the player is inside the given room
	 * Return true if he is.
	 * @param room
	 * @param player
	 * @return
	 */
	public boolean isInRoom(String room, Player player) {
		return playersInRoom.get(room).contains(player);
	}
	
	/**
	 * Get the players inside a given room
	 * @return 
	 */
	public Map<String, ArrayList<Player>> getPlayersInRoom() {
		return playersInRoom;
	}

	/**
	 * Place the given the players inside the room
	 * @param playersInRoom
	 */
	public void setPlayersInRoom(Map<String, ArrayList<Player>> playersInRoom) {
		this.playersInRoom = playersInRoom;
	}
	
}