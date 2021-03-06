package sortable;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * 
     */
    public void testIntero()
    {
		Comparable[] v = new Comparable[] {
			new Intero(5),
			new Intero(10),
			new Intero(0),
			new Intero(20),
			new Intero(12)
		};

		Arrays.sort(v);

		// Sortable.sort(v); //eseguo ordinamento
		Comparable[] expected = new Comparable[] {
			new Intero(0),
			new Intero(5),
			new Intero(10),
			new Intero(12),
			new Intero(20)
		};

		for (int i = 0; i<v.length; i++) 
			assertTrue(v[i].equals(expected[i]));
    }
}
