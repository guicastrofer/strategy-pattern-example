package br.com.workshop.labs.controller;

import br.com.workshop.labs.entity.Livro;
import br.com.workshop.labs.entity.Compra;
import br.com.workshop.labs.respository.LivrariaRepository;
import br.com.workshop.labs.respository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/livro")
public class LivrariaController {

    @Autowired
    LivrariaRepository livroRepository;

    @Autowired
    CompraRepository compraRepository;


    /* Deve listar todos os livros */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/listaLivros", method = RequestMethod.GET)
    public List<Livro> listaTodosLivros() {
        return livroRepository.listaTodosLivros();
    }


    /* Cadastrar novos livros */
    @RequestMapping(value = "/criarLivro", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarLivro(@RequestBody Livro livro) {
        livroRepository.save(livro);
    }

    /* Atualizar dados do livro*/
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/atualizarLivro", method = RequestMethod.PUT)
    public Livro atualizarLivro(@RequestBody Livro livro) {
        livroRepository.save(livro);
        return livro;
    }


    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/obterCashBack", method = RequestMethod.GET)
    public Compra comprar(@RequestBody Livro livro) {
       /*
        * Tipos de gênero
        * 1 - Romance
        * 2 - Terror
        * 3 - Ficção
        * 4 - Aventura
        * 5 - Religioso
        */

        if (livro.getNumeroGenero() == 1) {

            var cashback  = (livro.getPreco() / 100) * 10;
            var valorFinal = livro.getPreco() - cashback;


            //TODO setar objeto compra



            compraRepository.save(consumer);

        }else if(establishmentType == 2) {
            consumer = repository.findByDrugstoreNumber(cardNumber);
            consumer.setDrugstoreCardBalance(consumer.getDrugstoreCardBalance() - value);
            repository.save(consumer);

        } else {
            // Nas compras com o cartão de combustivel existe um acrescimo de 35%;
            Double tax  = (value / 100) * 35;
            value = value + tax;

            consumer = repository.findByFuelCardNumber(cardNumber);
            consumer.setFuelCardBalance(consumer.getFuelCardBalance() - value);
            repository.save(consumer);
        }

        Compra extract = new Compra(establishmentName, productDescription, new Date(), cardNumber, value);
        extractRepository.save(extract);
    }*/

}
