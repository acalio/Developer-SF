package rubrica;

public class TestRubrica {

	public static void main(String[] args) {
		Contatto c1 = new Contatto("Mario", "Rossi");
		c1.setEmail("mario.rossi@gmail.com");
		NumeroTelefonico n1 = new NumeroTelefonico("Ufficio", "0674-987654");
		c1.aggiungiNumero(n1);
		c1.aggiungiNumero(new NumeroTelefonico("Casa", "0456-887755"));

		Contatto c2 = new Contatto("Giuseppe", "Verdi");
		c2.setEmail("g.verdi@libero.it");
		c2.aggiungiNumero(new NumeroTelefonico("Ufficio", "0674-346789"));
		c2.aggiungiNumero(new NumeroTelefonico("Cellulare", "369-9988765"));
		
		System.out.println(c1);
		System.out.println(c2);
		
		Rubrica rubrica = new Rubrica();
		rubrica.aggiungiContatto(c1);
		rubrica.aggiungiContatto(c2);
		System.out.println(rubrica);
	}

}
