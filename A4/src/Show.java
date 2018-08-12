// -----------------------------------------------------
// Assignment 4
// Written by: Muherthan Thalayasingam - 27223064
// ----------------------------------------------------- 
/** 
 * @author Muherthan Thalayasingam - 27223064
 * <p>
 * COMP249 <p>
 * Assignment #4 <p>
 * Due 11/08/18 <p>
 * This program lets the user find out whether or not they can watch a show based on their current watchlist and their interests.
 * This program makes uses of I/O to read the watchlist/interest, and uses a linked-list to keep track of the different shows and time slots.
 * <p>
 */

/**
 * Class that implements Watchable interface. It is used to store show information which is used in nodes.
 * @author Muher
 * Contains two string values which make up the showID and showName as well as two double values which make up the start and end time of each show
 */
public class Show implements Watchable{
	String showID;
	String showName;
	double startTime;
	double endTime;
	
	/**
	 * Constructor with parameters used to assign
	 * @param showID String to set a showID
	 * @param showName String to set showName
	 * @param startTime double to set the startTime
	 * @param endTime double to set the endTime
	 */
	public Show(String showID, String showName, double startTime, double endTime) {
		this.showID = showID;
		this.showName = showName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Copy constructor that copies another Show object, but is given a unique showID
	 * @param other Show object used for copying
	 * @param showID a string for a unique showID
	 */
	public Show(Show other, String showID) {
		this.showID = showID;
		this.showName = other.showName;
		this.startTime = other.startTime;
		this.endTime = other.endTime;
	}	
	
	/**
	 * Clone method
	 * @param showID string for unique showID
	 * @return a cloned Show object
	 */
	public Show clone(String showID) {
		return new Show(showID, this.showName, this.startTime, this.endTime);
	}
	
	/**
	 * Method used to print a custom message for the class
	 */
	public String toString() {
		return showID + "_" + showName + "\nStart Time: " + startTime + "\nEnd Time: " + endTime;
	}
	
	/**
	 * Method used to test for equality
	 * @param other Show object used for comparison
	 * @return boolean based on whether they are the same or not
	 */
	public boolean equals(Show other) {
		return this.showName == other.showName && this.startTime == other.startTime && this.endTime == other.endTime;
	}
	
	/**
	 * Accesors and mutators
	 * @return varies
	 */
	public String getShowID() {
		return showID;
	}
	public void setShowID(String showID) {
		this.showID = showID;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getEndTime() {
		return endTime;
	}
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Method that was implemented through interface. Checks if two shows overlap, are played in the same time, or are different time slots.
	 */
	@Override
	public String isOnSameTime(Show S) {
		if (this.startTime == S.startTime && this.endTime == S.endTime)
			return "Same time";
		else if(this.startTime >= S.startTime && this.endTime <= S.endTime)
			return "Some overlap";
		else
			return "Different time";
	}
	
}
