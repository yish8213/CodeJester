package binary.tree;


public class BinTree {
	private BinNode root;
	
	public void addNode(int key, String name) {
		BinNode newNode = new BinNode(key, name);
		
		if(root == null) { // 루트노드는 루트플래그 true를 갖고 부모노드가 null이다
			root = newNode;
			root.setRoot(true);
		} else {
			BinNode focusNode = root;
			
			BinNode parent;
			
			while(true) {
				parent = focusNode;
				
				if(key < focusNode.getKey()) {
					focusNode = focusNode.getLeftChild();
					
					if(focusNode == null) {
						newNode.setParent(parent);
						parent.setLeftChild(newNode);
						return;
					}
				} else {
					focusNode = focusNode.getRightChild();
					
					if(focusNode == null) {
						newNode.setParent(parent);
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
		
	}
	
	// pre-order traverse tree
	public void displayTree(BinNode focusNode) {
		if(focusNode != null) {
			String parentName = "null because i'm root";
			if(!focusNode.isRoot()) {
				parentName = focusNode.getParent().getName();
			}
			
			System.out.println(focusNode.getName() + " (Parent is " + parentName + ")");
			displayTree(focusNode.getLeftChild());
			displayTree(focusNode.getRightChild());
		}
		
	}
	
	public BinNode findNodeByKeyValue(int key) {
		BinNode focusNode = root;
		
		while(focusNode.getKey() != key) {
			if(key < focusNode.getKey()) {
				focusNode = focusNode.getLeftChild();
			} else {
				focusNode = focusNode.getRightChild();
			}
			
			if(focusNode == null) {
				return null;
			}
		}
		
		System.out.println("key : " + focusNode.getKey() + " , name : " + focusNode.getName());
		return focusNode;
	}
	
	public void upsideDownTree(int key) {
		BinNode focusNode = findNodeByKeyValue(key);
		
		// 선택한 leaf와 root노드 사이 경로의 부모와 자식노드 관계만 바뀌고 다른경로는 변화 없음 
		swapParentAndChild(focusNode, null);
		
		focusNode.getParent().setParent(focusNode);
		focusNode.setParent(null);
		focusNode.setRoot(true);
		this.root = focusNode;
	}
	
	// Root 까지의 부모와 자식노드를 스왑하는 메소드
	public void swapParentAndChild(BinNode focusNode, BinNode parentForRoot) {
		BinNode parentOfFocusNode = focusNode.getParent();
		
		if(!focusNode.isRoot()) {
			if(parentOfFocusNode.getLeftChild().hashCode() == focusNode.hashCode()) {
				parentOfFocusNode.setLeftChild(null);
			} else if(parentOfFocusNode.getRightChild().hashCode() == focusNode.hashCode()) {
				parentOfFocusNode.setRightChild(null);
			}
		} 
		
		if(focusNode.getLeftChild() == null) {
			focusNode.setLeftChild(parentOfFocusNode);
		} else if(focusNode.getRightChild() == null) {
			focusNode.setRightChild(parentOfFocusNode);
		}
		
		if(!focusNode.isRoot()) {
			swapParentAndChild(parentOfFocusNode, focusNode);
		} else { // 기존의 루트노드에 도달하면 루트플래그를 false로 변경하고 null인 부모노드에 변환 경로상의 자식노드가 할당된다
			focusNode.setRoot(false);
			focusNode.setParent(parentForRoot);
		}
		
	}
	
	public BinNode getRoot() {
		return root;
	}

	public void setRoot(BinNode root) {
		this.root = root;
	}
	
	
}
