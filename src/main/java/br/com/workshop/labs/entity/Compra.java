package br.com.workshop.labs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class Compra {

    @Id
    private int id;
    private int numeroGenero;
    private String nomeLivro;
    private String descricao;
    private Date dataCompra;
    private double valorFinal;

}
