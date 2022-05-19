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
    LivrariaRepository repository;

    @Autowired
    CompraRepository compraRepository;


    /* Deve listar todos os livros */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/listaLivros", method = RequestMethod.GET)
    public List<Livro> listaTodosLivros() {
        return repository.listaTodosLivros();
    }


    /* Cadastrar novos livros */
    @RequestMapping(value = "/criarLivro", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarLivro(@RequestBody Livro livro) {
        repository.save(livro);
    }

    /* Atualizar dados do livro*/
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/atualizarLivro", method = RequestMethod.PUT)
    public Livro atualizarLivro(@RequestBody Livro livro) {
        repository.save(livro);
        return livro;
    }

  /*
    @RequestMapping(value = "/setcardbalance", method = RequestMethod.GET)
    public void setBalance(int cardNumber, double value) {
        Livro livro = null;
        livro = repository.findByDrugstoreNumber(cardNumber);

        if(livro != null) {
            // é cartão de farmácia
            consumer.setDrugstoreCardBalance(consumer.getDrugstoreCardBalance() + value);
            repository.save(consumer);
        } else {
            consumer = repository.findByFoodCardNumber(cardNumber);
            if(consumer != null) {
                // é cartão de refeição
                consumer.setFoodCardBalance(consumer.getFoodCardBalance() + value);
                repository.save(consumer);
            } else {
                // É cartão de combustivel
                consumer = repository.findByFuelCardNumber(cardNumber);
                consumer.setFuelCardBalance(consumer.getFuelCardBalance() + value);
                repository.save(consumer);
            }
        }
    }

  @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public void buy(int numeroGenero, String nomeGenero, int cardNumber, String descricao, double value) {
        Livro livro = null;
        *//*
        * Tipos de gênero
        * 1 - Romance
        * 2 - Terror
        * 3 - Ficção
        * 4 - Aventura
        * 5 - Religioso
        *//*

        if (numeroGenero == 1) {
            Double cashback  = (value / 100) * 10;
            value = value - cashback;

            consumer = repository.findByFoodCardNumber(cardNumber);
            consumer.setFoodCardBalance(consumer.getFoodCardBalance() - value);
            repository.save(consumer);

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
