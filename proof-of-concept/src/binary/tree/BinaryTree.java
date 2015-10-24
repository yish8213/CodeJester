package binary.tree;


public class BinaryTree {
    private BinaryNode root;

    public void addNode(int key, String name) {
        BinaryNode newNode = new BinaryNode(key, name);

        if (root == null) { // Root node has value of 'isRoot == true' and it's parent node is null
            root = newNode;
            root.setRoot(true);
        } else {
            BinaryNode focusNode = root;

            BinaryNode parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();

                    if (focusNode == null) { // Left child is null
                        newNode.setParent(parent);
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();

                    if (focusNode == null) { // Right child is null
                        newNode.setParent(parent);
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }

    // pre-order traverse tree
    public void displayTree(BinaryNode focusNode) {
        if (focusNode != null) {
            String parentName = "null because i'm root";
            if (!focusNode.isRoot()) {
                parentName = focusNode.getParent().getName();
            }

            System.out.println(focusNode.getName() + " [" + focusNode.getKey() + "] (Parent is " + parentName + ")");
            displayTree(focusNode.getLeftChild());
            displayTree(focusNode.getRightChild());
        }

    }

    public BinaryNode findNodeByKeyValue(int key) {
        BinaryNode focusNode = root;

        while (focusNode.getKey() != key) {
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }

            if (focusNode == null) {
                return null;
            }
        }

        System.out.println("key : " + focusNode.getKey() + " , name : " + focusNode.getName());
        return focusNode;
    }

    // Traversing nodes from leaf to root and swapping parent and child
    public void swapParentAndChild(BinaryNode focusNode, BinaryNode parentForRoot) {
        BinaryNode parentOfFocusNode = focusNode.getParent();

        if (!focusNode.isRoot()) {
            // Set focusNode in parentOfFocusNode to null because focusNode is no longer a child of parentOfFocusNode.
            if (parentOfFocusNode.getLeftChild().hashCode() == focusNode.hashCode()) {
                parentOfFocusNode.setLeftChild(null);
            } else if (parentOfFocusNode.getRightChild().hashCode() == focusNode.hashCode()) {
                parentOfFocusNode.setRightChild(null);
            }

            // Set parent to child
            if (focusNode.getLeftChild() == null && parentOfFocusNode.getKey() < focusNode.getKey()) {
                focusNode.setLeftChild(parentOfFocusNode);
            } else if (focusNode.getRightChild() == null && parentOfFocusNode.getKey() > focusNode.getKey()) {
                focusNode.setRightChild(parentOfFocusNode);
            }

            // Move to parent node
            swapParentAndChild(parentOfFocusNode, focusNode);
        } else { // Meet the root
            focusNode.setRoot(false);
            focusNode.setParent(parentForRoot);
        }

    }

    public void upsideDownTree(int key) {
        BinaryNode focusNode = findNodeByKeyValue(key);

        // Swapping parent and child on path between leaf and root
        swapParentAndChild(focusNode, null);

        // Need to last. To traversing leaf to root
        focusNode.getParent().setParent(focusNode);
        focusNode.setParent(null);
        focusNode.setRoot(true);

        this.root = focusNode;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

}
