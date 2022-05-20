package br.com.workshop.labs.service.impl;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.interfaces.GeneroStrategy;
import br.com.workshop.labs.respository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("TERROR")
public class Terror implements GeneroStrategy {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public ResponseEntity<Compra> obterDesconto(Livro livro) {
        var cashback = (livro.getPreco() / 100) * 20;
        var valorFinal = livro.getPreco() - cashback;
        var compra = Compra.builder()
                .dataCompra(LocalDateTime.now())
                .nomeLivro(livro.getNome())
                .genero("ROMANCE")
                .valorFinal(valorFinal)
                .build();
        compraRepository.save(compra);
        return ResponseEntity.ok(compra);
    }
}
