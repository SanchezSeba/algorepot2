import java.util.Arrays;
import java.util.Random;

import splayTree.SplayTree;
import vEBTree.VEBTree;

import org.apache.commons.*;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import binaryTree.BinaryTree;
import avlTree.AVLTree;

public class Main {
	
	//generador de numeros aleatorios
	public static int[] generator(int n){
		int[] kn = new int[n];
		Random rand = new Random();
		for(int i=0; i < n; i++){
			kn[i] = rand.nextInt((int)Math.pow(2, 22));
		}
		return kn;
	}
	
	
	//retorna cte de normalizacion de secuencia de busqueda tipo 2
	public static double getCte2(int n, double m){
		double value = 0;
	    for (int i = n; i > 0; --i) {
	    	value += 1.0 / Math.pow(i, m);
	    }		
		return 1/value;
	}
	
	//retorna cte de normalizacion de secuencia de busqueda tipo 3
	public static double getCte3(int n, double m){
		double value = (1 - Math.pow(m, -n))/(m - 1);
		return 1/value;
	}
	
	public static void main(String[] args){
		//tamaño del conjunto ******
		int n = (int)Math.pow(2, 10);
		
		//creamos conjunto
		int[] kn = generator(n);
		
		//------------------dedes aqui medimos tiempo de construccion-----------------
		
		//creamos arbol *****
		BinaryTree b = new BinaryTree();
		//AVLTree b = new AVLTree();
		//SplayTree b = new SplayTree();
		//VEBTree b = new VEBTree((int)Math.pow(2, 22)); //veb siempre debe ser de 2^22 ya que es el rango de los numeros
		
		//insercion
		for(int i=0; i < n; i++){
			b.insert(kn[i]);
		}
		//------------------hasta aqui medimos tiempo de construccion---------------
		
		
		/////////////////////////////////////////////////////////////////////////////////
		
		//------------------desde aqui medimos tiempo de busqueda 1------------------
		
		/*
		//Secuencia de busqueda tipo 1 ----------------
		Random rand = new Random();
		for(int i=0; i < 100*n; i++){
			b.find(kn[rand.nextInt(n)]);
		}
		//fin secuencia de busqueda tipo 1 ---------------
		*/
		//------------------hasta aqui medimos tiempo de busqueda 1------------------
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		/*
		//Secuencia de busqueda tipo 2 --------------
		//seteamos valor de a
		double a = 1.2; //*********************
		//Calculamos cte de normalizacion
		double c = getCte2(n,a);
		
		//Generamos las probabilidades
		double[] discreteProbabilities = new double[n];
		for(int i=n; i > 0; i--){
			discreteProbabilities[i-1] = c/Math.pow(i, a);
		}
		
		//Asignamos probabilidades a cada key
		EnumeratedIntegerDistribution distribution = 
		    new EnumeratedIntegerDistribution(kn, discreteProbabilities);
		
		//obtenemos 100n elementos para buscar
		int[] samples = distribution.sample(100*n);
		//------------------desde aqui medimos tiempo de busqueda 2------------------
		//buscamos
		for(int i=0; i < 100*n; i++){
			b.find(samples[i]);
		}
		//fin secuencia de busqueda tipo 2 ----------------
		*/
		//------------------hasta aqui medimos tiempo de busqueda 2------------------
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		//Secuencia de busqueda tipo 3 -------------
		//seteamos valor de a
		double a = 1.2; //********************
		//Calculamos cte de normalizacion
		double c = getCte3(n,a);
		//Generamos las probabilidades
		double[] discreteProbabilities = new double[n];
		for(int i=n; i > 0; i--){
			discreteProbabilities[i-1] = c/Math.pow(a, i);
		}
		//Asignamos probabilidades a cada key
		EnumeratedIntegerDistribution distribution = 
				new EnumeratedIntegerDistribution(kn, discreteProbabilities);
				
		//obtenemos 100n elementos para buscar
		int[] samples = distribution.sample(100*n);
		//------------------desde aqui medimos tiempo de busqueda 3------------------
		//buscamos
		for(int i=0; i < 100*n; i++){
			b.find(samples[i]);
		}
		//fin secuencia de busqueda tipo 3 ----------------
		//------------------hasta aqui medimos tiempo de busqueda 3 ------------------
	}
}
