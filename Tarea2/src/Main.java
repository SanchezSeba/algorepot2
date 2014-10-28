import splayTree.SplayTree;



public class Main {
	
	public static void main(String[] args){
		SplayTree b = new SplayTree();
		b.insert(3);
		b.insert(4);
		b.insert(6);
		b.insert(5);
		b.insert(8);
		b.insert(10);
		b.insert(9);
		b.insert(9);
		b.insert(3);
		System.out.println(b.find(5).toString());
	}
}
