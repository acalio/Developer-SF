class ContoBancario {

	protected String iban;
	protected double bilancio;
	protected Cliente proprietario;

	public ContoBancario(String iban, double bilancio, Cliente prop) {
		this.iban = iban;
		this.bilancio = bilancio;
		this.proprietario = prop;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getBilancio() {
		return bilancio;
	}

	public void setBilancio(double bilancio) {
		this.bilancio = bilancio;
	}

	public Cliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}

	public boolean preleva(double somma) {
		boolean prelievo;
		if (prelievo = (somma <= bilancio))
			bilancio -= somma;
		return prelievo;

	}

	public void deposita(double somma) {
		bilancio += somma;
	}

	@Override
	public String toString() {
		return "ContoBancario [iban=" + iban + " bilancio=" + bilancio + "]";
	}

}

class ContoConFido extends ContoBancario {

	private double fido;
	private double rosso;

	public ContoConFido(String iban, double bilancio, Cliente prop, double fido) {
		super(iban, bilancio, prop);
	}

	public double getFido() {
		return fido;
	}

	public void setFido(double fido) {
		this.fido = fido;
	}

	public double getRosso() {
		return rosso;
	}

	public void setRosso(double rosso) {
		this.rosso = rosso;
	}

	public boolean preleva(double somma) {
		if (somma > bilancio + (fido - rosso))
			return false;

		double sommaFido = bilancio - somma < 0 ? somma - bilancio : 0;
		rosso += sommaFido;
		return super.preleva(somma - sommaFido);
	}

	public void deposita(double somma) {
		if (rosso > 0)
			rosso -= somma; // diminuisco il debito
		if (rosso < 0) {
			rosso = 0;
			bilancio = -rosso;
		}

	}

	@Override
	public String toString() {
		return "ContoConFido [fido=" + fido + " rosso=" + rosso + "]";
	}

}
