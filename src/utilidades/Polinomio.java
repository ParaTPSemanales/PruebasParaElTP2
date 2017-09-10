package utilidades;


public class Polinomio {
	
	public void evaluarProgDinamica() {
		
		///FALTA RESOLVER
	}
	
	
		
	
	public double resolverPolinomio(double x) {
		
	double retorno = 0;
		
		for (int i = 1; i <= this.getGrado(); i++) 
			retorno += this.getCoeficientes()[i-1]*evaluarRecursiva(x, this.getGrado() - i );
		
		return retorno;
	}
	
	public double evaluarHorner(double numero) {
		
		double [] auxiliar =new double[this.getGrado()-1];
		
		auxiliar[this.getGrado()-1] = this.getCoeficientes()[this.getGrado()-1];
		for (int i = this.getGrado()-1; i >= 0; i--) {
			auxiliar[i] = this.getCoeficientes()[i]  + auxiliar[i+1] * numero;
		}
		
		return auxiliar[0];
	}
	
	public double evaluarMSucesivas(double numero, int potencia){
		
		double retorno = 1;
		
		for (int i = potencia; i > 0; i--) 
			retorno *= numero;
			
		
		return retorno;
	} 
	
	public double evaluarRecursiva(double numero, int potencia) {
		
		if(potencia == 0)
			return 1;
		else
			return numero*evaluarRecursiva(numero, potencia -1);
	}
	
	
	
	public Polinomio(int grado){
		
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
	
	private int grado;
	private double[] coeficientes;
	
	
	
}
