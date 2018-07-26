package soccerplayer;

import java.time.LocalDate;
import java.util.Date;

/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #2 <p>
 * Due 25/07/18 <p>
 * Creates a SoccerPlayer object and contains appropriate methods. 
 * <p>
 * A soccer player name, date of birth, club name, country name, the number of yellow cards, 
 * the number of red cards, and the number of games played. 
 */
public class SoccerPlayer {
	// These attributes cannot be more restrictive since all the subclasses are in different packages. 
	protected String name;
	protected Date dob;
	protected String clubName;
	protected String countryName;
	protected int numYellowCards;
	protected int numRedCards;
	protected int gamesPlayed;
	
	/** 
	 * Constructor method for the class
	 * @param name Initial player name
	 * @param dob Player's date of birth
	 * @param clubName Player's club name
	 * @param countryName Player's country
	 * @param numYellowCards How many yellow cards the player has
	 * @param numRedCards How many red cards the player has
	 * @param gamesPlayed How many games the player played
	 */
	public SoccerPlayer(String name, Date dob, String clubName, String countryName, int numYellowCards, 
			int numRedCards, int gamesPlayed) {
		super();
		this.name = name;
		this.dob = dob;
		this.clubName = clubName;
		this.countryName = countryName;
		this.numYellowCards = numYellowCards;
		this.numRedCards = numRedCards;
		this.gamesPlayed = gamesPlayed;
	}
	
	/**
	 * Default constructor for SoccerPlayer class. Everything initialized to 0/null.
	 */
	public SoccerPlayer() {
		super();
		this.name = null;
		this.dob = null;
		this.clubName = null;
		this.countryName = null;
		this.numYellowCards = 0;
		this.numRedCards = 0;
		this.gamesPlayed = 0;
	}
	
	/**
	 * Copy constructor for SoccerPlayer class. The object is created with the attribute values
	 * of the copy object. 
	 */
	public SoccerPlayer(SoccerPlayer copy) {
		this(copy.name, copy.dob, copy.clubName, copy.countryName, copy.numYellowCards, copy.numRedCards, copy.gamesPlayed);
	}
	
	/**
	 * Clone method for this class
	 */
	public SoccerPlayer clone() {
		return new SoccerPlayer(this);
	}
	
	/**
	 * Getters and Setters for all the attributes for the SoccerPlayer class
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return this.dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getClubName() {
		return this.clubName;
	}
	
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	public String getCountryName() {
		return this.countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getNumYellowCards() {
		return this.numYellowCards;
	}
	
	public void setNumYellowCards(int numYellowCards) {
		this.numYellowCards = numYellowCards;
	}
	
	public int getNumRedCards() {
		return this.numRedCards;
	}
	
	public void setNumRedCards(int numRedCards) {
		this.numRedCards = numRedCards;
	}

	public int getGamesPlayed() {
		return this.gamesPlayed;
	}
	
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * The toString method is used to print the information about the soccer player.
	 */
	public String toString() {
		return (this.name + " is a soccer player.\nHe is from " + this.getCountryName()+ " and plays for " + this.getClubName()+" club.\n"
				+ this.name + " is born on " + this.dob + ".\nHis total games played is: " + this.getGamesPlayed() + ".\nHe has " 
				+ this.getNumYellowCards() + " yellow cards; " + this.getNumRedCards() + " red cards.\n");
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
			SoccerPlayer otherTest = (SoccerPlayer) other;
			return (this.name.equals(otherTest.name) && this.dob == otherTest.dob && this.clubName.equals(otherTest.clubName) &&
					this.countryName.equals(otherTest.countryName) && this.numYellowCards == otherTest.numYellowCards &&
					this.numRedCards == otherTest.numRedCards && this.gamesPlayed == otherTest.gamesPlayed);
		}
	}

}
