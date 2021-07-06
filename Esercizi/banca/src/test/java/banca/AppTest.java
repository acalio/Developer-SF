package banca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

	@Test
	public void prelevaTest(){
		ContoBancario b = new ContoBancario("0", 10, null);
		b.deposita(10);
		assertTrue("Corretto", b.getBilancio()==20);
		boolean esitoPrelievo = b.preleva(20.0);
		assertFalse("Prelievo non eseguito", esitoPrelievo);
	
	}
}
