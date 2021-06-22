package rubrica;

// La classe genera oggetti mutabili
public class Contatto {

	private String nome, cognome, email;
	private NumeroTelefonico[] numeri;
	private int numeriMemorizzati;
	
	public Contatto(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		email = null;
		numeri = new NumeroTelefonico[5];
		numeriMemorizzati = 0;
	}
	
	public Contatto(String nome, String cognome, NumeroTelefonico n) {
		this.nome = nome;
		this.cognome = cognome;
		email = null;
		numeri = new NumeroTelefonico[5];
		numeri[0] = n;
		numeriMemorizzati = 1;
	}
	
	public Contatto(Contatto c) {
		nome = c.nome;
		cognome = c.cognome;
		email = c.email;
		numeriMemorizzati = c.numeriMemorizzati;
		numeri = new NumeroTelefonico[c.numeri.length];
		for(int i=0; i<c.numeriMemorizzati; i++)
			numeri[i] = c.numeri[i];
	}// cotruttore per copia

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	// SPIEGARE IF TERNARIO
	public String getEmail() {
		return email==null?"":email;
//		if(email==null)
//			return "";
//		else
//			return email;
	}

	public int getNumeriMemorizzati() {
		return numeriMemorizzati;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public NumeroTelefonico estraiNumero(String tipo) {
		NumeroTelefonico ris = null;
		for(int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].getTipo().equals(tipo)) {
				ris = numeri[i];
				break;
			}
		return ris;
	}// estraiNumero
	
	
	public void aggiungiNumero(NumeroTelefonico n) {
		if(numeriMemorizzati < numeri.length) {
			// numeri = [n1, n2, n3, null, null], numeriMemorizzati = 3
			numeri[numeriMemorizzati] = n;
		} else { // numeriMemorizzati == numeri.length
			// numeri = [n1, n2, n3, n4, n5], numeriMemorizzati = 5
			NumeroTelefonico[] nuovo = new NumeroTelefonico[numeriMemorizzati * 2]; // 10 celle
			for(int i=0; i<numeriMemorizzati; i++)
				nuovo[i] = numeri[i];
			// nuovo = [n1, n2, n3, n4, n5, null, null, null, null, null], numeriMemorizzati = 5
			numeri = nuovo;
			numeri[numeriMemorizzati] = n;
			// nuovo = [n1, n2, n3, n4, n5, n, null, null, null, null]
		}
		numeriMemorizzati++;
	}// aggiungiNumero
	
	
	public void eliminaNumero(int indice) {
		// numeri = [n1, n2, n3, null, null], numeriMemorizzati = 3, indice = 1
		NumeroTelefonico[] nuovo = new NumeroTelefonico[numeri.length];
		// nuovo = [null, null, null, null, null]
		for(int i=0; i<indice; i++)
			nuovo[i] = numeri[i];
		// nuovo = [n1, null, null, null, null]
		for(int i=indice+1; i<numeriMemorizzati; i++)
			nuovo[i-1] = numeri[i];
		// nuovo = [n1, n3, null, null, null]
		numeriMemorizzati--;
		numeri = nuovo;
	}// eliminaNumero
	
	public void eliminaNumero2 (int indice) {
		// numeri = [n1, n2, n3, null, null], numeriMemorizzati = 3, indice = 1
		for(int i=indice+1; i<numeriMemorizzati; i++)
			numeri[i-1] = numeri[i];
		// numeri = [n1, n3, n3, null, null]
		numeri[numeriMemorizzati-1] = null; // OPZIONALE
		// numeri = [n1, n3, null, null, null]
		numeriMemorizzati--; // 2
	}// eliminaNumero2
	
	
	public void eliminaNumero(NumeroTelefonico n) {
		int indice = -1;
		for(int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].equals(n)) {
				indice = i;
				break;
			}
		if(indice!=-1)
			eliminaNumero(indice);
	}// eliminaNumero
	
	
	public void eliminaNumero(String tipo) {
		int indice = -1;
		for (int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].getTipo().equals(tipo)) {
				indice = i;
				break;
			}
		if(indice!=-1)
			eliminaNumero(indice);
	}// eliminaNumero
	
	
	public String toString() {
		String ret = "=======================================\n";
		ret += nome + " " + cognome + "\n";
		if(email!=null)
			ret += "Email: " + email + "\n";
		for(int i=0; i<numeriMemorizzati; i++)
			ret += numeri[i] + "\n"; // ret += numeri[i].toString() + "\n";
		ret += "=======================================\n";
		return ret;
	}// toString
	
	
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(this==o)
			return true;
		if(!(o instanceof Contatto))
			return false;
		Contatto c = (Contatto) o;
		
		if(!nome.equals(c.nome)  || !cognome.equals(c.cognome) || !getEmail().equals(c.getEmail())
				|| numeriMemorizzati!=c.numeriMemorizzati)
			return false;
		for(int i=0; i<numeriMemorizzati; i++)
			if(!numeri[i].equals(c.numeri[i]))
				return false;
		return true;
	}// equals
	
	
}// Contatto





































