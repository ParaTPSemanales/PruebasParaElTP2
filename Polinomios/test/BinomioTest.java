import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utilidades.BinomioNewton;

public class BinomioTest {

	BinomioNewton binomio ;
	@Before
	public void setUp() {
		binomio = new BinomioNewton(6,4,-2);
	}

	@Test
	public void queObtengaLosTerminos() {
		int[]resultado = new int[binomio.getGrado()];
		int[]esperado = {1,5,10,10,5,1};
		resultado = binomio.obtenerTerminos(binomio.getGrado());
		
		Assert.assertArrayEquals(esperado, resultado);
	}
	
	
	@Test
	public void queResuelvaBinomio() {
		
		Assert.assertTrue(binomio.resolverBinomio()==64);
	}
}
