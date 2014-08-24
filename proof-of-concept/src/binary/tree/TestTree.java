package binary.tree;

public class TestTree {
	public static void main(String[] args) throws Exception {
		BinTree theTree = new BinTree();

		theTree.addNode(50, "1");
		theTree.addNode(30, "2");
		theTree.addNode(70, "3");
		theTree.addNode(20, "4");
		theTree.addNode(40, "5");
		theTree.addNode(60, "6");
		theTree.addNode(80, "7");

		System.out.println("===== generate binary tree =====");
		theTree.displayTree(theTree.getRoot());
		
		System.out.println("===== change leaf to root =====");
		theTree.upsideDownTree(40);
		
		System.out.println("===== and results =====");
		theTree.displayTree(theTree.getRoot());
		

	}
}