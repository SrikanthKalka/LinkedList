public class BSTreeNode {

	public BSTreeNode rightChild;
	public BSTreeNode leftChild;
	public int nodeData;

	public BSTreeNode() {
		rightChild = null;
		leftChild = null;
		nodeData = 0;
	}

		// Whenever initially we are passing the node value,other values should   be null 
	public BSTreeNode(int nodeData) {
		leftChild = rightChild = null;
		this.nodeData = nodeData;
	}

	public void setNodeData(int nodeData) {
		this.nodeData = nodeData;

	}

	public int getNodeData() {
		return nodeData;
	}
}
