package goalkeeper;

import java.util.Date;

import midfield.Midfielder;
import soccerplayer.SoccerPlayer;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a Goalkeeper object and contains appropriate methods. 
 * <p>
 * A goalkeeper's name, date of birth, club name, country name, the number of yellow cards, the number of red cards,
 * the number of games played, the number of goals allowed, the total shots on goals, and the number of saves.
 */
public class Goalkeeper extends SoccerPlayer{
	// These attributes are private because no one else needs access to them.
	private int goalsAllowed;
	private int shotsOnGoal;
	private int numSaves;
	
	/** 
	 * Constructor method for the class
	 * @param name Initial player name
	 * @param dob Player's date of birth
	 * @param clubName Player's club name
	 * @param countryName Player's country
	 * @param numYellowCards How many yellow cards the player has
	 * @param numRedCards How many red cards the player has
	 * @param gamesPlayed How many games the player played
	 * @param goalsAllowed How many goals are allowed
	 * @param shotsOnGoal How many shots were goals
	 * @param numSaves How many saves the player made
	 */
	public Goalkeeper(String name, Date dob, String clubName, String countryName, int numYellowCards, 
			int numRedCards, int gamesPlayed, int goalsAllowed, int shotsOnGoal, int numSaves) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed);
		this.goalsAllowed = goalsAllowed;
		this.shotsOnGoal = shotsOnGoal;
		this.numSaves = numSaves;
	}
	
	/**
	 * Default constructor that triggers the default constructor of SoccerPlayer
	 */
	public Goalkeeper() {
		super();
	}
	
	/**
	 * Copy constructor for Goalkeeper. 
	 */
	public Goalkeeper(Goalkeeper copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.goalsAllowed, copy.shotsOnGoal, copy.numSaves);
	}

	/**
	 * Clone method for this class
	 */
	public Goalkeeper clone() {
		return new Goalkeeper(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the Goalkeeper class
	 */
	public int getGoalsAllowed() {
		return this.goalsAllowed;
	}
	
	public void setGoalsAllowed(int goalsAllowed) {
		this.goalsAllowed = goalsAllowed;
	}
	
	public int getShotsOnGoal() {
		return this.shotsOnGoal;
	}
	
	public void setShotsOnGoal(int shotsOnGoal) {
		this.shotsOnGoal = shotsOnGoal;
	}
	
	public int getNumSaves() {
		return this.numSaves;
	}
	
	public void setNumSaves(int numSaves) {
		this.numSaves = numSaves;
	}

	/**
	 * The toString method is used to print the information about the goalkeeper player.
	 */
	public String toString() {
		return (this.name + " is a goalkeeper.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\n"
				+ "He saved " + this.getNumSaves() + " goals, and allowed " + this.getGoalsAllowed() + " goals. His shots on goals are: " + this.getShotsOnGoal() + "\n");
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
			Goalkeeper otherTest = (Goalkeeper) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.goalsAllowed == otherTest.goalsAllowed &&
					this.shotsOnGoal == otherTest.shotsOnGoal && this.numSaves == otherTest.numSaves);
		}
	}

}
