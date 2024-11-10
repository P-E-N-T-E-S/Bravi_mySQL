package br.com.Bravi.exceptions;

public class FornecedorJaExistenteException extends RuntimeException {
    public FornecedorJaExistenteException(String message) {
        super(message);
    }
}
