package com.caique.spring_crud.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class PessoaDTO {


    private Long id; // ID único para cada pessoa
    private String nome; // Nome da pessoa
    private String email; // Email da pessoa
    private String cpf; // CPF da pessoa
    private String senha;
    private LocalDate dataNascimento; // Data de nascimento da pessoa
    private List<EnderecoDTO> endereco;
}








// public class PessoaDTO {


//     private Long id; // ID único para cada pessoa
//     private String nome; // Nome da pessoa
//     private String email; // Email da pessoa
//     private String cpf; // CPF da pessoa
//     private String senha;
//     private LocalDate dataNascimento; // Data de nascimento da pessoa
//     // private List<EnderecoDTO> endereco;
//     private String endereco; 

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

//     // public List<EnderecoDTO> getEnderecos() {
//     //     return endereco;
//     // }

//     // public void setEnderecos(List<EnderecoDTO> enderecos) {
//     //     this.endereco = enderecos;
//     // }

//     public String getEnderecos() {
//         return endereco;
//     }

//     public void setEnderecos(String endereco) {
//         this.endereco = endereco;
//     }
    

