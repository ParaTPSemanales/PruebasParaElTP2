package utilidades;

public class BinomioNewton {

	public int[] obtenerTerminosTarta(int nivel) {
		
		
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
		int [] terminos = obtenerTerminosTarta(this.getGrado()+1);// ACa es mas uno porque la cantidad de terminos es  igual al nivel +1
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
		int[] terminos = new int[this.getGrado()+1];
		terminos = obtenerTerminosTarta(this.getGrado() +1);
		for (int i = this.getGrado(), j =0; i >= 0; i--, j++) {
			retorno += terminos[j]* Math.pow(this.x, i) * Math.pow(this.b, j);
		}
		

		return retorno;
	}
	
	//METODO 
	public  double resolverBinomio( final double x, final double b, final int grado,double valor) {
		
		double retorno = 0;
		int[] terminos = new int[grado];
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
		this.tartaglia = new int[grado+1][grado+1];
		
	}
	
	
	
// CONSTRUCTORES
	
	
	public BinomioNewton(int grado) {
		super();
		this.grado = grado;
		this.x = this.b = 0;
		//para utilizar con tartaglia memorizado
		tartaglia = new int[grado+1][grado+1];
		
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
	
	
	public int[][] tartaglia() {
		return tartaglia;
	}

	public void setTartaglia(int[][] tartaglia) {
		this.tartaglia = tartaglia;
	}


	private int grado;
	private double x;
	private double b;
	private int[][] tartaglia ;
	
}