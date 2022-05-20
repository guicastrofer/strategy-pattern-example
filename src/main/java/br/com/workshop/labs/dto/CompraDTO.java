package br.com.workshop.labs.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompraDTO implements Serializable {
    private static final long serialVersionUID = -5021409440915639267L;

    private Integer codigo;
}
