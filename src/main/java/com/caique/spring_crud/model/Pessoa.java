package com.caique.spring_crud.model;

import java.time.LocalDate;
import java.util.List; // Importando List para armazenar múltiplos endereços

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único para cada pessoa
    private String nome; // Nome da pessoa
    private String email; // Email da pessoa
    private String cpf; // CPF da pessoa
    private String senha;
    private LocalDate dataNascimento; // Data de nascimento da pessoa
    // Relacionamento com a classe Endereco
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Associação com Endereco
    private List<Endereco> endereco;
}