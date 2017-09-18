package utilidades;

public class BinomioNewton {
	/*
	
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

*/
	
	public double evaluarMSucesivas(double x) {

		double retorno = 0;
		retorno = potenciaPorMult((this.getX()*x)+this.getB(), this.getGrado());// O(n2)
		return retorno;
	}
	
	public double evaluarRecursiva(double x) {

		double retorno = 0;
		for (int i = 0; i <= this.getGrado(); i++)
			retorno=potenciaRecursiva((this.getX()*x)+this.getB(), this.getGrado());

		return retorno;
	}
	
	/* FALTA HACER HORNER
	public double evaluarHorner(double x) {
		double retorno = 0;
     
		if(this.getGrado()==0)
			return this.getCoeficientes()[0];
		
		retorno = this.getCoeficientes()[0] * x + this.getCoeficientes()[1]; // O(1)

		for (int i = 2; i <= this.getGrado(); i++)
			retorno = (retorno * x) + this.getCoeficientes()[i];// O(n-2) = O(n)

		return retorno;
	} 
	
	*/
	public double evaluarRecursivaPar(double x) {
		double retorno = 0;

		for (int i = 0; i <= this.getGrado(); i++) {
			if (i % 2 != 0)
				retorno=potenciaRecursiva((this.getX()*x)+this.getB(), this.getGrado());// Impar
			else
				retorno =potenciaRecursivaPar((this.getX()*x)+this.getB(), this.getGrado());// Par
		} // O(n) y anidada con la recursiva es O(n2)

		return retorno;
	}
	
	
	public double evaluarPow(double x) {
		double retorno = 0;
		retorno = Math.pow((this.getX()*x)+this.getB(), this.getGrado());
		return retorno;
	}

	public double[] obtenerTerminosTarta(int nivel) {
		
		
		//Si ya esta calculado, entonces lo devuelvo
		if(tartaglia[nivel-1][0] != 0)
			return tartaglia[nivel-1];
		
	    for(int i = 0 ; i < nivel; i++)
	    {    
	    	// SI el nivel esta calculado, entonces lo paso.
	    
	        if(tartaglia[i][0] == 0){
	        	tartaglia[i][0] = 1;
	        	 for(int j= 1 ; j  <= i ; j++)
	        		  tartaglia[i][j]  = tartaglia[i-1][j-1]+ tartaglia[i-1][j];
	        }
	       
	    }
		
		return tartaglia[nivel-1];
			
	}
	
	public String mostrarBinomioResuelto() {
		
		StringBuffer sb = new StringBuffer();
		double [] terminos = obtenerTerminosTarta(this.getGrado()+1);// ACa es mas uno porque la cantidad de terminos es  igual al nivel +1
		double temporal;
		for(int i = 0, j = this.getGrado(); i <= this.getGrado() ; j--,i ++) {
			
			temporal = terminos[i]*Math.pow(this.getX(), j)*Math.pow(this.getB(),i);
			if(temporal > 0)
			sb.append("+");
			sb.append(temporal);
			sb.append("X");
			sb.append(j);
			
		}
		return sb.toString();
	}
	
	public  double resolverBinomio() {
		//Resuelve con metodo POW y 
		double retorno = 0;
		double[] terminos = new double[this.getGrado()+1];
		terminos = obtenerTerminosTarta(this.getGrado() +1);
		for (int i = this.getGrado(), j =0; i >= 0; i--, j++) {
			retorno += terminos[j]* Math.pow(this.x, i) * Math.pow(this.b, j);
		}
		

		return retorno;
	}
	
	//METODO 
	public  double resolverBinomio( final double x, final double b, final int grado,double valor) {
		
		double retorno = 0;
		double[] terminos = new double[grado];
		double auxX = Math.pow(x, grado);
		double auxB = 1;
		terminos = obtenerTerminosTarta(grado+1);
		
		for (int i = grado, j =1; i >= 0; i--, j++) {
			retorno += terminos[j-1] * (valor*auxX) * auxB;
			auxX/=x;
			auxB*=b;
		}
			
		

		return retorno;
	}
	
	public BinomioNewton(int grado, double x, double b) {
		super();
		this.grado = grado;
		this.x = x;
		this.b = b;
		this.tartaglia = new double[grado+1][grado+1];
		
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
	
// CONSTRUCTORES
	
	
	public BinomioNewton(int grado) {
		super();
		this.grado = grado;
		this.x = this.b = 0;
		//para utilizar con tartaglia memorizado
		tartaglia = new double[grado+1][grado+1];
		
	}

	
	public BinomioNewton() {
		
		this(0,0,0);
	}
	
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public double getX() {
		return x;
	}
	public void setX(double coeficienteA) {
		this.x = coeficienteA;
	}
	public double getB() {
		return b;
	}
	public void setB(double coeficienteB) {
		this.b = coeficienteB;
	}
	
	public double[][] tartaglia() {
		return tartaglia;
	}

	public void setTartaglia(double[][] tartaglia) {
		this.tartaglia = tartaglia;
	}


	private int grado;
	private double x;
	private double b;
	private double[][] tartaglia ;
	
}