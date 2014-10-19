package binaryTree;

public class BinaryTree {
	
	BinaryNode root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	public void insert(int key){
		if(root == null){
			root = new BinaryNode(key);
		}
		else{
			root.insert(key);
		}
	}
	
	public BinaryNode find(int key){
		if(root != null){
			return root.find(key);
		}
		return null;
	}
}
