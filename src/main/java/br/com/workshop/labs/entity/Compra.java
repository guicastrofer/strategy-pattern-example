package br.com.workshop.labs.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@Entity
public class Compra {

    @Id
    private int id;
    private int numeroGenero;
    private String nomeLivro;
    private LocalDateTime dataCompra;
    private double valorFinal;

}
