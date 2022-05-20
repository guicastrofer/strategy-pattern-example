package br.com.workshop.labs.interfaces;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import org.springframework.http.ResponseEntity;

public interface GeneroStrategy {
    ResponseEntity<Compra> obterDesconto(Livro livro);
}
