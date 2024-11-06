package br.com.Bravi.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException {
    public CategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
