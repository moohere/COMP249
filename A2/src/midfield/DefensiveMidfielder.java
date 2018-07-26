package midfield;

import java.util.Date;

import soccerplayer.SoccerPlayer;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a DefensiveMidfielder object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, the number of games played, the number of attacks stopped, and the number of intercepts.
 */
public class DefensiveMidfielder extends Midfielder{
	// Since this attribute is only used by this class, it doesn't need to be more visible.
	private int intercepts;

	/** 
	 * Constructor method for the class
	 * @param name Initial player name
	 * @param dob Player's date of birth
	 * @param clubName Player's club name
	 * @param countryName Player's country
	 * @param numYellowCards How many yellow cards the player has
	 * @param numRedCards How many red cards the player has
	 * @param gamesPlayed How many games the player played
	 * @param attacksStopped How many attacks were stopped by the player
	 * @param intercepts How many intercepts were made by the player
	 */
	public DefensiveMidfielder(String name, Date dob, String clubName, String countryName, int numYellowCards,
			int numRedCards, int gamesPlayed, int attacksStopped, int intercepts) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed, attacksStopped);
		this.intercepts = intercepts;
	}
	
	/**
	 * Default constructor that triggers the default constructor of Midfielder.
	 */
	public DefensiveMidfielder() {
		super();
	}
	
	/**
	 * Copy constructor for DefensiveMidfielder. 
	 */
	public DefensiveMidfielder(DefensiveMidfielder copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.attacksStopped, copy.intercepts);
	}
	
	/**
	 * Clone method for this class
	 */
	public DefensiveMidfielder clone() {
		return new DefensiveMidfielder(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the DefensiveMidfielder class
	 */
	public int getIntercepts() {
		return intercepts;
	}

	public void setIntercepts(int intercepts) {
		this.intercepts = intercepts;
	}
	
	/**
	 * The toString method is used to print the information about the DefensiveMidfielder.
	 */
	public String toString() {
		return (this.name + " is a defensive midfielder.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\n"
						+ "He stopped " + this.getAttacksStopped() + " attacks and intercepted " + this.getIntercepts() + " times.\n");
	}
	
	/**
	 * The equals method is used to check if the object passed is equal to this object.
	 */
	public boolean equals(Object other) {
		// This verifies if the other object is null, or if it's of the same class or not. 
		// We could use instanceof instead if we want to compare subclasses as well.
		if(other == null || other.getClass() != this.getClass())
			return false;
		else {
			DefensiveMidfielder otherTest = (DefensiveMidfielder) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.attacksStopped == otherTest.attacksStopped &&
					this.intercepts == otherTest.intercepts);
		}
	}
}
