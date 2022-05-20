package br.com.workshop.labs.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 2310305089570426950L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codLivro;
    private String nome;
    private String autor;
    private LocalDate dataPublicacao;
    private String tipoGenero;
    private double preco;

}
