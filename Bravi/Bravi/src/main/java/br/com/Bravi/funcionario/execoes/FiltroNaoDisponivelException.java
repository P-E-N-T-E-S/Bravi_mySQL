package br.com.Bravi.funcionario.execoes;

public class FiltroNaoDisponivelException extends RuntimeException {
    public FiltroNaoDisponivelException(String filtro) {
        super("Filtro não disponível: " + filtro);
    }
}
