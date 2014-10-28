package splayTree;

public class SplayTree {
	
	SplayNode root;
	
	public SplayTree(){
		this.root = null;
	}
	
	public SplayNode find(int key){
		root = splay(root, key);
		if(key == root.getKey()){
			return root;
		}
		return null;
	}
	
	public void insert(int key){
		if(root == null){
			root = new SplayNode(key);
			return;
		}
		root = splay(root, key);
		SplayNode node = new SplayNode(key);
		if(key < root.getKey()){
			node.left = root.left;
			node.right = root;
			root.left = null;
			root = node;
		}
		else if(key > root.getKey()){
			node.right = root.right;
			node.left = root;
			root.right = null;
			root = node;
		}
		else return;
	}

	private SplayNode splay(SplayNode node, int key) {
		if(node == null)
			return null;
		if(key < node.getKey()){
			if(node.left == null)
				return node;
			if(key < node.left.getKey()){
				node.left.left = splay(node.left.left, key);
				node = rotateRight(node);
			}
			else{
				node.left.right = splay(node.left.right, key);
				if(node.left.right != null)
					node.left =rotateLeft(node.left);
			}
			if(node.left == null)
				return node;
			return rotateRight(node);
		}
		else if(key > node.getKey()){
			if(node.right == null)
				return node;
			if(key < node.right.getKey()){
				node.right.left = splay(node.right.left, key);
				if(node.right.left != null)
					node.right = rotateRight(node.right);
			}
			else{
				node.right.right = splay(node.right.right, key);
				node = rotateLeft(node);
			}
			if(node.right == null) 
				return node;
			return rotateLeft(node);
		}
		else return node;
	}

	private SplayNode rotateLeft(SplayNode node) {
		SplayNode n = node.right;
		node.right = n.left;
		n.left = node;
		return n;
	}

	private SplayNode rotateRight(SplayNode node) {
		SplayNode n = node.left;
		node.left = n.right;
		n.right = node;
		return n;
	}

}
