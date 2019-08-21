package ruvindhu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import source.Dice;

/**
 * @author shiranikumarasinghe
 *
 */
public class mainGame extends JFrame implements ActionListener {
	/**
	 * List of Characters in the game
	 */
	private ArrayList<Character> Characters = new ArrayList<>();
	/**
	 * List of Players in the game
	 */
	private ArrayList<Player> Players = new ArrayList<>();

	private Board board;
	private boolean gameOver = false;
	private BufferedReader inputReader;
	private String input = "";
	private Player currentPlayer;
	private int playerCount;
	private int maxPlayers;
	private JComboBox selectingPanel;
	// int initialNumberOfPlayers;
	int total;
	static JButton submissionButton;
	private static String Submit = "Submit";

	// JTextField J;
	static JTextField inputText;
	private static String[] ChatracterName = { "Miss_Scarlett", "Colonel_Mustard", "Mrs_White", "Mr_", "Mrs_Peacock",
	"Professor_Plum" };

	private final static Dimension outerFrameDimension = new Dimension(1080, 720);
	// private final static Dimension BOARD_PANEL_DIMENSION = new Dimension
	// (1000,700);
	// private static final Dimension TITLE_PANEL_DIMENSION = new Dimension (10,10);

	/**
	 * Initialise the GUI and start the game
	 */
	public mainGame() {

		JFrame gameFrame = new JFrame("Welcome to Cluedo");
		setLayout(new BorderLayout());
		rollingDicePanel();
		final JMenuBar tableMenuBar = createTableMenuBar();
		setJMenuBar(tableMenuBar);
		setupBoard();
		setupCharacters();
		selectingPlayerScrollBar();
		setSize(outerFrameDimension);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		runGame();
	}
	
