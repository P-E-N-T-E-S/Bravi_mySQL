package br.com.Bravi.exceptions;

public class EstoqueNotFoundException extends RuntimeException {
    public EstoqueNotFoundException(String message) {
        super(message);
    }
}
