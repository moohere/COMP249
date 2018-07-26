package back;

import java.util.Date;

import soccerplayer.SoccerPlayer;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a CentreBack object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, the number of games played, the number of tackles, and the number of shots blocked.
 */
public class CentreBack extends Defender{
	// Since this attribute is only used by this class, it doesn't need to be more visible.
	private int shotsBlocked;

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
	 * @param shotsBlocked How many shots were blocked
	 */
	public CentreBack(String name, Date dob, String clubName, String countryName, int numYellowCards, int numRedCards,
			int gamesPlayed, double numTackles, int shotsBlocked) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed, numTackles);
		this.shotsBlocked = shotsBlocked;
	}

	/**
	 * Default constructor that triggers the default constructor of Defender
	 */
	public CentreBack() {
		super();
	}
	
	/**
	 * Copy constructor for CentreBack. 
	 */
	public CentreBack(CentreBack copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.numTackles, copy.shotsBlocked);
	}
	
	/**
	 * Clone method for this class
	 */
	public CentreBack clone() {
		return new CentreBack(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the CentreBack class
	 */
	public int getShotsBlocked() {
		return shotsBlocked;
	}

	public void setShotsBlocked(int shotsBlocked) {
		this.shotsBlocked = shotsBlocked;
	}

	/**
	 * The toString method is used to print the information about the CentreBack.
	 */
	public String toString() {
		return (this.name + " is a centreback player.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\n"
						+ "He tackled " + this.getNumTackles() + " times and blocked " + this.getShotsBlocked() + " times.\n");
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
			CentreBack otherTest = (CentreBack) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.numTackles == otherTest.numTackles &&
					this.shotsBlocked == otherTest.shotsBlocked);
		}
	}
}
