package forward;

import java.util.Date;

import soccerplayer.SoccerPlayer;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a CentreForward object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, the number of red cards, the number 
 * of games played, the number of goals scored, the number of assists, the number of shots on target, and the number of long balls received.
 */
public class CentreForward extends Forward{
	// Since this attribute is only used by this class, it doesn't need to be more visible.
	private int longBallsReceived;

	/** 
	 * Constructor method for the class
	 * @param name Initial player name
	 * @param dob Player's date of birth
	 * @param clubName Player's club name
	 * @param countryName Player's country
	 * @param numYellowCards How many yellow cards the player has
	 * @param numRedCards How many red cards the player has
	 * @param gamesPlayed How many games the player played
	 * @param goalsScored How many goals were scored by the player 
	 * @param numAssists How many assists were made by the player
	 * @param shotsOnTarget How many shots were on target
	 * @param longBallsReceived How many long balls were received by the player
	 */
	public CentreForward(String name, Date dob, String clubName, String countryName, int numYellowCards,
			int numRedCards, int gamesPlayed, int goalsScored, int numAssists, int shotsOnTarget, int longBallsReceived) {
		super(name, dob, clubName, countryName, numYellowCards, numRedCards, gamesPlayed, goalsScored, numAssists,
				shotsOnTarget);
		this.longBallsReceived = longBallsReceived;
	}

	/**
	 * Default constructor that triggers the default constructor of Forward
	 */
	public CentreForward() {
		super();
	}
	
	/**
	 * Copy constructor for CentreForward. 
	 */
	public CentreForward(CentreForward copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, 
				copy.numRedCards, copy.gamesPlayed, copy.goalsScored, copy.numAssists, copy.shotsOnTarget, copy.longBallsReceived);
	}
	
	/**
	 * Clone method for this class
	 */
	public CentreForward clone() {
		return new CentreForward(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the Winger class
	 */
	public int getLongBallsReceived() {
		return longBallsReceived;
	}

	public void setLongBallsReceived(int longBallsReceived) {
		this.longBallsReceived = longBallsReceived;
	}
	
	/**
	 * The toString method is used to print the information about the CentreForward player.
	 */
	public String toString() {
		return (this.name + " is a centre forward player.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\n"
				+ "He scored " + this.getGoalsScored() + " goals and has " + this.getNumAssists() + " assists.\nHe got " +
				this.getShotsOnTarget() + " shots on target and received " + this.getLongBallsReceived() + " long balls.\n");
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
			CentreForward otherTest = (CentreForward) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed && this.goalsScored == otherTest.goalsScored &&
					this.numAssists == otherTest.numAssists && this.shotsOnTarget == otherTest.shotsOnTarget && this.longBallsReceived == otherTest.longBallsReceived);
		}
	}

}
