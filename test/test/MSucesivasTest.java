package test;

import utilidades.Polinomio;
import org.junit.Assert;
import org.junit.Test;

public class MSucesivasTest {

	@Test
	public void queLeaPolinomioDeArchivo(){
		String casoDePrueba = "02_polinomioGrado2";
		PolinomiosTest  polinomioTest = new PolinomiosTest("PreparacionDePrueba/LoteDePrueba/Entrada/" + casoDePrueba + ".in");
		double[] coef = {3,1,5};
		Polinomio auxPolinomio = new Polinomio(2,coef);
		Assert.assertTrue(polinomioTest.polinomio.equals(auxPolinomio));
	}
	
	@Test
	public void queEvalueBienPolinomioGrado1(){
		String casoDePrueba = "01_polimonioGrado1";
		PolinomiosTest  polinomioTest = new PolinomiosTest("PreparacionDePrueba/LoteDePrueba/Entrada/" + casoDePrueba + ".in");

		Assert.assertTrue(polinomioTest.polinomio.evaluarMSucesivas(polinomioTest.x)==93);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado2(){
		String casoDePrueba = "02_polinomioGrado2";
		PolinomiosTest  polinomioTest = new PolinomiosTest("PreparacionDePrueba/LoteDePrueba/" + "Entrada/" + casoDePrueba + ".in");

		Assert.assertTrue(polinomioTest.polinomio.evaluarMSucesivas(polinomioTest.x)==35);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado3(){
		String casoDePrueba = "03_polinomioGrado3";
		PolinomiosTest  polinomioTest = new PolinomiosTest("PreparacionDePrueba/LoteDePrueba/" + "Entrada/" + casoDePrueba + ".in");

		Assert.assertTrue(polinomioTest.polinomio.evaluarMSucesivas(polinomioTest.x)==1960);
	}
	
	@Test
	public void queEvalueBienPolinomioGrado20(){
		String casoDePrueba = "04_polinomioGrado20";
		PolinomiosTest  polinomioTest = new PolinomiosTest("PreparacionDePrueba/LoteDePrueba/" + "Entrada/" + casoDePrueba + ".in");

		Assert.assertTrue(polinomioTest.polinomio.evaluarMSucesivas(polinomioTest.x)==7845136);
	}
}
