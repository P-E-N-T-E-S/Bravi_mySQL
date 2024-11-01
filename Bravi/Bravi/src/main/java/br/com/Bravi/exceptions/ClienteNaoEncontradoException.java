package br.com.Bravi.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}
