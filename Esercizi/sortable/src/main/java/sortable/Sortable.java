package sortable;
abstract class Sortable {

	/**
	 * Restituisce:
	 * - 0 se this è "uguale" a other 
	 * - <0 se this è minore di other
	 * - >0 se this è maggiore di other
	 */
	protected abstract int compareTo(Sortable other);

	/**
	 * Metodo per ordinare array di sortable.
	 * Gli oggetti sono ordinati in ordine crescente 
	 *
	 */
	public static void sort(Sortable [] v) { // [p1, p2, p3]
		for(int j=v.length-1 ; j>0; j--){
			int iMax = 0;
			for(int i=0 ; i<=j ; i++)
				if (v[i].compareTo(v[iMax]) > 0)
					iMax = i;
			Sortable park = v[j];
			v[j] = v[iMax];
			v[iMax] = park;
		}  
	}
}

//Persona extends Sortable: [id, eta, nome]
//p1 = [0, 30, Ciccio], p2 = [1, 25, Cicciuzzo]
// p1.compareTo(p2) ordinare per id? ordinare per eta? o per nome?
//
// ---- Esercizio modificare per dare la possibila di scegliere su cosa
// effetuare ordinamen
//
