package back;

import java.util.Date;

import midfield.Midfielder;
import soccerplayer.SoccerPlayer;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a Defender object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, the number of games played, and the number of tackles.
 */
public class Defender extends SoccerPlayer{
	// Since this attribute is only used by the subclasses in the same package, it is set to default.
	double numTackles;
	
	/** 
	 * Constructor method for the class
	 * @param name Initial player name
	 * @param dob Player's date of birth
	 * @param clubName Player's club name
	 * @param countryName Player's country
	 * @param numYellowCards How many yellow cards the player has
	 * @param numRedCards How many red cards the player has
	 * @param gamesPlayed How many games the player played
	 * @param numTackles How many tackles the player made
	 */
	public Defender(String name, Date dob, String clubName, String countryName, int numYellowCards, int numRedCards,
			int gamesPlayed, double numTackles) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed);
		this.numTackles = numTackles;
	}

	/**
	 * Default constructor that triggers the default constructor of SoccerPlayer
	 */
	public Defender() {
		super();
	}
	
	/**
	 * Copy constructor for Defender. 
	 */
	public Defender(Defender copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.numTackles);
	}
	
	/**
	 * Clone method for this class
	 */
	public Defender clone() {
		return new Defender(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the Defender class
	 */
	public double getNumTackles() {
		return this.numTackles;
	}
	
	public void setNumTackles(double numTackles) {
		this.numTackles = numTackles;
	}

	/**
	 * The toString method is used to print the information about the Defender.
	 */
	public String toString() {
		return (this.name + " is a defender.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\nHe tackled " + this.getNumTackles() + " times.\n");
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
			Defender otherTest = (Defender) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.numTackles == otherTest.numTackles);
		}
	}

}
