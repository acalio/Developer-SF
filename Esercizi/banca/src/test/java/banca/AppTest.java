package banca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import banca.exceptions.ContoNonTrovato;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	BancaArray banca = null; 

    @Before
	public void initBanca() {
		//metodo da eseguire prima di ogni test
		this.banca = new BancaArray("Via Don Minzoni", "Intesa", "000");
	}

	/**
     * Rigorous Test :-)
     */
	@Test
    public void xDeveEsserePari()
    {
		int x = 4;
        assertTrue("X non è pari", x%2==0);
    }

	@Test
	public void prelevaTestContoBancario(){
		ContoBancario b = new ContoBancario("0", 10, null);
		b.deposita(10);
		//         messaggio in caso di failure, condizione da testare
		assertTrue("Il bilancio deve essere 20", b.getBilancio()==20);
		
		boolean esitoPrelievo = b.preleva(30.0);

		assertFalse("Prelievo non corretto", esitoPrelievo);
	
	}

	@Ignore
	@Test
	public void prelevaTestConFido(){
		//ho 10 euro sul conto
		ContoBancario b = new ContoConFido("0", 10, null, 100);
		b.deposita(10);
		//         messaggio in caso di failure, condizione da testare
		assertTrue("Il bilancio deve essere 20", b.getBilancio()==20);
		boolean esitoPrelievo = b.preleva(30.0);
		//prelievo sia andato a buon fine
		assertTrue("Prelievo non corretto", esitoPrelievo);
	}


	@Test
	public void testaAssegnamentoCodice() {
		Cliente c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
		assertTrue("Codice Errato", c.getCode().equals("0"));
	}


	@Test
	public void testApriChiudiConto() {
		Cliente c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
		//verifica inserimento
		assertTrue("Inserimento non avvenuto", this.banca.getAccounts()[0].getIban().equals("0"));

		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_SEMPLICE);
		assertTrue("Inserimento non avvenuto", this.banca.getAccounts()[1].getIban().equals("1"));

		try {
			this.banca.chiudiConto(this.banca.getAccounts()[0].getIban());			
		}
		catch (ContoNonTrovato e) {
			System.out.println("Error " + e.getMessage());
			assertTrue("ContoNonTrovato", false);
		}




	}



	
}
