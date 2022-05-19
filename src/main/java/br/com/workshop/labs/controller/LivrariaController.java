package br.com.workshop.labs.controller;

import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.respository.CompraRepository;
import br.com.workshop.labs.respository.LivrariaRepository;
import br.com.workshop.labs.service.CompraService;
import br.com.workshop.labs.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/livro")
public class LivrariaController {

    @Autowired
    LivroService livroService;

    @Autowired
    CompraService compraService;


    /* Deve listar todos os livros */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/listaLivros", method = RequestMethod.GET)
    public List<Livro> listaTodosLivros() {
        return livroService.listaTodosLivros();
    }


    /* Cadastrar novos livros */
    @RequestMapping(value = "/criarLivro", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarLivro(@RequestBody Livro livro) {
        livroService.criarLivro(livro);
    }

    /* Atualizar dados do livro*/
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/atualizarLivro", method = RequestMethod.PUT)
    public Livro atualizarLivro(@RequestBody Livro livro) {
        livroService.atualizarLivro(livro);
        return livro;
    }


    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/comprar", method = RequestMethod.GET)
    public Compra comprar(@RequestBody Livro livro) {
        return compraService.efetuarCompra(livro);
    }


}
