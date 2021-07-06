package banca;

import banca.BancaArray.TipoConto;

public class App {
    public static void main(String[] args) throws Exception {
		BancaArray banca = new BancaArray("Via Don Minzoni", "Intesa", "000");
		Cliente c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");
		banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
		System.out.println(banca);
		ContoBancario[] conti = banca.getConti(c.getCode());
		System.out.println(conti[0]);
		
		banca.cambiaConto(conti[0].getIban(), TipoConto.CONTO_SEMPLICE);
		System.out.println(banca.getConti(c.getCode())[0]);


    }
}
