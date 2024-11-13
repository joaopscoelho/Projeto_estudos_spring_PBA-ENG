package com.caique.spring_crud.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; // Importando List para armazenar múltiplos endereços

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; // Importando OneToMany
import jakarta.persistence.FetchType;


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
    private List<Endereco> endereco = new ArrayList<>();
}










// @Entity
// public class Pessoa {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id; // ID único para cada pessoa
//     private String nome; // Nome da pessoa
//     private String email; // Email da pessoa
//     private String cpf; // CPF da pessoa
//     private String senha;
//     private LocalDate dataNascimento; // Data de nascimento da pessoa

//     // Relacionamento com a classe Endereco
//     @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL) // Associação com Endereco
//     private List<Endereco> endereco;

//     // Construtor vazio
//     public Pessoa() {}

//     // Getters e Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getCpf() {
//         return cpf;
//     }

//     public void setCpf(String cpf) {
//         this.cpf = cpf;
//     }

//     public LocalDate getDataNascimento() {
//         return dataNascimento;
//     }

//     public void setDataNascimento(LocalDate dataNascimento) {
//         this.dataNascimento = dataNascimento;
//     }

//     public String getSenha() {
//         return senha;
//     }

//     public void setSenha(String senha) {
//         this.senha = senha;
//     }

//     public List<Endereco> getEnderecos() {
//         return endereco;
//     }

//     public void setEnderecos(List<Endereco> enderecos) {
//         this.endereco = enderecos;
//     }
// }