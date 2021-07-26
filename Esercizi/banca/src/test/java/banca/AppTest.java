package banca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import banca.BancaArray.TipoConto;
import banca.exceptions.ContoNonTrovato;


/**
 * Unit test for simple App.
 */
public class AppTest {

	BancaArray banca;
	Cliente c;

	@Before
	public void initBanca() {
		//metodo da eseguire prima di ogni test
		this.banca = new BancaArray("Via Don Minzoni", "Intesa", "000");
		this.c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
	}
	
	@Ignore
	@Test
	public void prelevaTestContoBancario() {
		ContoBancario b = new ContoBancario("0", 10, null);
		b.deposita(10);
		//         messaggio in caso di failure, condizione da testare
		assertTrue("Il bilancio deve essere 20", b.getBilancio() == 20);
		boolean esitoPrelievo = b.preleva(30.0);
		assertFalse("Prelievo non corretto", esitoPrelievo);
	}


	@Ignore
	@Test
	public void prelevaTestConFido() {
		//ho 10 euro sul conto
		ContoBancario b = new ContoConFido("0", 10, null, 100);
		b.deposita(10);
		//         messaggio in caso di failure, condizione da testare
		assertTrue("Il bilancio deve essere 20", b.getBilancio() == 20);
		boolean esitoPrelievo = b.preleva(30.0);
		//prelievo sia andato a buon fine
		assertTrue("Prelievo non corretto", esitoPrelievo);
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
	}


	@Test
	public void testaAssegnamentoCodice() {
		Cliente c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
		assertFalse("c.getCode() null", c.getCode()==null);
		assertTrue("Codice Errato: "+c.getCode(), c.getCode().equals("0"));
	}

	@Ignore
	@Test
	public void testApriChiudiConto() {
		Cliente c = new Cliente("Nicola", "Fiorentino", "Papanici", "1234213", "prof.nicola@promesse.com", "1/1/1952",
				"PRFNICFIOR52");


		//c.getCode() <- null
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_FIDO);
		//c.getCode() <- 0 
		
		//verifica inserimento // inserito nel metodo @Before
		ContoBancario[] accounts = this.banca.getAccounts();
		
		assertTrue("Il numero del conto e:"+this.banca.getAccounts()[0].getIban(),
				   this.banca.getAccounts()[0].getIban().equals("0"));
		
		this.banca.aprireConto(c, BancaArray.TipoConto.CONTO_SEMPLICE);
		assertTrue("Inserimento non avvenuto", this.banca.getAccounts()[1].getIban().equals("1"));

		try {
			this.banca.chiudiConto(this.banca.getAccounts()[0].getIban());
		} catch (ContoNonTrovato e) {
			System.out.println("Error " + e.getMessage());
			assertTrue("ContoNonTrovato", false);
		}

	}

	/**
	 * Testo l'impossibilita della conversione nel 
	 * caso in cui il conto fido abbia del debito
	 *
	 */
	@Test
	public void testCambiaContoRosso()  {
		ContoBancario[] conti = banca.getConti(this.c.getCode());
		assertTrue("Non ci sono conti", conti.length>0);
		ContoConFido cf = (ContoConFido) conti[0]; // creato in before
		cf.setFido(10);
		boolean risultato = cf.preleva(5);
		assertTrue("Prelievo non riuscito", risultato);
		assertTrue("Rosso non esatto", cf.getRosso()==5);
		try {
			//cambio tipologia di conto
			banca.cambiaConto(cf.getIban(), TipoConto.CONTO_SEMPLICE); //<- mi aspetto un eccezione
			assertFalse(true); // Test fallito!
		} catch (Exception e){
			assertTrue(true);
		}
		
	}
}
