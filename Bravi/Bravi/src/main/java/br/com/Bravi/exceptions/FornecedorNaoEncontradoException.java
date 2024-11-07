package br.com.Bravi.exceptions;

public class FornecedorNaoEncontradoException extends RuntimeException {
  public FornecedorNaoEncontradoException(String message) {
    super(message);
  }
}