package banca;
import java.lang.reflect.Array;

class Utility {

	public static <E> E[] raddoppia(E[] ts) {
		E[] newTs = (E[]) Array.newInstance(ts[0].getClass(), ts.length * 2);
		for (int i = 0; i < ts.length; i++)
			newTs[i] = ts[i];
		return newTs;
	}

	public static <T> int primaPosizioneNull(T[] ts) {
		int pos = 0;
		for (; pos < ts.length; pos++)
			if (ts[pos] == null)
				break;
		return pos;
	}

	public static <T> int cerca(T[] ts, T t) {
		for (int i = 0; i<ts.length && ts[i]!=null; i++)
			if(ts[i].equals(t)) 
				return i;
		return -1;
	}
    

	/**
	 * Metodo che sposta di una posizione a sinistra
	 * tutti gli elementi dell'array ts a partire da start. 
	 * Mantengo l'ordinamento.
	 * Pre:
	 * ts = [ob1, obj2, null, obj3, obj4]
	 * Post: shift(ts, 2)
	 * ts = [obj1, obj2, obj3, obj4, null] 
	 */
    public static<T> void shift(T[] ts, int start){
        for(int i=start; i<ts.length-1 ; i++)
            ts[i] = ts[i+1];

		
		
    }

}
