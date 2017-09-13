package utilidades;


public class Polinomio {
	
	public double evaluarProgDinamica(double x) {
		double retorno = 0;
		
		double potencia = 1;
		
		for (int i = this.getGrado(); i >= 0; i--) {
			retorno += this.getCoeficientes()[i]*potencia;
			potencia *= x; //O(1)
		}//O(n)
		
		return retorno;
	}
	
	
	public double evaluarMSucesivas(double x) {
		
	double retorno = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
			retorno += this.getCoeficientes()[i]*potenciaPorMult(x, this.getGrado() - i );//O(n2)
		
		return retorno;
	}
	
	public double evaluarRecursiva(double x) {
		
	double retorno = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
			retorno += this.getCoeficientes()[i]*potenciaRecursiva(x, this.getGrado() - i );
		
		return retorno;
	}
	
	public double evaluarHorner(double x) {
		double retorno = 0;
		
		retorno = this.getCoeficientes()[0]*x + this.getCoeficientes()[1];
		
		for (int i = 2; i <= this.getGrado(); i++) 
			retorno = (retorno*x) + this.getCoeficientes()[i];
		

		return retorno;
	}
	
	
	public double evaluarRecursivaPar(double x){
	double retorno = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
		{
			if(i % 2 != 0)
				retorno += this.getCoeficientes()[i]*potenciaRecursiva(x, this.getGrado() - i );//Impar
			else
				retorno += this.getCoeficientes()[i]*potenciaRecursivaPar(x, this.getGrado() - i );//Par
		}
			
		
		return retorno;
	}
	
	
	public double evaluarPow(double x){
		
		double retorno = 0;
		for(int i = 0; i <= this.getGrado(); i ++)
			retorno += this.getCoeficientes()[i]* Math.pow(x,this.getGrado()-i);
			
	return retorno;
	}
	public double potenciaPorMult(double numero, int potencia){
		
		double retorno = 1;
		
		for (int i = potencia; i > 0; i--) 
			retorno *= numero;
			
		
		return retorno;
	} 
	
	public double potenciaRecursiva(double numero, int potencia) {
		
		if(potencia == 0)
			return 1;
		else
			return numero*potenciaRecursiva(numero, potencia -1);
	}
	
	public double potenciaRecursivaPar(double numero, int potencia) {
		
		if(potencia == 0)
			return 1;
		else
			return numero*potenciaRecursiva(numero*numero, potencia /2);
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
