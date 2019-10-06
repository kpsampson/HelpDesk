
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P10 Help Desk
// Files:           SupportTicket.java, HelpDeskInterface.java, HelpDesk.java, 
//					HelpDeskTestSuite.java
// Course:          006, Spring, 2019
//
// Author:          Kylie Sampson
// Email:           kpsampson@wisc.edu 
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem 
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   NONE
// Partner Lecturer's Name: NONE
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This interface exposes the functionality of the HelpDesk class for CS300's
 * P10 assignment. In addition to public methods, there are also comments
 * describing protected methods that must be defined within any implementation
 * of this interface. The only fields that may be defined in such
 * implementations include: a SupportTicket[] array, and an int size.
 * 
 * @author CS300 Course Staff
 */
public interface HelpDeskInterface {

	/**
	 * Creates and adds a new SupportTicket to this HelpDesk.
	 * 
	 * @param message names the client and describes their need for support.
	 * @throws NullPointerException      when the String message argument is null.
	 * @throws IndexOutOfBoundsException when called on HelpDesk with a full array
	 */
	public void createNewTicket(String message);

	/**
	 * Returns the message within this HelpDesk that has the highest priority. This
	 * method does not change the state of this HelpDesk.
	 * 
	 * @return the message within the highest priority SupportTicket.
	 * @throws IllegalStateException when called on a HelpDesk with zero
	 *                               SupportTickets.
	 */
	public String checkNextTicket();

	/**
	 * Returns and removes the message within this HelpDesk that has the highest
	 * priority.
	 * 
	 * @return the message within the highest priority SupportTicket (prior to its
	 *         removal).
	 * @throws IllegalStateException when called on a HelpDesk with zero
	 *                               SupportTickets.
	 */
	public String closeNextTicket();

}