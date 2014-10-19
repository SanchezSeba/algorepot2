package binaryTree;

public class BinaryNode {

	int key;
	BinaryNode left, right;
	
	public BinaryNode(int key){
		this.key = key;
		left = null;
		right =null;
	}

	public void insert(int key2) {
		if(key2 < key){
			if(left == null){
				left = new BinaryNode(key2);
			}
			else{
				left.insert(key2);
			}
		}
		else if(key2 > key){
			if(right == null){
				right = new BinaryNode(key2);
			}
			else{
				right.insert(key2);
			}
		}		
	}

	public BinaryNode find(int key2) {
		if(key == key2)
			return this;
		BinaryNode node = null;
		if(key2 < key)
			node = left;
		else if(key2 > key)
			node = right;
		if(node != null)
			return node.find(key2);
		return null;
	}
	
	public String toString(){
		String s = "key: " + key;
		if(left != null)
			s += " Hijo izq de " + key + ": " + left.toString();
		if(right != null)
			s += " Hijo der de " + key + ": " + right.toString();
		return s;
	}
}
