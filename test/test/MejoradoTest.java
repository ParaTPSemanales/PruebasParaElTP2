package test;

import utilidades.Polinomio;
import org.junit.Assert;
import org.junit.Test;

public class MejoradoTest {



	@Test
	public void queEvalueBienPolinomioGrado1(){
		
		 double[] coeficientes = {15,3};
		 
		Polinomio  polinomioTest = new Polinomio(1,coeficientes);

		Assert.assertTrue(polinomioTest.evaluarMejorada(6)==93);
	}
	
	
	@Test
	public void queEvalueBienPolinomioGrado2(){
		double[] coeficientes = {3,1,5};
		Polinomio  polinomioTest = new Polinomio(2,coeficientes);

		Assert.assertTrue(polinomioTest.evaluarMejorada(3)==35);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado3(){
		double[] coeficientes = {8, 5, 8, 4};
		Polinomio  polinomioTest = new Polinomio(3,coeficientes);

		Assert.assertTrue(polinomioTest.evaluarMejorada(6)==1960);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado20(){
		double[] coeficientes = {3, 4, 6, 2, 1, 5, 6, 23, 34, 12, 34, 98, 3, 2, 1, 34, 2, 1, 8, 9, 54};
		Polinomio  polinomioTest = new Polinomio(20,coeficientes);
		long start = System.nanoTime();
		
		
		Assert.assertTrue(polinomioTest.evaluarMejorada(2)==7845136);
		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarMSucesivaGrado20: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienPolinomioGrado0(){
		double[] coeficientes = {15};
		Polinomio  polinomioTest = new Polinomio(0,coeficientes);

		Assert.assertTrue(polinomioTest.evaluarMejorada(6666666)==15);
	}
	
	@Test
	public void queEvalueBienPolinomioValorFlotante(){
		double[] coeficientes = {13,15,15};
		Polinomio  polinomioTest = new Polinomio(2,coeficientes);

	Assert.assertTrue(polinomioTest.evaluarMejorada(6.5)==661.75);
	}

	@Test
	public void queEvaluePolinomioGrado50() {
		
		double[] coeficientes = {1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23,-1,21};
		Polinomio  polinomioTest = new Polinomio(50,coeficientes);
		long start = System.nanoTime();
		
		Assert.assertTrue(polinomioTest.evaluarMejorada(-1) == 23);
		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarPowGrado50: " + tiempo + " ns");
		
	}
	
	@Test
	public void queEvaluePolinomioGrado100() {
		double[] coeficientes ={1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23,-1,21,
				                1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23,-1,21};
		Polinomio  polinomioTest = new Polinomio(99,coeficientes);
		long start = System.nanoTime();
		

		Assert.assertTrue(polinomioTest.evaluarMejorada(-1) == -22);
		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarMPowGrado100: " + tiempo + " ns");
		
	}


}

