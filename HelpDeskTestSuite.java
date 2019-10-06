
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
 * Runs a series of test to determine the functionality of the methods in
 * HelpDesk
 * 
 * @author Kylie Sampson
 *
 */
public class HelpDeskTestSuite extends HelpDesk {

	/**
	 * In order to test the protected methods, the test class must extend HelpDesk
	 * and therefore needs a constructor. The constructor for this class should not
	 * be used
	 * 
	 * @param arraySize - size to initialize array (should not be used)
	 */
	public HelpDeskTestSuite(int arraySize) {
		super(arraySize);
	}

	/**
	 * Calls various test methods and prints the results of the tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("testCreateSupportTicket():       " + testCreateSupportTicket());
		System.out.println("testCreateAndClose():            " + testCreateAndClose());
		System.out.println("testCreateNewWithVaryingSizes(): " + testCreateNewWithVaryingSizes());
		System.out.println("testFullAray():                  " + testFullAray());
		System.out.println("testRemoveFromEmpty():           " + testRemoveFromEmpty());
		System.out.println("testParentOf():                  " + testParentOf());
		System.out.println("testRightAndLeftChildren():      " + testRightAndLeftChildren());
		System.out.println("testSwap():                      " + testSwap());
		System.out.println("testAddNull():                   " + testAddNull());
	}

	/**
	 * Adds several new tickets and ensures that they are set in the correct
	 * position.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testCreateSupportTicket() {
		HelpDesk test1 = new HelpDesk(10);
		test1.createNewTicket("Hello my name is kylie");
		test1.createNewTicket("Hello");
		test1.createNewTicket("Hello my name is kylie and i like to code");
		test1.createNewTicket("Hello my name is kylie and i like to code more than you!");

		if (!test1.array[0].toString().equals("Hello my name is kylie and i like to code more than you!"))
			return false;
		if (!test1.array[1].toString().equals("Hello my name is kylie and i like to code"))
			return false;
		if (!test1.array[2].toString().equals("Hello my name is kylie"))
			return false;
		if (!test1.array[3].toString().equals("Hello"))
			return false;

		return true;
	}

	/**
	 * Adds and removes several tickets. Once all items are added and removed, the
	 * test ensures that the remaining elements have moved up and down to the
	 * correct location.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testCreateAndClose() {
		HelpDesk test2 = new HelpDesk(6);
		test2.createNewTicket("a");
		test2.createNewTicket("ab");
		test2.createNewTicket("abc");
		test2.createNewTicket("abcd");
		test2.createNewTicket("abca");
		test2.createNewTicket("abcde");
		test2.closeNextTicket();
		test2.createNewTicket("aaa");
		test2.closeNextTicket();

		if (!test2.array[0].toString().equals("abca"))
			return false;
		if (!test2.array[1].toString().equals("abc"))
			return false;
		if (!test2.array[2].toString().equals("aaa"))
			return false;
		if (!test2.array[3].toString().equals("a"))
			return false;
		if (!test2.array[4].toString().equals("ab"))
			return false;

		return true;
	}

	/**
	 * Test that the tickets can be sorted properly both by size and alphabetically.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testCreateNewWithVaryingSizes() {
		HelpDesk test3 = new HelpDesk(6);
		test3.createNewTicket("x");
		test3.createNewTicket("y");
		test3.createNewTicket("z");
		test3.createNewTicket("aa");
		test3.createNewTicket("bb");
		test3.createNewTicket("cc");

		if (!test3.array[0].toString().equals("cc"))
			return false;
		if (!test3.array[1].toString().equals("aa"))
			return false;
		if (!test3.array[2].toString().equals("bb"))
			return false;
		if (!test3.array[3].toString().equals("x"))
			return false;
		if (!test3.array[4].toString().equals("z"))
			return false;
		if (!test3.array[5].toString().equals("y"))
			return false;

		return true;
	}

	/**
	 * Test how the createNewTicket method will respond once the array is full.
	 * Returns an error that should be handled inside of the array
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testFullAray() {
		HelpDesk test4 = new HelpDesk(3);
		boolean exceptionCaught = false;
		try {
			test4.createNewTicket("Hello");
			test4.createNewTicket("Hello my");
			test4.createNewTicket("Hello my name is");
			test4.createNewTicket("Hello my name is Kylie");
		} catch (Exception e) {
			exceptionCaught = true;
		} finally {
			if (!exceptionCaught) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Test calling the closeNextTicket on an empty array. This should return an
	 * error which is handled inside of the test.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testRemoveFromEmpty() {
		HelpDesk test5 = new HelpDesk(5);
		test5.createNewTicket("Dog");
		test5.createNewTicket("Cat");
		test5.createNewTicket("Pig");
		test5.createNewTicket("Mouse");
		test5.createNewTicket("Horse");

		if (!test5.closeNextTicket().equals("Mouse"))
			return false;
		if (!test5.closeNextTicket().equals("Horse"))
			return false;
		if (!test5.closeNextTicket().equals("Pig"))
			return false;
		if (!test5.closeNextTicket().equals("Dog"))
			return false; // TODO error here
		if (!test5.closeNextTicket().equals("Cat"))
			return false;

		try {
			test5.closeNextTicket();
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	/**
	 * Test parentOf when it passes in several ints to test and ensures that they
	 * return the correct parent index.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testParentOf() {
		// 0
		// 12
		// 3456
		if (HelpDesk.parentOf(3) != 1)
			return false;
		if (HelpDesk.parentOf(4) != 1)
			return false;
		if (HelpDesk.parentOf(5) != 2)
			return false;
		if (HelpDesk.parentOf(6) != 2)
			return false;
		if (HelpDesk.parentOf(1) != 0)
			return false;
		if (HelpDesk.parentOf(2) != 0)
			return false;
		return true;
	}

	/**
	 * Test rightChildOf and leftChildOf by passing in several ints to test and
	 * ensuring that they return the correct child index.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testRightAndLeftChildren() {
		// 0
		// 12
		// 3456
		if (HelpDesk.leftChildOf(0) != 1)
			return false;
		if (HelpDesk.rightChildOf(0) != 2)
			return false;
		if (HelpDesk.leftChildOf(1) != 3)
			return false;
		if (HelpDesk.rightChildOf(1) != 4)
			return false;
		if (HelpDesk.leftChildOf(2) != 5)
			return false;
		if (HelpDesk.rightChildOf(2) != 6)
			return false;
		return true;
	}

	/**
	 * Tests the functionality of the swap method. Should simply switch the index of
	 * the two given SupportTickets.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testSwap() {
		HelpDesk test8 = new HelpDesk(5);
		test8.createNewTicket("Root");
		test8.createNewTicket("Roo");
		test8.createNewTicket("Ro");

		// Root
		// Roo, Ro
		if (!test8.array[0].toString().equals("Root"))
			return false;
		if (!test8.array[1].toString().equals("Roo"))
			return false;
		if (!test8.array[2].toString().equals("Ro"))
			return false;

		test8.swap(0, 1);
		// Roo
		// Root, Ro
		if (!test8.array[0].toString().equals("Roo"))
			return false;
		if (!test8.array[1].toString().equals("Root"))
			return false;
		if (!test8.array[2].toString().equals("Ro"))
			return false;

		test8.swap(1, 2);
		// Roo
		// Ro, Root
		if (!test8.array[0].toString().equals("Roo"))
			return false;
		if (!test8.array[1].toString().equals("Ro"))
			return false;
		if (!test8.array[2].toString().equals("Root"))
			return false;
		return true;
	}

	/**
	 * Test how the program will respond to passing in null instead of a String.
	 * This call should trigger an exception, which is handled within the test.
	 * 
	 * @return true if test is passed, false otherwise
	 */
	private static boolean testAddNull() {
		HelpDesk test9 = new HelpDesk(3);
		try {
			test9.createNewTicket(null);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}
