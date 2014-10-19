package avlTree;

public class AVLNode {
	
	int key, height;
	AVLNode left, right;
	
	public AVLNode(int key){
		this.key = key;
		this.left = null;
		this.right = null;
		this.height = 0;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public AVLNode find(int key2) {
		if(key == key2)
			return this;
		AVLNode node = null;
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
