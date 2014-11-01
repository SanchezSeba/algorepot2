package vEBTree;

public class VEBTree {

	VEBNode root;
	
	public VEBTree(int maxSize){
		root = new VEBNode(maxSize);
	}
	
	public void insert(int key){
		insert(root, key);
	}

	private void insert(VEBNode node, int key) {
		if(node.min == -1){
			node.min = key;
			node.max = key;
		}
		if(node.min > key){
			int aux = key;
			key = node.min;
			node.min = aux;
		}
		if(node.min < key && node.maxSize > 2){
			int low = (int)(key % node.cluster.length);
			int high = (int)(key / node.cluster.length);
			if(node.cluster[high].min != -1){
				insert(node.cluster[high], low);
			}
			else{
				insert(node.summary, high);
				node.cluster[high].min = low;
				node.cluster[high].max = low;
			}
		}
		if(key > node.max)
			node.max = key;
	}
}
