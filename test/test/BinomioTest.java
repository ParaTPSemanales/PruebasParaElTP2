package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utilidades.BinomioNewton;

public class BinomioTest {

	BinomioNewton binomio ;
	@Before
	public void setUp() {
		binomio = new BinomioNewton(2,4,-2);
	}

	@Test
	public void queObtengaLosTerminosConTartaglia() {
		int[]resultado = new int[binomio.getGrado()];
		int[]esperado = {1,2,1};
		resultado = BinomioNewton.obtenerTerminosTarta(binomio.getGrado() + 1);
		
		Assert.assertArrayEquals(esperado, resultado);
	}
	
	
	@Test
	public void queResuelvaBinomio() {
		
		Assert.assertTrue(binomio.resolverBinomio()==4);
	}
	
	@Test
	public void queResuelvaBinomioEstatico() {

		Assert.assertTrue(BinomioNewton.resolverBinomio(3, 5, 2,1)==64);
	}
	
	@Test
	public void queMuestreElBinomio() {
		String resultado = "+16.0X2-16.0X1+4.0X0";
		Assert.assertEquals(resultado, binomio.mostrarBinomioResuelto());
	}
}
