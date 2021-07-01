class Utility {

    /**
     * Metodo che restituisce la prima posizione 
     * contenente null all'interno dell'array
     */
    public static int primaPosizioneNull(Cliente[] clienti){
	int pos = 0;
	for (; pos < clienti.length; pos++)
	    if (clienti[pos] == null)
		break;
	return pos;
    }

    public static int primaPosizioneNull(ContoBancario[] accounts){
	int pos = 0;
	for (; pos < accounts.length; pos++)
	    if (accounts[pos] == null)
		break;
	return pos;
    }


    public static Cliente[] raddoppiaClienti(Cliente[] clients) {
	Cliente[] newCLienti = new Cliente[clients.length*2];
	for(int i=0; i < clients.length ; i++)
		newCLienti[i] = clients[i];
	return newCLienti;
    }

    
    public static ContoBancario[] raddoppiaConto(ContoBancario[] conti) {
	ContoBancario[] newConti = new ContoBancario[conti.length*2];
	for(int i=0; i < conti.length ; i++)
		newConti[i] = conti[i];
	return newConti;
    }


}
