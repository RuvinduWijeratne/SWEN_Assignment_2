package source;


import java.util.Random;

public class Dice {

	private int numberOfDice;

	/**
	 * Create a dice object
	 * @param no. of dice
	 */
	public Dice(int n) {	
		this.numberOfDice = n;
	}

	/**
	 * Roll the dice and return the sum
	 * @return
	 */
	public int roll() {
		int total = 0;
		for(int i=0; i <= numberOfDice ;i++ ) {
			Random value = new Random();
			int first = value.nextInt(6)+1;
			int SecondValue = value.nextInt(6)+1;
			total = first+SecondValue;
		}
		return total;
	}

}
