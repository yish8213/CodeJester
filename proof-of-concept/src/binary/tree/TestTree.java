package binary.tree;

public class TestTree {
	public static void main(String[] args) throws Exception {
        BinaryTree theTree = new BinaryTree();

        System.out.println("===== Generate binary tree =====");

        /*
                          50("1")
                        /         \
                  30("2")         70("3")
                 /       \       /       \
              20("4") 40("5") 60("6") 80("7")
        */

		theTree.addNode(50, "1");
		theTree.addNode(30, "2");
		theTree.addNode(70, "3");
		theTree.addNode(20, "4");
		theTree.addNode(40, "5");
		theTree.addNode(60, "6");
		theTree.addNode(80, "7");

		theTree.displayTree(theTree.getRoot());
		
		System.out.println("===== Change leaf to root =====");
		theTree.upsideDownTree(40);
		
		System.out.println("===== Showing result =====");

        /*
                          40("5")
                        /
                  30("2")
                 /       \
              20("4")  50("1")
                              \
                             70("3")
                            /       \
                         60("6")  80("7")
        */

		theTree.displayTree(theTree.getRoot());

	}

}