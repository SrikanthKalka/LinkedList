import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		char ch;
		boolean repeatOperationMsg = false;

		Scanner scan = new Scanner(System.in);

		System.out.println("\n****Singly Linked List Operations*****\n");
		System.out.println("Choice-1: Return first node (Head) in the list\n");
		System.out.println("Choice-2. Return Last node (Tail) in the list\n");
		System.out
				.println("Choice-3. Insert node in the beginning of the list\n");
		System.out.println("Choice-4. Insert node at the end of the list\n");
		System.out
				.println("Choice-5. Add a new node to the List at a given position\n");
		System.out
				.println("Choice-6. Remove and return the node at the HEAD of the list\n");
		System.out
				.println("Choice-7. Remove a node matching the specified Node from the list\n");
		System.out.println("Choice-8. Remove value at the given position\n");
		System.out
				.println("Choice-9. Return a string representation of this collecction, in the form [str1,str2....]\n");
		System.out.println("Choice-10.Return the current length of the List\n");
		System.out
				.println("Choice-11 Find the posistion of the First value that is equal to a given value\n");
		System.out.println("Choice-12 Remove everything from the List\n");

		do {

			if (repeatOperationMsg) {

				System.out
						.println("\n***Please choose one of the above choices***\n");
			}

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				list.getHead();
				break;
			case 2:
				list.getTail();
				break;
			case 3:
				System.out.println("Enter integer element to insert");
				list.insertAtBegin(new Node(scan.nextInt()));
				break;
			case 4:
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(new Node(scan.nextInt()));
				break;
			case 5:
				System.out.println("Enter integer element to insert");
				int num = scan.nextInt();
				System.out.println("Enter position");
				int pos = scan.nextInt();
				list.insertByPosition(num, pos);
				break;
			case 6:
				Node removedNode = list.removeNodeFromBegin();
				System.out.println("Removed Head Value is: "
						+ removedNode.getData());
				break;
			case 7:
				int nodeValue = scan.nextInt();
				list.removeNodeMatched(new Node(nodeValue));
				System.out
						.println("Remove a node "+nodeValue+ " matching the specified Node from the list");
				break;
			case 8:
				int loc = scan.nextInt();
				list.removeNodeByPosition(loc);
				System.out.println("Removed node in the position: " + loc);
				break;
			case 9:
				String format = list.toString();
				System.out.println(format);
				break;
			case 10:
				int length = list.getLength();
				System.out.println("Length of the List is: " + length);
				break;
			case 11:
				list.removeNodeByPosition(scan.nextInt());
				System.out
						.println("Find the posistion of the First value that is equal to a given value");
				break;
			case 12:
				list.clearList();
				System.out.println("Remove everything from the List");
				break;

			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				repeatOperationMsg = true;
			}
		} while (ch == 'Y' || ch == 'y');

	}
}
