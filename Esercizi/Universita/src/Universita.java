public class Universita {
	/**
	 * Nome universita
	 */
	private String nome;

	/**
	 * Indirizzo Universita
	 */
	private String indirizzo;

	/**
	 * Docenti
	 */
	private Docente[] docenti;

	/**
	 * Numero di docenti per ogni ruolo pos: 0 -> ricercatore, 1 -> associato, 2 ->
	 * ordinario
	 */
	private int[] ruoli = { 0, 0, 0 };

        /**
	 * Costruttore
	 *
	 */
	public Universita() {}

        /**
	 * Costruttore
	 * @param name : String - nome universitya
	 * @param indirizzo : String - indirizzo universita
	 * @param docenti : Docente[] - collezioni 
	 */
	public Universita(String name, String indirizzo, Docente[] docenti) {

		this.nome = name;
		this.indirizzo = indirizzo;
		this.docenti = docenti;

		// inizializzare array di ruoli
		for (Docente d : docenti)
			ruoli[d.getRole()]++;

	}

        public String getNome(){
	    return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getRuoli() {
		return ruoli;
	}

	public void setRuoli(int[] ruoli) {
		this.ruoli = ruoli;
	}

	public Docente[] getDocenti() {
		return docenti;
	}

	public void setDocenti(Docente[] docenti) {
		this.docenti = docenti;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

        /**
	 * Ricevo in ingresso un oggetto di tipo docente
	 * Restituisco true se il docente e presente 
	 * nella array docenti 
	 */
	public boolean trovaDocenteRef(Docente d) {
	    //modificarlo per utilizzre equalsto
	    
	    //testo se il riferimento a cui punta d
	    //e presente nell'array docenti
	    for (int i = 0; i < docenti.length; i++) {
		Docente dtmp = docenti[i];  //dtmp -> docenti[i] (alias) 
		if(dtmp == d) // stiamo confontando i riferimenti
		    return true;
	    }
	    //equivalente a quanto sopra
	    // for(Docente dtmp : docenti)
	    // 	if(dtmp == d)
	    // 	    return true
		

	    return false;
	}


    	public boolean trovaDocenteEq(Docente d) {
	    //modificarlo per utilizzre equalsto
	    //equivalente a quanto sopra
	    for(Docente dtmp : docenti)
		if(d.equals(dtmp))
		    return true;
	    return false;
	}


        public Docente trovaDocente(int matricola) {
		for (Docente d : docenti) {
		    if (d.getCode() == matricola)
			return d;
		}
		return null;
	}

	public void promuovi(Docente d) {
//		int newRole = d.getRole() + 1; // nuovo ruole del docente, il vecchio ruolo era d.getRole()
		if (d.getRole() < 2) {
			ruoli[d.getRole()]--;
//			d.setRole(newRole); //aggiorno il valore di role di d
			d.setRole(d.getRole()+1);
			ruoli[d.getRole()]++;
		}
	}

	public void retrocedi(Docente d) {
		if (d.getRole() > 0) {
			ruoli[d.getRole()]--;
			d.setRole(d.getRole() - 1);
			ruoli[d.getRole()]++;
		}

	}

	public Docente piuGiovane() {
		Docente younger = docenti[0]; // più giovane
		for (Docente doc : docenti) {
			if (doc != null)
				if (younger.getAge() > doc.getAge())
					younger = doc;
		}
		return younger;
	}

	// docente più anziano per un determinato ruolo
	public Docente piuAnzianoPerRuolo(int role) {
		Docente olderForRole = null;
		for (Docente doc : docenti) {
			if (doc != null)
				if (doc.getRole() == role) {
					if (olderForRole == null)//prima volta che trovo un docente di quel ruolo
						olderForRole = doc;
					if (olderForRole.getAge() < doc.getAge())
						olderForRole = doc;
				}
		}
		return olderForRole;
	}

	public void setRoleDocente() {

	}

	public void addDocente(Docente d) {
		if (docenti[docenti.length - 1] != null) {
			docenti = resize(docenti);
		}
		
		int i = 0;
		while (docenti[i] != null) {
			i++;
		}
		docenti[i] = d;
		ruoli[d.getRole()]++;

	}

	private Docente[] resize(Docente[] docenti) {

		Docente[] tmp = new Docente[2 * docenti.length];
		System.arraycopy(docenti, 0, tmp, 0, docenti.length);
		docenti = tmp;
		return docenti;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Universita [");
		sb.append("nome=" + nome + " indirizzo=" + indirizzo);

		// stampiamo tutti i docenti
		sb.append("\nDocenti\n");
		for (Docente d : docenti)
			if (d != null)
				sb.append(d.toString() + "\n");

		// stampiamo il numero di docenti per ogni ruolo
		sb.append("Ricercatori: " + ruoli[0] + "\n");
		sb.append("Associati: " + ruoli[1] + "\n");
		sb.append("Ordinari: " + ruoli[2] + "\n");

		return sb.toString();
	}

}

