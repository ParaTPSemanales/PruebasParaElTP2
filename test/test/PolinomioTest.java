package test;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import utilidades.Polinomio;

public class PolinomioTest {

	private Polinomio polinomio;
	
	@Before
	public void setUp() {
	polinomio = new Polinomio(4);	
	}
	
	@Test
    public void queInicieEnUnoSegunElGrado() {
		
		int i = 0;
		while(polinomio.getCoeficientes()[i] != 1 && i <= polinomio.getGrado())
		  i ++;
		
		Assert.assertTrue(i>=polinomio.getGrado());
		
	}

	@Test
	public void queEvalueConMSucesivaT() {
		double[] coef = {3,1,5};
		Polinomio otroPolinomio = new Polinomio(2,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarMSucesivas(3) == 35);
	}
	
	@Test
	public void queEvalueDeFormaRecursiva() {
		double[] coef = {3,1,5};
		Polinomio otroPolinomio = new Polinomio(2,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarRecursiva(3) == 35);
	}
	
	@Test
	public void queEvalueRecursivaPar() {
		double[] coef = {3,1};
		Polinomio otroPolinomio = new Polinomio(1,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarRecursivaPar(100) == 301);
	}
	
	@Test
	public void queEvalueConHorner() {
		double[] coef = {3,1};
		Polinomio otroPolinomio = new Polinomio(1,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarHorner(100) == 301);
	}
	
	@Test
	public void queEvalueUsandoPow(){
		double[] coef = {3,1};
		Polinomio otroPolinomio = new Polinomio(1,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarPow(100) == 301);
	}
	
	@Test
	public  void queEvalueProgDinamica(){
		double[] coef = {3,1,-7};
		Polinomio otroPolinomio = new Polinomio(2,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarProgDinamica(12) == 437);
		
	}
	
	@Test
	
	public void queEvalueMejorada() {
	
		double[] coef = {3,1,-7};
		Polinomio otroPolinomio = new Polinomio(2,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarMejorada(12) == 437);
		
		
	}
	
}