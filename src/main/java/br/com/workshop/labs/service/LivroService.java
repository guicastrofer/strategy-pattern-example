package br.com.workshop.labs.service;

import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.respository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;


    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public void cadastrar(Livro livro) {
        livroRepository.save(livro);
    }

    public ResponseEntity<Livro> atualizar(Integer id, Livro livro) {
        if (livroRepository.findById(id).isEmpty() || livroRepository.findById(id) == null)
            return ResponseEntity.notFound().build();
        livro.setCodLivro(id);
        return ResponseEntity.ok(livroRepository.save(livro));
    }
}
