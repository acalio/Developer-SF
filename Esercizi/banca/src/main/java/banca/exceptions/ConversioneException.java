package banca.exceptions;

public class ConversioneException extends Exception {
    public ConversioneException(String codiceIban) {
        super(codiceIban+ " non puo essere convertito...ancora in rosso!");
    }
}
