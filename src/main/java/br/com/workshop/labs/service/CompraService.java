package br.com.workshop.labs.service;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.interfaces.GeneroStrategy;
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

    public List<Compra> listar() {
        return compraRepository.findAll();
    }
}
