package br.com.Bravi.exceptions;

public class FiltroNaoDisponivelException extends RuntimeException {
    public FiltroNaoDisponivelException(String filtro) {
        super("Filtro não disponível: " + filtro);
    }
}
