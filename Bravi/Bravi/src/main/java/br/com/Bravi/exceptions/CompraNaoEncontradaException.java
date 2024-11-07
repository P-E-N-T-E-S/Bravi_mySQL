package br.com.Bravi.exceptions;

public class CompraNaoEncontradaException extends RuntimeException {
  public CompraNaoEncontradaException(String message) {
    super(message);
  }
}