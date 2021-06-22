package rubrica;

// La classe genera oggetti immutabili
public class NumeroTelefonico {
	
	private String tipo; // casa, lavoro, cellulare, ufficio, ...
	private String numero; // 333 1122333, 0987 112277
	
	
	public NumeroTelefonico(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}// costruttore
	
	public String getTipo() {
		return tipo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String toString() {
		return tipo + ": " + numero;
	}
	
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this==o)
			return true;
		if(!(o instanceof NumeroTelefonico))
			return false;
		NumeroTelefonico n = (NumeroTelefonico) o;
		
		return this.tipo.equals(n.tipo) && this.numero.equals(n.numero);
	}

}// NumeroTelefonico