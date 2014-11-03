import java.util.Random;

import vEBTree.VEBTree;


public class Main {
	
	//generador
	public static int[] generator(int n){
		int[] kn = new int[n];
		Random rand = new Random();
		for(int i=0; i < n; i++){
			kn[i] = rand.nextInt((int)Math.pow(2, 22));
		}
		return kn;
	}
	
	//metodo para obtener la constante de normalizacion
	public static double generalizedHarmonic(final long n, final double m) {
		double value = 0;
	    for (long k = n; k > 0; --k) {
	    	value += 1.0 / Math.pow(k, m);
	    }
	    return value;
	}
	
	
	
	public static void main(String[] args){
		//tamaño del conjunto
		int n = (int)Math.pow(2, 10);
		
		//creamos conjunto
		int[] kn = generator(n);
		
		//------------------dedes aqui medimos tiempo de construccion-----------------
		
		//creamos arbol
		VEBTree b = new VEBTree(n);
		
		//insercion
		for(int i=0; i < n; i++){
			b.insert(kn[i]);
		}
		//------------------hasta aqui medimos tiempo de construccion---------------
		
		//------------------desde aqui medimos tiempo de busqueda------------------
		
		//Secuencia de busqueda tipo 1
		Random rand = new Random();
		for(int i=0; i < 100*n; i++){
			b.find(kn[rand.nextInt(n)]);
		}
		//fin secuencia de busqueda tipo 1
		
		
		System.out.println(generalizedHarmonic((long)(100*Math.pow(2, 10)),1.2));
	}
}
