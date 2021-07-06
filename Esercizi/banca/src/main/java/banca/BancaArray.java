package banca;
import banca.exceptions.ContoNonTrovato;
import banca.exceptions.ConversioneException;


class BancaArray {

	public enum TipoConto {
		CONTO_SEMPLICE, // -> 0
		CONTO_FIDO// -> 1
	}

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

	public void aprireConto(Cliente c, TipoConto tc) {
		//controllo se il cliente è gia presente nel sistema
		int posCliente = Utility.cerca(this.clients, c); 
		if (posCliente == -1) {
			// cliente non presente
			c.setCode(Integer.toString(CODICE_CLIENTE++));
			// inserirlo nell'array clients
			int pos = Utility.primaPosizioneNull(clients);
			if (pos == clients.length) {
				clients = Utility.raddoppia(clients);// riallocare array
			}
			clients[pos] = c;
		} 

		// Creo il conto bancario
		ContoBancario cb = null;
		switch (tc) {
		case CONTO_SEMPLICE:
			cb = new ContoBancario(Integer.toString(CODICE_IBAN++), 0, c);
			break;
		case CONTO_FIDO:
			cb = new ContoConFido(Integer.toString(CODICE_IBAN++), 0, c, 0);
		}

		// salvo il contobancario
		int posAccount = Utility.primaPosizioneNull(accounts);
		if (posAccount == accounts.length)
			// raddoppio
			accounts = Utility.raddoppia(accounts);
		accounts[posAccount] = cb;
	}


	public void chiudiConto(String codiceIban) throws ContoNonTrovato {
		int pos = cercaConto(codiceIban);
        //rimuovo il conto
        accounts[pos] = null; // accounts = [c1, c2, null, c3, c4]
        Utility.shift(this.accounts, pos);
	}

	public Cliente getCorrentista(String codiceIban) throws ContoNonTrovato {
        int pos = cercaConto(codiceIban);
        return this.accounts[pos].getProprietario();

	}

	public ContoBancario[] getConti(String codiceCliente) {
		//conto numero di conti
        int cnt = 0;
		for (int i = 0; i<accounts.length && accounts[i]!=null; i++) 
			if(accounts[i].getProprietario().getCode().equals(codiceCliente))
                cnt++;
		
        ContoBancario[] conti = new ContoBancario[cnt];
        int pos = 0;
		for (int i = 0; i<accounts.length && accounts[i]!=null; i++) 
			if(accounts[i].getProprietario().getCode().equals(codiceCliente))
                conti[pos++] = accounts[i];
        return conti;
	}


    public void cambiaConto(String codiceIban, TipoConto nuovoTipo) throws ContoNonTrovato, ConversioneException {
        int pos = cercaConto(codiceIban);
        ContoBancario cb = accounts[pos];
        if(cb instanceof ContoBancario && nuovoTipo==TipoConto.CONTO_FIDO) {
            //cambio in conto con fido
            accounts[pos] = new ContoConFido(cb.getIban(),cb.getBilancio(),cb.getProprietario(),0);

        } else if(cb instanceof ContoConFido && nuovoTipo==TipoConto.CONTO_SEMPLICE) {
            ContoConFido cf = (ContoConFido) cb; 
            if(cf.getRosso()>0)
                throw new ConversioneException(codiceIban);
            accounts[pos] = new ContoBancario(cf.getIban(), cf.getBilancio(), cf.getProprietario());
        }
    }

    private int cercaConto(String codiceIban) throws ContoNonTrovato {
    	int pos = 0;
		for (; pos<accounts.length; pos++) 
			if(this.accounts[pos].getIban().equals(codiceIban))
				return pos;
        throw new ContoNonTrovato(codiceIban);
    }

	@Override
	public String toString() {
		StringBuilder bf = new StringBuilder();
		bf.append("Banca: "+ name);
		bf.append("Indirizzo: "+address);
		bf.append("Conti\n=============\n\t");
		for (int i = 0; i<accounts.length && accounts[i]!=null; i++)
			bf.append("\t" + accounts[i] + "\n");

		bf.append("Clienti\n=============\n\t");
		for (int i = 0; i<clients.length && clients[i]!=null; i++)
			bf.append("\t" + clients[i] + "\n");
		
		return bf.toString();
	}


	


}

