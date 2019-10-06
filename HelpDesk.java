
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
 * Models a help desk using a priority max heap with supportTickets
 * 
 * @author Kylie Sampson
 *
 */
public class HelpDesk implements HelpDeskInterface {
	protected SupportTicket[] array; // zero-indexed max-heap
	protected int size;

	/**
	 * Constructor for helpDesk. Initiates the size of the array.
	 * 
	 * @param arraySize - size to initialize array to
	 */
	public HelpDesk(int arraySize) {
		array = new SupportTicket[arraySize];
	}

	/**
	 * Given an index into the heap array, this method returns that index's parent
	 * index.
	 * 
	 * @param index - index to find the parent of
	 * @return the index of the parent
	 */
	protected static int parentOf(int index) {
		int parent = (index - 1) / 2;
		return parent;
	}

	/**
	 * Given an index into the heap array, this method returns that index's left
	 * child index.
	 * 
	 * @param index - value to find child of
	 * @return the index of the leftChild
	 */
	protected static int leftChildOf(int index) {
		int leftChild = (index * 2) + 1;
		return leftChild;
	}

	/**
	 * Given an index into the heap array, this method returns that index's right
	 * child index.
	 * 
	 * @param index - index of the desired right child
	 * @return the index of the right child
	 */
	protected static int rightChildOf(int index) {
		int rightChild = (index * 2) + 2;
		return rightChild;
	}

	/**
	 * Given two indexes into the heap array, this method swaps the SupportTickets
	 * at those indexes.
	 * 
	 * @param indexA - item to swap with indexB
	 * @param indexB - item to swap with indexA
	 */
	protected void swap(int indexA, int indexB) {
		SupportTicket hold = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = hold;
	}

	/**
	 * Given an index into the heap array, this method recursively swaps any
	 * SupportTickets necessary to enforce the heap's order property between this
	 * index and the heap's root.
	 * 
	 * @param index - index to move up in the max heap
	 */
	protected void propagateUp(int index) {
		int moveTo = parentOf(index);
		if (array[index].compareTo(array[moveTo]) < 0) { // index is greater than parent
			swap(index, moveTo);
			propagateUp(moveTo);
		}
	}

	/**
	 * Given an index into the heap array, this method recursively swaps any
	 * SupportTickets necessary to enforce the heap's order property between this
	 * index and it's children.
	 * 
	 * @param index - the index to be moved lower in the tree
	 */
	protected void propagateDown(int index) {
		int swap = 0;
		if (rightChildOf(index) < size && array[rightChildOf(index)] != null) { // If there is a right child there is a
																				// left child as well
			if (array[rightChildOf(index)].compareTo(array[leftChildOf(index)]) < 0) { // Checks for bigger
				if (array[rightChildOf(index)].compareTo(array[index]) < 0) {
					swap = rightChildOf(index); // index to be swapped if right is greater
				}
			} else {
				if (array[leftChildOf(index)].compareTo(array[index]) < 0) { // if left is greater
					swap = leftChildOf(index);
				}
			}
		} else if (leftChildOf(index) < size && array[leftChildOf(index)] != null) {
			if (array[leftChildOf(index)].compareTo(array[index]) > 1) {
				swap = leftChildOf(index);
			}
		}
		if (swap != 0) { // Swaps swap with the assigned value
			swap(index, swap);
			propagateDown(swap);
		}
	}

	/**
	 * Creates and adds a new SupportTicket to this HelpDesk.
	 * 
	 * @param message names the client and describes their need for support.
	 * @throws NullPointerException      when the String message argument is null.
	 * @throws IndexOutOfBoundsException when called on HelpDesk with a full array
	 */
	public void createNewTicket(String message) throws IndexOutOfBoundsException, NullPointerException {
		if (array[array.length - 1] != null)
			throw new IndexOutOfBoundsException("Array is full");
		if (message == null)
			throw new NullPointerException("Message contents cannot be null");
		SupportTicket newTicket = new SupportTicket(message);
		array[size] = newTicket; // adds new ticket to the end
		propagateUp(size); // Calls the index to move up
		size++;
	}

	/**
	 * Returns the message within this HelpDesk that has the highest priority. This
	 * method does not change the state of this HelpDesk.
	 * 
	 * @return the message within the highest priority SupportTicket.
	 * @throws IllegalStateException when called on a HelpDesk with zero
	 *                               SupportTickets.
	 */
	public String checkNextTicket() throws IllegalStateException {
		if (array.length == 0)
			throw new IllegalStateException("HelpDesk has 0 supportTickets");
		return array[0].toString();
	}

	/**
	 * Returns and removes the message within this HelpDesk that has the highest
	 * priority.
	 * 
	 * @return the message within the highest priority SupportTicket (prior to its
	 *         removal).
	 * @throws IllegalStateException when called on a HelpDesk with zero
	 *                               SupportTickets.
	 */
	public String closeNextTicket() throws IllegalStateException {
		if (array.length == 0)
			throw new IllegalStateException("HelpDesk has 0 supportTickets");
		// TODO
		String messageReturned = array[0].toString();
		SupportTicket replaceWith = array[size - 1];
		array[0] = replaceWith; // swaps root with last index
		array[size - 1] = null;
		size--;
		propagateDown(0); // moves new root down

		return messageReturned;
	}
}
