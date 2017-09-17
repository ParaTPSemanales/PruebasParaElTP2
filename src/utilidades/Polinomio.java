package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public double evaluarProgDinamica(double x) {
		double retorno = 0;

		double potencia = 1;

		for (int i = this.getGrado(); i >= 0; i--) {
			retorno += this.getCoeficientes()[i] * potencia;
			potencia *= x; // O(1)
		} // O(n)

		return retorno;
	}

	public double evaluarMejorada(double x) {

		double resultado = 0;
		int i; double j;
		for (i = this.getGrado(), j = 1; i >= 0; i--, j *= x)
			resultado += this.getCoeficientes()[i] * (j);

		return resultado;
	}

	public double evaluarMSucesivas(double x) {

		double retorno = 0;

		for (int i = 0; i <= this.getGrado(); i++)
			retorno += this.getCoeficientes()[i] * potenciaPorMult(x, this.getGrado() - i);// O(n2)

		return retorno;
	}// O(n2)

	public double evaluarRecursiva(double x) {

		double retorno = 0;

		for (int i = 0; i <= this.getGrado(); i++)
			retorno += this.getCoeficientes()[i] * potenciaRecursiva(x, this.getGrado() - i);

		return retorno;
	}// O(n2) Debido a que la recursividad es lineal y anidada al for.

	public double evaluarHorner(double x) {
		double retorno = 0;
     
		if(this.getGrado()==0)
			return this.getCoeficientes()[0];
		
		retorno = this.getCoeficientes()[0] * x + this.getCoeficientes()[1]; // O(1)

		for (int i = 2; i <= this.getGrado(); i++)
			retorno = (retorno * x) + this.getCoeficientes()[i];// O(n-2) = O(n)

		return retorno;
	} // O(n)

	public double evaluarRecursivaPar(double x) {
		double retorno = 0;

		for (int i = 0; i <= this.getGrado(); i++) {
			if (i % 2 != 0)
				retorno += this.getCoeficientes()[i] * potenciaRecursiva(x, this.getGrado() - i);// Impar
			else
				retorno += this.getCoeficientes()[i] * potenciaRecursivaPar(x, this.getGrado() - i);// Par
		} // O(n) y anidada con la recursiva es O(n2)

		return retorno;
	}

	public double evaluarPow(double x) {

		double retorno = 0;
		for (int i = 0; i <= this.getGrado(); i++)
			retorno += this.getCoeficientes()[i] * Math.pow(x, this.getGrado() - i);

		return retorno;
	}

	public double potenciaPorMult(double numero, int potencia) {

		double retorno = 1;

		for (int i = potencia; i > 0; i--)
			retorno *= numero;

		return retorno;
	}

	public double potenciaRecursiva(double numero, int potencia) {

		if (potencia ==	0)
			return 1;
		else
			return numero * potenciaRecursiva(numero, potencia - 1);
	}

	public double potenciaRecursivaPar(double numero, int potencia) {

		if (potencia == 0)
			return 1;
		if ((potencia % 2) == 0)
			return potenciaRecursivaPar(numero * numero, potencia / 2); //Exponente Par		
		return numero * potenciaRecursivaPar(numero, potencia - 1 );//Exponente Impar
	}

	public Polinomio(int grado) {

		double[] coeficientes = new double[grado];
		for (int i = 0; i < grado; i++)
			coeficientes[i] = 1;
		this.setCoeficientes(coeficientes);
	}

	public Polinomio(int grado, double[] coeficientes) {
		super();
		this.grado = grado;
		this.coeficientes = coeficientes;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public double[] getCoeficientes() {
		return coeficientes;
	}

	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}
	
	// Crea un Polinomio desde un archivo de entrada
	// No lee el valor de x del archivo
	public Polinomio(final String path) {
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			file = new File(path);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			this.grado = Integer.parseInt(bufferedReader.readLine());
			double[] coeficientes = new double[this.grado + 1];
			String[] arrayDeString = bufferedReader.readLine().split(" ");
			
			for (int i = 0; i < arrayDeString.length; i++) {
				coeficientes[i] = Double.parseDouble(arrayDeString[i]);
			}
			this.setCoeficientes(coeficientes);
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polinomio other = (Polinomio) obj;
		if (this.grado != other.grado)
			return false;
		for (int i = 0; i < this.coeficientes.length; i++) {
			if (this.coeficientes[i] != other.coeficientes[i]){
				return false;
			}
		}
		return true;
	}

}