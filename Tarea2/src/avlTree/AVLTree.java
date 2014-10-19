package avlTree;

public class AVLTree {

	AVLNode root;
	
	public AVLTree(){
		root = null;
	}
	
	public AVLNode find(int key){
		if(root != null){
			return root.find(key);
		}
		return null;
	}
	
	public void insert(int key){
		root = insert(key, root);
	}

	private AVLNode insert(int key, AVLNode node) {
		if(node == null)
			node = new AVLNode(key);
		else if(key < node.getKey()){
			node.left = insert(key, node.left);
			if(height(node.left) - height(node.right) == 2){
				if(key < node.left.getKey())
					node = rotateLeft(node);
				else
					node = rotateRightLeft(node);
			}
		}
		else if(key > node.getKey()){
			node.right = insert(key, node.right);
			if(height(node.right) - height(node.left) == 2){
				if(key > node.right.getKey())
					node = rotateRight(node);
				else
					node = rotateLeftRight(node);
			}
		}
		
		node.setHeight(Math.max(height(node.left), height(node.right)) + 1);
		
		return node;
	}

	private AVLNode rotateLeftRight(AVLNode node) {
		node.right = rotateLeft(node.right);
		return rotateRight(node);
	}

	private AVLNode rotateRight(AVLNode node) {
		AVLNode n = node.right;
		node.right = n.left;
		n.left = node;
		node.setHeight(Math.max(height(node.left), height(node.right)) + 1);
		n.setHeight(Math.max(height(n.left), height(n.right)) + 1);
		return n;
	}

	private AVLNode rotateRightLeft(AVLNode node) {
		node.left = rotateRight(node.left);
		return rotateLeft(node);
	}

	private AVLNode rotateLeft(AVLNode node) {
		AVLNode n = node.left;
		node.left = n.right;
		n.right =  node;
		node.setHeight(Math.max(height(node.left), height(node.right)) + 1);
		n.setHeight(Math.max(height(n.left), height(n.right)) + 1);
		
		return n;
	}

	private int height(AVLNode node) {
		return node == null ? -1 : node.getHeight();
	}
}
