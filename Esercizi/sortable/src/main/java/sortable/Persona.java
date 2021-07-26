package sortable;

class Persona implements Comparable {

	private int eta;
	private String nome;

	public Persona(int eta, String nome) {
		this.eta = eta;
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Persona [eta=" + eta + " nome="+nome+"]";
	}

	public int compareTo(Object other) {
		Persona tmp = (Persona) other;
		return eta-tmp.eta;
	}

}
