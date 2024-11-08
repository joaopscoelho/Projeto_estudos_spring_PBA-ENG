package com.caique.spring_crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para auto-gerar o ID do endereço
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    // Associação com Pessoa
    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
}