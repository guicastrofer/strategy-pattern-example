package br.com.workshop.labs.exception;

public class ItemNaoEncontradoException extends RuntimeException {

    public ItemNaoEncontradoException(String message) {
        super(message);
    }

}
