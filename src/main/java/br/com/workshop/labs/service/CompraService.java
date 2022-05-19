package br.com.workshop.labs.service;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.respository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompraService {

    /*
     * Tipos de gênero
     * 1 - Romance
     * 2 - Terror
     * 3 - Ficção
     * 4 - Aventura
     * 5 - Religioso
     */
    @Autowired
    CompraRepository compraRepository;

    public Compra efetuarCompra(Livro livro) {
        if (livro.getNumeroGenero() == 1) {

            var cashback = (livro.getPreco() / 100) * 10;
            var valorFinal = livro.getPreco() - cashback;

            var compra =
                    Compra.builder()
                            .dataCompra(LocalDateTime.now())
                            .id(livro.getId())
                            .numeroGenero(livro.getNumeroGenero())
                            .nomeLivro(livro.getNome()).build();

            return compraRepository.save(compra);

        } else if (livro.getNumeroGenero() == 2) {
            var cashback = (livro.getPreco() / 100) * 10;
            var valorFinal = livro.getPreco() - cashback;

            var compra =
                    Compra.builder()
                            .dataCompra(LocalDateTime.now())
                            .id(livro.getId())
                            .numeroGenero(livro.getNumeroGenero())
                            .nomeLivro(livro.getNome()).build();

            return compraRepository.save(compra);

        } else {
            var cashBack = (livro.getPreco() / 100) * 35;
            var valorFInal = livro.getPreco() - cashBack;

            var compra =
                    Compra.builder()
                            .dataCompra(LocalDateTime.now())
                            .id(livro.getId())
                            .numeroGenero(livro.getNumeroGenero())
                            .nomeLivro(livro.getNome()).build();
            return compraRepository.save(compra);
        }
    }
}
