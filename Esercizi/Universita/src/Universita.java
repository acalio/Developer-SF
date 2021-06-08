public class Universita {

    /**
     * Docenti
     */
    private Docente[] docenti;

    /**
     * Numero di docenti per ogni ruolo
     * pos: 0 -> ricercatore, 1 -> associato, 2 -> ordinario
     */
    private int[] ruoli = {0, 0 ,0};

    /**
     * Nome universita
     */
    private String nome;


    /**
     * Indirizzo Universita
     */
    private String indirizzo;


    public Universita() {}

    public Universita(String name,
		      String indirizzo,
		      Docente[] docenti) {

	this.nome = name;
	this.indirizzo = indirizzo;
	this.docenti = docenti;

	//inizializzare array di ruoli
	for (Docente d : docenti) 
	    ruoli[d.getRole()]++;

	
    }

    public String getNome() {
	return nome;
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

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("Universita [");
	sb.append("nome=" + nome + " indirizzo="+indirizzo);
	//stampiamo tutti i docenti
	sb.append("Docenti\n");
	for(Docente d : docenti)
	    sb.append(d.toString() + "\n");

	//stampiamo il numero di docenti per ogni ruolo
	sb.append("Ricercatori: " + ruoli[0]+"\n");
	sb.append("Associati: " + ruoli[1]+"\n");
	sb.append("Ordinari: " + ruoli[2]+"\n");
	
	return sb.toString();
    }    

    



}
