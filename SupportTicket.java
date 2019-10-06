
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
 * Models a ticket in the HelpDesk
 * 
 * @author Kylie Sampson
 *
 */
public class SupportTicket implements Comparable<SupportTicket> {
	private String input;

	/**
	 * Constructor for SupportTicket. Initializes the instance variable input. If
	 * the input is null, an exception is thrown.
	 * 
	 * @param input - string to initialize instance field input
	 * @throws NullPointerException
	 */
	public SupportTicket(String input) throws NullPointerException {
		if (input == null) { // If input is null throws exception
			throw new NullPointerException("Please enter a valid string.");
		}
		this.input = input;
	}

	/**
	 * This method compares the length of two strings and returns which one is
	 * larger. If the two strings have an equal length, the contents of the string
	 * are compared.
	 * 
	 * @param arg0 is the supportTicket being compared
	 * @return 1 - input is less, -1 input is greater
	 */
	@Override
	public int compareTo(SupportTicket arg0) {
		if (input.length() < arg0.toString().length()) // arg0 greater size
			return 1;
		if (input.length() > arg0.toString().length()) // args0 less
			return -1;
		if (input.length() == arg0.toString().length()) {
			return (arg0.toString()).compareTo(this.input); // greater or less,
		}
		return 0;
	}

	/**
	 * This method returns the string stored in the instance variable. This string
	 * represents the name of the supportTicket
	 * 
	 * @return this.input - instance variable name
	 */
	@Override
	public String toString() {
		return this.input;
	}
}