	/**
	 * Create a Menu Bar - NOT COMPLETED
	 * 
	 * @return
	 */
	private JMenuBar createTableMenuBar() {
		final JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFieldMenu());
		return tableMenuBar;
	}

	/**
	 * Create an option to load a saved file - NOT COMPLETED
	 * 
	 * @return
	 */
	private JMenu createFieldMenu() {
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem openPGN = new JMenuItem("Load Game File");

		JMenuItem item1 = new JMenuItem("Game Description");
		JMenuItem item2 = new JMenuItem("Exit");
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		openPGN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Open the file\n");

			}
		});
		fileMenu.add(openPGN);
		fileMenu.add(item1);
		fileMenu.add(item2);
		return fileMenu;
	}

	/**
	 * Create an option to select a character - NOT COMPLETED
	 * 
	 * @return
	 */
	public void selectingPlayerScrollBar() {

		JPanel panel = new JPanel();
		JLabel selectingLabel = new JLabel("Select palyer :");
		panel.add(selectingLabel);

		selectingPanel = new JComboBox(ChatracterName);
		JButton j = new JButton("Select a Player");
		selectingPanel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectingPanel.getSelectedItem();
				}
			}
		});
		j.add(selectingPanel);
		panel.add(j);
		this.add(panel, BorderLayout.EAST);
	}

	/**
	 * Create an option enter a number of players get the number when rolling dice
	 * 
	 * @return
	 */
	public void rollingDicePanel() {

		JPanel panel = new JPanel();
		JButton rollingbutton = new JButton("Roll Dice");

		rollingbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Dice d =new Dice(2);
				total = rollDice();
				System.out.println(total);
			}
		});
		JLabel rollingLabel = new JLabel("How many players, Enter a number in between 3-6 :");
		panel.add(rollingLabel);
		inputText = new JTextField(3);
		submissionButton = new JButton("Submit");
		submissionButton.setActionCommand(Submit);
		submissionButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == submissionButton) {
					String s = e.getActionCommand();
					if (s.equals("Submit")) {
						if (!checkingValidInput()) {
							new newPopUpWindow();
						}
					}
				}
			}
		});
		panel.add(inputText);
		panel.add(submissionButton);
		panel.add(rollingbutton);
		this.add(panel, BorderLayout.SOUTH);
	}

	/**
	 * Setting uo a new pop up window
	 * 
	 * @return
	 */
	public static class newPopUpWindow extends JFrame {

		public newPopUpWindow() {
			setSize(500, 200);
			setLocation(300, 300);
			JLabel lable = new JLabel("     Inavalid Input, Submit a number between in 3-6    ");
			this.add(lable);
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}

	/**
	 * Checking the input is valid 
	 * 
	 * @return
	 */
	public boolean checkingValidInput() {
		int number = parseInteger(inputText.getText());
		if (number >= 3 && number <= 6) {

			System.out.println("Valid");
			return true;
		}
		return false;
	}

	/**
	 * Setup and initialize the board
	 */
	private void setupBoard() {
		this.board = new Board();
		add(board, BorderLayout.CENTER);
		board.initialiseBoard();
		board.drawBoard();

	}

	/**
	 * Setup the characters
	 */
	private void setupCharacters() {
		/*** setting Starting Position ***/
		Characters.add(new Character("Miss_Scarlett", "1", new Position(24, 8)));
		Characters.add(new Character("Colonel_Mustard", "2", new Position(18, 0)));
		Characters.add(new Character("Mrs_White", "3", new Position(0, 8)));
		Characters.add(new Character("Mr_Green", "4", new Position(0, 16)));
		Characters.add(new Character("Mrs_Peacock", "5", new Position(7, 23)));
		Characters.add(new Character("Professor_Plum", "6", new Position(18, 23)));
	}

	/**
	 * Run the game until it is over
	 */
	private void runGame() {
		int count = 0;
		input = "";
		inputReader = new BufferedReader(new InputStreamReader(System.in));
		this.addPlayers();
		while (!gameOver) {
			try {
				this.process();
				// System.out.println("print me");
				count++;
				System.out.println(count);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (gameOver) {
			System.out.printf("Game Over. Thanks for playing\n");
		}
	}

	/**
	 * Roll the dice and play the game until it is over.
	 */
	private void process() {
		try {
			int sum = total;

			getMovementInput(total);
			// gameOver=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ask the user for the number of players in the game and add them.
	 */
	private void addPlayers() {

		boolean completed = false;

		while (!completed) {		 
			 System.out.printf("Please choose the number of Players (Min 3 and Max 6): ");
			input = inputText.getText();
			// input = inputReader.readLine();
			System.out.printf("\n");
			int n = parseInteger(input);
			if (n != -1 && (n >= 3 && n <= 6)) {
				maxPlayers = n;
				initPlayers(n);
				completed = true;
			}
		}
	}

	/**
	 * Create the list of players and place them at their starting positions
	 * 
	 * @param no. of players
	 */
	public void initPlayers(int input) {

		System.out.printf("%d players added: \n", input);
		for (int i = 0; i < input; i++) {
			Character c = Characters.get(i);
			Player p = new Player(c, c.getPosition());
			Players.add(p);
			System.out.printf("%d) %s\n", i + 1, p.getCharacterName().getName());
		}
		System.out.printf("\n");
		for (Player p : Players) {
			Position pos = p.getPos();
			board.getSquares()[pos.getY()][pos.getX()].setOccupied(p);
		}
		playerCount = 1;
		switchPlayers();
		this.board.drawBoard();
	}

	/**
	 * Get the user's input on the direction and no. of steps to move Move the
	 * player if it's possible
	 * 
	 * @param dice roll
	 */
	private void getMovementInput(int sum) {
		input = "";
		int count = sum;

		String[] buffer;
		Character character = currentPlayer.getCharacterName();
		System.out.printf("%s(%s) rolled %d on the dice. \n", character.getName(), character.getSymbol(), sum);
		while (count > 0) {
			try {
				System.out.printf("%s(%s) has %d %s remaining. Which direction do you want to take?\n",
						character.getName(), character.getSymbol(), count, count > 1 ? "moves" : "move");
				System.out.printf("[Ex: Use format 's 5' (without quotes) to move 5 steps to the south]\t: ");
				input = inputReader.readLine();
				buffer = returnBuffer(input);
				System.out.printf("\n");
				if (buffer.length == 2) {
					String dir = buffer[0];
					int steps = parseInteger(buffer[1]);
					if ((dir.equals("n") || dir.equals("s") || dir.equals("e") || dir.equals("w"))
							&& (steps > 0 && steps <= count)) {
						if (board.move(currentPlayer, steps, dir)) {
							System.out.printf("Moving %s(%s) %d steps\n\n", character.getName(), character.getSymbol(),
									steps);
							this.board.drawBoard();
							if (currentPlayer.canSuggest()) {
								makeSuggestion();
								count = 0;
								this.board.drawBoard();
							}
							count = count - steps;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		playerCount++;
		switchPlayers();
	}

	/**
	 * Prompts the user to make a valid suggestion
	 */
	private void makeSuggestion() {
		boolean completed = false;
		while (!completed) {
			System.out
			.printf("Please enter the name of the Weapon followed by the name of the Character in the format\n "
					+ "\t\t'Revolver Miss_Scarlett'(No quotes) : ");
			String buffer[];
			input = "";
			try {
				input = inputReader.readLine();
				buffer = returnBuffer(input);

				if (buffer.length == 2) {
					String weapon = buffer[0];
					String accused = buffer[1];
					System.out.printf("\n\n%s suggested that %s has committed the murder in the %s using a %s\n\n",
							currentPlayer.getCharacterName().getName(), accused,
							board.getSquares()[currentPlayer.getPos().getY()][currentPlayer.getPos().getX()].getLoc()
							.getName(),
							weapon);
					completed = true;
					;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Takes a string input and checks if it is a valid integer input
	 * 
	 * @param input
	 * @return integer
	 */
	private int parseInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * Add the player to the room
	 * 
	 * @param room
	 * @param player
	 */
	public void addToRoom(String room, Player player) {
		board.getPlayersInRoom().get(room).add(player);
	}

	/**
	 * Check if the player is inside the given room Return true if he is.
	 * 
	 * @param room
	 * @param player
	 * @return
	 */
	public boolean isInRoom(String room, Player player) {
		return board.getPlayersInRoom().get(room).contains(player);
	}

	/**
	 * Switch the player's turn.
	 */
	private void switchPlayers() {
		if (playerCount > maxPlayers) {
			playerCount = 1;
		}
		currentPlayer = Players.get(playerCount - 1);
	}

	/**
	 * Split the input an return an array of Strings
	 * 
	 * @param input string
	 * @return array
	 */
	private String[] returnBuffer(String input) {
		return input.split(" ");
	}

	/**
	 * Roll the dice and return the sum.
	 * 
	 * @return sum
	 */
	private int rollDice() {
		Dice d = new Dice(2);
		return d.roll();
	}

	/**
	 * Return the number of players in the game
	 * 
	 * @return players
	 */
	public int getPlayers() {
		return Players.size();
	}

	public static void main(String[] args) {
		new mainGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}