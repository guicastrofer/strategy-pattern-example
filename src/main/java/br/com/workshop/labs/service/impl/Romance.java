package br.com.workshop.labs.service.impl;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.interfaces.GeneroStrategy;
import br.com.workshop.labs.respository.CompraRepository;
import br.com.workshop.labs.respository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("ROMANCE")
public class Romance implements GeneroStrategy {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    LivroRepository livroRepository;


    @Override
    public ResponseEntity<Compra> obterDesconto(Livro livro) {
        var cashback = (livro.getPreco() / 100) * 10;
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
