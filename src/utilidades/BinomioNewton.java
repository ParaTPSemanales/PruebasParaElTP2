package utilidades;

public class BinomioNewton {

	public int[] obtenerTerminos(int nivel) {
		
		int[] resultado = new int[nivel];
		int[][] tartaglia = new int[nivel][nivel];
		
	    for(int i = 0 ; i < nivel; i++)
	    {
	        tartaglia[i][0] = 1;
	        for(int j= 1 ; j  <= i ; j++)
	                tartaglia[i][j]  = tartaglia[i-1][j-1]+ tartaglia[i-1][j];
	    }
		for (int i = 0; i < tartaglia[nivel -1].length; i++) {
			resultado[i] = tartaglia[nivel -1][i];
		}
		return resultado;
			
	}
	
	public String mostrarBinomio() {
		
		StringBuffer sb = new StringBuffer();
		int [] terminos = this.obtenerTerminos(this.getGrado() +1);
		double temporal;
		for(int i = 0, j = this.getGrado(); i <= this.getGrado() ; j--,i ++) {
			
			temporal = terminos[i]*Math.pow(this.getCoeficienteA(), j)*Math.pow(this.getCoeficienteB(),i);
			if(temporal > 0)
			sb.append("+");
			sb.append(temporal);
			sb.append("X");
			sb.append(j);
			
		}
		return sb.toString();
	}
	
	public double resolverBinomio() {
		
		double retorno = 0;
		int[] terminos = new int[this.getGrado()];
		terminos = this.obtenerTerminos(this.getGrado()+1);
		for (int i = this.getGrado(), j =0; i >= 0; i--, j++) {
			retorno += terminos[j]* Math.pow(this.coeficienteA, i) * Math.pow(this.coeficienteB, j);
		}
		

		return retorno;
	}
	
	
	public BinomioNewton(int grado, double coeficienteA, double coeficienteB) {
		super();
		this.grado = grado;
		this.coeficienteA = coeficienteA;
		this.coeficienteB = coeficienteB;
	}
	public BinomioNewton(int grado) {
		super();
		this.grado = grado;
		this.coeficienteA = this.coeficienteB = 1;
	}
	
	public BinomioNewton(int grado, double coeficiente, boolean esX) {
		super();
		this.grado = grado;


		if(esX){
			this.coeficienteA = coeficiente;
			this.coeficienteB = 0;
		}else {
			this.coeficienteB = coeficiente;
			this.coeficienteA = 0;
		}
		
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
	public double getCoeficienteA() {
		return coeficienteA;
	}
	public void setCoeficienteA(double coeficienteA) {
		this.coeficienteA = coeficienteA;
	}
	public double getCoeficienteB() {
		return coeficienteB;
	}
	public void setCoeficienteB(double coeficienteB) {
		this.coeficienteB = coeficienteB;
	}
	
	
	private int grado;
	private double coeficienteA;
	private double coeficienteB;
	
	
}
