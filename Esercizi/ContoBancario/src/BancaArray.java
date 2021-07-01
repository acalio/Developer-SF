class BancaArray {

	private static int CODICE_CLIENTE = 0; // auto-increment -> identifica un cliente
	private static int CODICE_IBAN = 0; // auto-increment -> identifica un conto

	private String address;
	private String name;
	private String code;
	private ContoBancario[] accounts = new ContoBancario[10]; // alloco 10 posizioni
	private Cliente[] clients = new Cliente[10]; // alloco 10 posizioni

	public BancaArray(String address, String name, String code) {
		this.name = name;
		this.address = address;
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Cliente[] getClients() {
		return clients;
	}

	public void setClients(Cliente[] clients) {
		this.clients = clients;
	}

	public ContoBancario[] getAccounts() {
		return accounts;
	}

	public void setAccounts(ContoBancario[] accounts) {
		this.accounts = accounts;
	}

	public void aprireConto(Cliente c) {
		int posCliente = cercaCliente(c);
		if (posCliente == clients.length) {
			// cliente non presente
			c.setCode(CODICE_CLIENTE++);
			//inserirlo nell'array clients
			int pos = Utility.primaPosizioneNull(clients);
			if (pos == clients.length) {
			    clients = Utility.raddoppiaClienti(clients);//riallocare array
			}
			clients[pos] = c;
		}


		// Creo il conto bancario
		ContoBancario cb = new ContoBancario(Integer.toString(CODICE_IBAN++), 0, c);

		// salvo il contobancario
		int posAccount = Utility.primaPosizioneNull(accounts);
		if (posAccount == accounts.length) 
		    //raddoppio
			accounts = Utility.raddoppiaConti(accounts);
		
		accounts[posAccount] = cb;
	}

	/**
	 * Prende in input un cliente e restituisce: l'indice della sua posizione. Se il
	 * cliente non è presente restituisce il valore di clients.length
	 *
	 */
	private int cercaCliente(Cliente c) {
		int pos = 0;
		for (; pos < clients.length; pos++)
			if (c.equals(clients[pos]))
				break;
		return pos;

	}

	public void chiudiConto(String codiceIban) {
	}

	public Cliente getCorrentista(String codiceConto) {
		return null;
	}

	public ContoBancario[] getConti(String codiceCliente) {
		return null;
	}

}
