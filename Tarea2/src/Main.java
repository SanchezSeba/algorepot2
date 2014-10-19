import binaryTree.BinaryTree;



public class Main {
	
	public static void main(String[] args){
		BinaryTree b = new BinaryTree();
		b.insert(3);
		b.insert(4);
		b.insert(6);
		b.insert(5);
		b.insert(2);
		System.out.println(b.find(6).toString());
	}
}
