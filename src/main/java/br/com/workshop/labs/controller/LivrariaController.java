package br.com.workshop.labs.controller;

import br.com.workshop.labs.dto.CompraDTO;
import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.service.CompraService;
import br.com.workshop.labs.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/livros")
public class LivrariaController {

    private final LivroService livroService;

    private final CompraService compraService;

    @Autowired
    public LivrariaController(LivroService livroService, CompraService compraService) {
        this.livroService = livroService;
        this.compraService = compraService;
    }

    /* Listar todos os livros */
    @GetMapping
    @ResponseBody
    public List<Livro> listarLivros() {
        return livroService.listar();
    }

    /* Cadastrar novos livros */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Livro livro) {
        livroService.cadastrar(livro);
    }

    /* Atualizar dados do livro*/
    @PutMapping("/{codLivro}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@PathVariable Integer codLivro, @RequestBody Livro livro) {
        livroService.atualizar(codLivro, livro);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/comprar", method = RequestMethod.POST)
    public ResponseEntity<Compra> comprar(@RequestBody CompraDTO compraDTO) {
        return compraService.efetuarCompra(compraDTO.getCodigo());
    }

    /* Listar todas as Compras */

    @ResponseBody
    @RequestMapping(value = "/compras", method = RequestMethod.GET)
    public List<Compra> listarCompras() {
        return compraService.listar();
    }

}
