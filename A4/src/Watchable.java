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
 * Watchable interface, simply has one method that requires implementation.
 * @author Muher
 *
 */
public interface Watchable {
	public String isOnSameTime(Show S);
}
