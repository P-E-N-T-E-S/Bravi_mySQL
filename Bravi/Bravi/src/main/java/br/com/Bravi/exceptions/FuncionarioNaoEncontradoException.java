package br.com.Bravi.exceptions;

public class FuncionarioNaoEncontradoException extends RuntimeException {
  public FuncionarioNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public FuncionarioNaoEncontradoException(String filtro, String valor) {
    super("Funcionário com " + filtro + " '" + valor + "' não encontrado.");
  }
}
