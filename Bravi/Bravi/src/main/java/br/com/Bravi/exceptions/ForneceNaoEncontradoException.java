package br.com.Bravi.exceptions;

public class ForneceNaoEncontradoException extends RuntimeException {
  public ForneceNaoEncontradoException(String message) {
    super(message);
  }
}