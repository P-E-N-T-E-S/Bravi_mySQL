package br.com.Bravi.funcionario.execoes;

public class CampoDeAlteracaoNaoEncontradoException extends RuntimeException {
    public CampoDeAlteracaoNaoEncontradoException(String campo) {
        super("Campo de alteração não encontrado: " + campo);
    }
}
