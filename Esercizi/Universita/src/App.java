public class App {
	public static void main(String[] args) {

	        Docente d = new Docente("Nicola", "Fiorentino", 40, 2); //d -> 0xD0
		Docente d1 = new Docente("Ludovica", "Sacco", 36, 1); // -> 0xD1
		Docente d2 = new Docente("Antonio", "Calio", 22, 2); // -> 0xD2
		Docente [] docenti = {d,d1,d2};
		//unical.docenti = {0xD0, 0xD1, 0xD2}
		Universita unical = new Universita("Università della Calabria", "via P. Bucci", docenti);
		System.out.println(unical);
		
		System.out.println(unical.trovaDocenteRef(d)); // -> true : trova(0xD0)
		//0xD0 -> sede di una azienda, che risiede all'indirizzo 0xD0 ; dcopy,d sono due biglietti da visita che puntano a questa sede
		// Docente dcopy = d; // creo copia di d, dcopy -> d -> 0xD0 (alias) 
		// System.out.println(unical.trovaDocente(dcopy)); // -> true : trova(0xD0)

		// Docente rcopy = new Docente(dcopy); // rcopy -> 0xD3
		// System.out.println(unical.trovaDocente(rcopy)); // -> false : trova(0xD0) 
		
		Docente dcopy = new Docente(d); // creo copia di d, dcopy -> 0xD4 -> creiamo una nuova sede della stessa azienda; dcopy -> nuovo indirizzo
		System.out.println(unical.trovaDocenteRef(dcopy)); // -> false : trova(0xD4) - 0xD4 non e presente in unical.docenti
		System.out.println("d");
		System.out.println(d);
		System.out.println("dcopy");
		System.out.println(dcopy);




		System.out.println("==");
		System.out.println(dcopy==d); // false
		System.out.println("equals");
		System.out.println(dcopy.equals(d));
		System.out.println("Trova docente");

		System.out.println(unical.trovaDocenteRef(dcopy)); // false
		System.out.println(unical.trovaDocenteEq(dcopy));  // true


	}
}

