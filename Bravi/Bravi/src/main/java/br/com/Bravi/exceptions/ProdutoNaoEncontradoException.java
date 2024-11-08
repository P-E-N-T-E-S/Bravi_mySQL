package br.com.Bravi.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {
  public ProdutoNaoEncontradoException(String mensagem) {
    super("Produto não encontrado.");
  }
}
