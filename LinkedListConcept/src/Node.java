

public class Node {

	private int data;
	
	/*Need a pointer to the particular node,So, 
	we have to create another node inside the particular node
	or pointer to next node*/
	
	private Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
