package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import utilidades.Polinomio;

// Clase que se utiliza para crear un polinomio y guardar el valor de x
// para luego poder usarlo en los test
public class PolinomiosTest {
	
	public Polinomio polinomio;
	public double x;

	// Crea un Polinomio desde un archivo de entrada
	public PolinomiosTest(final String path) {
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			file = new File(path);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			int grado = Integer.parseInt(bufferedReader.readLine());
			double[] coeficientes = new double[grado + 1];
			String[] arrayDeString = bufferedReader.readLine().split(" ");
			this.x = Double.parseDouble(bufferedReader.readLine());

			for (int i = 0; i < arrayDeString.length; i++) {
				coeficientes[i] = Double.parseDouble(arrayDeString[i]);
			}
			polinomio = new Polinomio(grado, coeficientes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
}
