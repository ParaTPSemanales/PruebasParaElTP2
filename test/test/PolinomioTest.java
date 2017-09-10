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
		while(polinomio.getCoeficientes()[i] != 1 && i < polinomio.getGrado())
		  i ++;
		
		Assert.assertTrue(i>=polinomio.getGrado());
		
	}

	@Test
	public void obtenerEscalarAPartirDeUnValor() {
		double[] coef = {3,1,5};
		Polinomio otroPolinomio = new Polinomio(3,coef);
    
		Assert.assertTrue(otroPolinomio.resolverPolinomio(3) == 35);
	}
	

	@Test
	public void obtenerEscalarAPartirDeUnValorHorner() {
		double[] coef = {3,1,5};
		Polinomio otroPolinomio = new Polinomio(3,coef);
    
		Assert.assertTrue(otroPolinomio.evaluarHorner(3) == 35);
	}	
}
