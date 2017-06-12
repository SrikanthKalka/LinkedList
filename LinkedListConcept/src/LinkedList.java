
public class LinkedList {

	// Length of the Linked List class
	private int length = 0;
	Node head; // It holds the head of the class
	Node tail;
	int i = 0;

	public LinkedList() {
		length = 0;
	}

	/**
	 * // Find Length of the Linked List
	 * 
	 * @return length
	 */
	public int getLength() {
		return length;
	}

	// 1.Return first node (Head)value in the list

	public synchronized int getHead() {
		if (head == null) {
			System.out.println("Sorry, your list was empty..");
			return 0;
		}
		return head.getData();
	}

	// 1.Return Last node (Tail)value in the list
	public synchronized int getTail() {
		if (tail == null) {
			System.out.println("Sorry, your list was empty..");
			return 0;
		}
		return tail.getData();
	}

	// 2.Insert node in the beginning of the list

	public synchronized void insertAtBegin(Node newNode) {

		// If node is Empty Tip: Tail should be constant
		if (newNode == null) {
			return;
		}
		System.out.println("\n" + "InsertAtBegin Method is Running.." + "\n"
				+ "The element going to added in the list is :"
				+ newNode.getData());

		// case.1: If no elements in the List
		if (head == null) {
			head = newNode;
			tail = newNode;
		} // case.2: If Linked list contains More than One element.
		else {
			newNode.setNext(head);
			// Re-referencing the new node to head
			head = newNode;
		}
		// Added new node, so increment length value
		length++;
		printHeadTailAndLength();

	}

	// 3.Insert node at the end of the list

	public synchronized void insertAtEnd(Node newNode) {

		System.out.println("\n" + "InsertAtEnd Method is Running.." + "\n"
				+ "The element going to added in the list is :"
				+ newNode.getData());
		Node temp;

		// to become new node as the tail Tip: Head should be constant
		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		// If Linked list contains More than One element.
		else if (head.getNext() != null) {
			temp = head;
			temp.setNext(newNode);
			tail = newNode;
		}
		// If Linked list contains only One element.
		else {
			head.setNext(newNode);
			tail = newNode;
		}
		length++;
		printHeadTailAndLength();
	}

