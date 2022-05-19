package br.com.workshop.labs.service;

import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.respository.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivrariaRepository livroRepository;


    public List<Livro> listaTodosLivros() {
        return livroRepository.listaTodosLivros();
    }

    public void criarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public void atualizarLivro(Livro livro) {
        livroRepository.save(livro);
    }
}
