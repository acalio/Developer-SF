package banca.exceptions;

public class ContoNonTrovato extends Exception {
    public ContoNonTrovato(String idConto) {
        super(idConto+" non trovato");
    }

}
