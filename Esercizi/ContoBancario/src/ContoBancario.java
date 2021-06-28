class ContoBancario {

	private String iban;
	private double bilancio;

	public ContoBancario(String iban, double bilancio) {
		this.iban = iban;
		this.bilancio = bilancio;
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

	public ContoConFido(String iban, double bilancio, double fido) {
		super(iban, bilancio);
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
		double bilancio = getBilancio();
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
			setBilancio(-rosso);
		}

	}

	@Override
	public String toString() {
		return "ContoConFido [fido=" + fido + " rosso=" + rosso + "]";
	}

}
