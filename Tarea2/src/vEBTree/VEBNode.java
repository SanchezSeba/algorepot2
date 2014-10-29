package vEBTree;

public class VEBNode {
	
	int maxSize;
	int min, max;
	VEBNode summary;
	VEBNode []cluster;
	
	public VEBNode(int maxSize){
		this.maxSize = maxSize;
		this.min = -1;
		this.max = -1;
		
		double r = Math.sqrt(this.maxSize);
		int size = (int)Math.ceil(r);
		if(maxSize == 2){
			summary = null;
			cluster = null;
		}
		else{
			summary = new VEBNode(size);
			cluster = new VEBNode[size];
			for(int i=0; i < size; i++){
				cluster[i] = new VEBNode(size);
			}
		}			
	}
	
	
}
