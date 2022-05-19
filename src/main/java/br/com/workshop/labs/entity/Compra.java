package br.com.workshop.labs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class Compra {

    @Id
    int id;
    int numeroGenero;
    String nomeLivro;
    String descricao;
    Date dataCompra;
    double preco;

}
