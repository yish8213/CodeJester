package binary.tree;

public class BinNode {
	private int key;
	private String name;
	private boolean isRoot = false;

	private BinNode parent;
	private BinNode leftChild;
	private BinNode rightChild;

	public BinNode(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public BinNode getParent() {
		return parent;
	}

	public void setParent(BinNode parent) {
		this.parent = parent;
	}

	public BinNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinNode rightChild) {
		this.rightChild = rightChild;
	}

	public String toString() {
		return name + " has the key " + key;
	}
}
