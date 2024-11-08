package br.com.Bravi.exceptions;

public class InternalServerErrorException extends RuntimeException {
  public InternalServerErrorException(String message) {
    super("Erro interno do servidor");
  }
}