	/**
	 * 4.Add a new value to the List at a given position & All values at that
	 * position to the end move over to make room
	 */
	public synchronized void insertByPosition(int data, int position) {

		System.out.println("\n" + "insertByPosition Method is Running.." + "\n"
				+ "The element " + data
				+ " is going to added at the position is :" + position);

		if (position < 0) {
			position = 0;
		} else if (position > length) {
			position = length;
		}
		// if list is empty, create a node with Data
		if (head == null) {
			head = new Node(data);
		}
		// insert at the position 0

		else if (position == 0) {

			Node tempNode = new Node(data);
			tempNode.setNext(tempNode);
			tempNode = head;

		} else {
			Node tempNode = head;
			// Position 5
			for (int i = 1; i < position; i++) {
				tempNode = tempNode.getNext();
			}
			Node newNode = new Node(data);
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
		length++;
	}

	/**
	 * Remove a node from the Head of the List important Note: First assign head
	 * to next element and delete the Head element
	 * 
	 * @return removedNode
	 */
	public synchronized Node removeNodeFromBegin() {

		System.out.println("\n" + "removeNodeFromBegin Method is Running..");

		// Assign head node to removeNode
		Node removeNode = head;
		// Head is not empty then go ahead and apart front element and set it
		// null(for delete)//
		if (removeNode != null) {
			head = removeNode.getNext();
			removeNode.setNext(null);
		}
		return removeNode;

	}

	/*
	 * removeNodeFromEnd()
	 * 
	 * case 1 : If List is empty. case 2 : If List contain only one element.
	 * Case 3 : If List contains more than one element.
	 * 
	 * @return
	 */
	public synchronized Node removeNodeFromEnd() {

		System.out.println("\n" + "removeNodeFromEnd Method was invoked..");

		// Assign head node to removeNode
		Node removeNode = head;
		Node previousNode = null;
		Node nextNode = head.getNext();

		// case 1 : If List is empty.
		if (head == null) {
			return null;
		}
		// case 2 : If List contain only one element.
		if (nextNode == null) {
			head = null;
			return removeNode;
		}
		// Case 3 : If List contains more than one element.

		/**
		 * Algorithm. (Goal:Find a node which is Previous to the tail)
		 * 
		 * Node removeNode = head; ( removeNode-------> Traversal Node) Node
		 * previousNode = null; ( previousNode ---->To hold Previous Node
		 * address) Node nextNode = head.getNext()
		 * 
		 * Step 1: Traverse the List, while traversing maintain the previous
		 * node address also.
		 * 
		 * step 2: By the time moving to the end of the list, we will have two
		 * pointers, one is pointing to the tail and other pointing to the
		 * previous node.
		 * 
		 * previousNode = removeNode; removeNode = nextNode;
		 * 
		 * step 3: When the next node does not have next element just end the
		 * process, because we found Tail element and also we have previous
		 * element Address. Make previous node next element as null and make
		 * Previous node as a Tail.
		 * 
		 */

		while ((nextNode = removeNode.getNext()) != null) {

			System.out.println("nextNode Node value: " + nextNode.getData());
			System.out.println("removeNode.getNext() Node value: "
					+ (removeNode.getNext()).getData());

			// to store previous element address using temp
			previousNode = removeNode;
			// the moving forward, remove Node in the list
			// (Remove node is the traversal node)
			removeNode = nextNode;
			i++;
			// Loop run until Traversal node final element is null.

			System.out.println("previousNode Node value: "
					+ previousNode.getData());
			System.out
					.println("removeNode Node value: " + removeNode.getData());
			System.out.println("Loop executing: " + i + " Time");
		}
		// Finally,Once come out of the loop previousNode Node is our Tail Node.
		// Delete removed node setting value as null
		previousNode.setNext(null);
		// Assign tail node as temp
		tail = previousNode;

		return removeNode;

	}

	/**
	 * Insert an element in the List without using Tail Node.
	 * 
	 * @param newNode
	 */
	public synchronized void insertAtEndwithoutTail(Node newNode) {

		System.out
				.println("\n" + "insertAtEndwithoutTail Method was invoked..");
		// Assign head node to removeNode
		Node tempHeadNode = head;
		Node previousNode = null;
		Node nextNode = head.getNext();

		// case 1 : If List is empty.
		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		// case 2 : If List contain only one element.
		if (nextNode == null) {
			head.setNext(newNode);
			tail = head.getNext();
		}
		// Case 3 : If List contains more than one element.

		while ((nextNode = tempHeadNode.getNext()) != null) {

			previousNode = tempHeadNode;
			tempHeadNode = nextNode;
		}

		previousNode.setNext(newNode);
		tail = previousNode.getNext();

		printHeadTailAndLength();
	}

	/**
	 * Algorithm
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param removeNode
	 */
	public synchronized void removeNodeMatched(Node removeNode) {

		System.out.println("\n" + "removeNodeMatched Method was invoked..");

		// case 1 : If List is empty.
		if (head == null) {
			return;
		}

		// case 2 : If List contain only one element.
		if (removeNode.equals(head)) {
			head = head.getNext();
			return;
		}
		// case 3 : If List contain more than one element.

		Node searchNode = head;
		Node previous = null;

		while (searchNode.getData() != removeNode.getData()) {

			previous = searchNode;
			searchNode = searchNode.getNext();
		}

		previous.setNext(searchNode.getNext());

		length--;
		printHeadTailAndLength();

	}

	/**
	 * Algorithm Remove the element by position
	 * 
	 * 
	 * 
	 * 
	 * @param removeNode
	 */
	public synchronized void removeNodeByPosition(int position) {

		System.out.println("\n" + "removeNodeByPosition Method was invoked..");

		Node temp = head;
		Node previous = null;

		if (position < 0 || position > length) {
			System.out.println("Sorry,The given position " + position
					+ " was invalid..");
			return;
		}

		if (position == 1) {
			temp = head.getNext();
			head = temp;
			length--;
			printHeadTailAndLength();
			return;
		}

		// Decrement position by 1 because inside the loop we are moving temp
		// position.
		for (int j = 1; j <= position - 1; j++) {
			previous = temp;
			temp = temp.getNext();
		}
		System.out.println("The Node value at given posistion is: "
				+ temp.getData());
		if (temp.getNext() != null) {
			previous.setNext(temp.getNext());
		} else {
			previous.setNext(null);
			tail = previous;
		}
		temp = null;
		printHeadTailAndLength();
	}

	/**
	 * 
	 * Return a string representation of this collection, in the form
	 * ["str1","str2"....]
	 * 
	 */
	public String toString() {

		String result = "[ ";

		// If list is empty
		if (head == null) {
			return result + "]";
		}

		// if list is not empty
		Node temp = head;

		while (temp != null) {
			result = result + temp.getData() + "---->";
			temp = temp.getNext();
		}

		return result + " null]";
	}

	/**
	 * @param inputNode
	 * @return node value
	 */
	public int getNodeData(Node inputNode) {

		if (inputNode != null) {
			return inputNode.getData();
		}
		return 0;
	}

	public int getPositionOfNode(int data) {

		Node temp = head;
		int position = 1;

		while (temp != null) {

			if (temp.getData() == data) {
				return position;
			}
			temp = temp.getNext();
			position++;

		}
		return position;
	}

	/**
	 * Remove all elements from the list
	 */
	public void clearList() {

		head = null;
		length = 0;
	}

	/**
	 * To Print Head,Tail and Length of the List
	 */
	public void printHeadTailAndLength() {
		System.out.println("Head Element  value: " + getHead());
		System.out.println("Tail Element  value: " + getTail());
		System.out.println("Length of the Linked-List is: " + getLength());
	}
}
