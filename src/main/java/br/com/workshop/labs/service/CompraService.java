package br.com.workshop.labs.service;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.respository.CompraRepository;
import br.com.workshop.labs.respository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraService {

    /*
     * Tipos de gênero
     * 1 - Romance - 10%
     * 2 - Terror - 20%
     * 3 - Ficção - 35%
     * 4 - Aventura - XX
     * 5 - Religioso --XX
     */
    private final CompraRepository compraRepository;

    private final LivroRepository livroRepository;

    public CompraService(CompraRepository compraRepository, LivroRepository livroRepository) {
        this.compraRepository = compraRepository;
        this.livroRepository = livroRepository;
    }

    public ResponseEntity<Compra> efetuarCompra(Integer codLivro) {
        var livroOpt = livroRepository.findById(codLivro);

        if (!livroOpt.isPresent())
            return ResponseEntity.notFound().build();

        var livro = livroOpt.get();


        if (livro.getNumeroGenero() == 1) {
            var cashback = (livro.getPreco() / 100) * 10;
            var valorFinal = livro.getPreco() - cashback;
            var compra = compraRepository.save(montarObjeto(livro, valorFinal));
            return ResponseEntity.ok(compra);

        } else if (livro.getNumeroGenero() == 2) {
            var cashback = (livro.getPreco() / 100) * 20;
            var valorFinal = livro.getPreco() - cashback;
            var compra = compraRepository.save(montarObjeto(livro, valorFinal));
            return ResponseEntity.ok(compra);

        } else {
            var cashBack = (livro.getPreco() / 100) * 35;
            var valorFinal = livro.getPreco() - cashBack;
            var compra = compraRepository.save(montarObjeto(livro, valorFinal));
            return ResponseEntity.ok(compra);
        }
    }

    public Compra montarObjeto(Livro livro, double valorFinal) {
        return Compra.builder()
                .dataCompra(LocalDateTime.now())
                .numeroGenero(livro.getNumeroGenero())
                .nomeLivro(livro.getNome())
                .valorFinal(valorFinal)
                .build();
    }

    public List<Compra> listar() {
        return compraRepository.findAll();
    }
}
