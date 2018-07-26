package midfield;

import soccerplayer.SoccerPlayer;
import java.util.Date;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a Midfielder object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, the number of games played, and the number of attacks stopped.
 */
public class Midfielder extends SoccerPlayer{
	// This attribute is default since only subclasses in the same package needs it.
	int attacksStopped;
	
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
	 */
	public Midfielder(String name, Date dob, String clubName, String countryName, int numYellowCards, int numRedCards,
			int gamesPlayed, int attacksStopped) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed);
		this.attacksStopped = attacksStopped;
	}
	
	/**
	 * Default constructor that triggers the default constructor of SoccerPlayer
	 */
	public Midfielder() {
		super();
	}
	
	/**
	 * Copy constructor for Midfielder. 
	 */
	public Midfielder(Midfielder copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.attacksStopped);
	}
	
	/**
	 * Getters and Setters for all the attributes for the Midfielder class
	 */
	public int getAttacksStopped() {
		return this.attacksStopped;
	}
	
	public void setAttacksStopped(int attacksStopped) {
		this.attacksStopped = attacksStopped;
	}

	/**
	 * Clone method for this class
	 */
	public Midfielder clone() {
		return new Midfielder(this);
	}
	
	/**
	 * The toString method is used to print the information about the Midfielder.
	 */
	public String toString() {
		return (this.name + " is a midfielder.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\nHe stopped " + this.getAttacksStopped() + " attacks.\n");
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
			Midfielder otherTest = (Midfielder) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.attacksStopped == otherTest.attacksStopped);
		}
	}

}
