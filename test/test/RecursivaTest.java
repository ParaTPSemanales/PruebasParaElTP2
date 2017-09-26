package test;

import utilidades.BinomioNewton;
import utilidades.Polinomio;

import org.junit.Assert;
import org.junit.Test;

public class RecursivaTest {
	
	@Test
	public void queEvalueBienPolinomioValorFlotante(){
		double[] coeficientes = {13,15,15};
		Polinomio  polinomioTest = new Polinomio(2,coeficientes);
		Assert.assertTrue(polinomioTest.evaluarRecursiva(6.5)==661.75);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado0(){
		double[] coeficientes = {15};
		Polinomio  polinomioTest = new Polinomio(0,coeficientes);
		Assert.assertTrue(polinomioTest.evaluarRecursiva(6666666)==15);
	}
		
	@Test
	public void queEvalueBienPolinomioGrado1(){		
		double[] coeficientes = {15,3};
		Polinomio  polinomioTest = new Polinomio(1,coeficientes);
		Assert.assertTrue(polinomioTest.evaluarRecursiva(6)==93);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado2(){
		double[] coeficientes = {3,1,5};
		Polinomio  polinomioTest = new Polinomio(2,coeficientes);
		Assert.assertTrue(polinomioTest.evaluarRecursiva(3)==35);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado3(){
		double[] coeficientes = {8, 5, 8, 4};
		Polinomio  polinomioTest = new Polinomio(3,coeficientes);
		Assert.assertTrue(polinomioTest.evaluarRecursiva(6)==1960);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado20(){
		double[] coeficientes = {3, 4, 6, 2, 1, 5, 6, 23, 34, 12, 34, 98, 3, 2, 1, 34, 2, 1, 8, 9, 54};
		Polinomio  polinomioTest = new Polinomio(20,coeficientes);
		long start = System.nanoTime();				
		Assert.assertTrue(polinomioTest.evaluarRecursiva(2)==7845136);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarRecursivaGrado20: " + tiempo + " ns");
	}
		
	@Test
	public void queEvaluePolinomioGrado50() {
		
		double[] coeficientes = {1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23,-1,21};
		Polinomio  polinomioTest = new Polinomio(50,coeficientes);
		long start = System.nanoTime();
		Assert.assertTrue(polinomioTest.evaluarRecursiva(-1) == 23);		
		long tiempo = System.nanoTime()- start;
		System.out.println("[PolinomioEvaluarRecursivaGrado50: " + tiempo + " ns");		
	}
	
	@Test
	public void queEvaluePolinomioGrado100() {
		double[] coeficientes ={1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23,-1,21,
								1,2,3,4,5,6,4,3,2,1,3,4,6,7,8,9,7,6,5,44,33,2,1,2,3,4,55,66,7,88,76,6,55,44,3,2,1,2,3,-4,5,66,-1,-1,-77,-123,12,2,23};
		Polinomio  polinomioTest = new Polinomio(99,coeficientes);
		long start = System.nanoTime();
		Assert.assertTrue(polinomioTest.evaluarRecursiva(-1) == -22);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarRecursivaGrado100: " + tiempo + " ns");		
	}
	
	@Test
	public void queEvaluePolinomioGrado1000() {
		Polinomio  polinomioTest = new Polinomio(1000);
		long start = System.nanoTime();
		Assert.assertTrue(polinomioTest.evaluarRecursiva(1) == 1001);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarRecursivaGrado1000: " + tiempo + " ns");		
	}
	
	@Test
	public void queEvaluePolinomioGrado10000() {
		Polinomio  polinomioTest = new Polinomio(10000);
		long start = System.nanoTime();
		Assert.assertTrue(polinomioTest.evaluarRecursiva(1) == 10001);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[PolinomioEvaluarRecursivaGrado10000: " + tiempo + " ns");		
	}

	//TEST BINOMIO DE NEWTON
	@Test
	public void queEvalueBienBinomioGrado20(){
		BinomioNewton binomioTest = new BinomioNewton(20,1,1);
		long start = System.nanoTime();		
		Assert.assertTrue(binomioTest.evaluarRecursiva(1)==1048576);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[BinomioevaluarRecursivaGrado20: " + tiempo + " ns");
	}	
	
	@Test
	public void queEvalueBienBinomioGrado50(){
		BinomioNewton binomioTest = new BinomioNewton(50,1,0.5);
		long start = System.nanoTime();
		Assert.assertTrue(binomioTest.evaluarRecursiva(1)==637621500.21404958690340780691486);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado50: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado100(){
		BinomioNewton binomioTest = new BinomioNewton(100,1,0.5);
		long start = System.nanoTime();
		Assert.assertTrue(binomioTest.evaluarRecursiva(1)==406561177535215237.39727970756704);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado100: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado1000(){
		BinomioNewton binomioTest = new BinomioNewton(1000,1,0.5);
		long start = System.nanoTime();
		//Assert.assertTrue(binomioTest.evaluarRecursiva(1)==406561177535215237.39727970756704);
		binomioTest.evaluarRecursiva(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado1000: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado10000(){
		BinomioNewton binomioTest = new BinomioNewton(10000,1,0.5);
		long start = System.nanoTime();
		//Assert.assertTrue(binomioTest.evaluarRecursiva(1)==406561177535215237.39727970756704);
		binomioTest.evaluarRecursiva(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado10000: " + tiempo + " ns");
	}
	
	//TEST BINOMIO DE NEWTON DESARROLLANDO POLINOMIO
	@Test
	public void queEvalueBienBinomioGrado20ConDesarrolloDePolinomio(){
		BinomioNewton binomioTest = new BinomioNewton(20,1,1);
		long start = System.nanoTime();
		Double resultado = Double.valueOf(1048576);
		Assert.assertTrue(binomioTest.evaluarRecursivaConDesarrollo(1)==resultado);		
		long tiempo = System.nanoTime() - start;
		System.out.println("[BinomioEvaluarRecursivaGrado20ConDesarrollo: " + tiempo + " ns");
	}	
	
	@Test
	public void queEvalueBienBinomioGrado50ConDesarrolloDePolinomio(){
		BinomioNewton binomioTest = new BinomioNewton(50,1,0.5);
		long start = System.nanoTime();
		binomioTest.evaluarRecursivaConDesarrollo(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado50ConDesarrollo: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado100ConDesarrolloDePolinomio(){
		BinomioNewton binomioTest = new BinomioNewton(100,1,0.5);
		long start = System.nanoTime();
		binomioTest.evaluarRecursivaConDesarrollo(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado100ConDesarrollo: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado1000ConDesarrolloDePolinomio(){
		BinomioNewton binomioTest = new BinomioNewton(1000,1,0.5);
		long start = System.nanoTime();
		binomioTest.evaluarRecursivaConDesarrollo(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado1000ConDesarrollo: " + tiempo + " ns");
	}
	
	@Test
	public void queEvalueBienBinomioGrado10000ConDesarrolloDePolinomio(){
		BinomioNewton binomioTest = new BinomioNewton(10000,1,0.5);
		long start = System.nanoTime();
		binomioTest.evaluarRecursivaConDesarrollo(1);
		long tiempo = System.nanoTime() - start; 
		System.out.println("[BinomioEvaluarRecursivaGrado10000ConDesarrollo: " + tiempo + " ns");
	}
}
