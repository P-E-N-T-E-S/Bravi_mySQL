package br.com.Bravi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FornecedorExceptionHandler {

  @ExceptionHandler(FornecedorNaoEncontradoException.class)
  public ResponseEntity<String> handleFornecedorNaoEncontrado(FornecedorNaoEncontradoException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(FornecedorJaExistenteException.class)
  public ResponseEntity<String> handleFornecedorJaExistente(FornecedorJaExistenteException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
  }
}
