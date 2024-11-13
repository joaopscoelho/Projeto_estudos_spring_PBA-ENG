package com.caique.spring_crud.model;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Pessoa pessoa;
}






// @Entity
// public class Endereco {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // Para auto-gerar o ID do endereço
    // private Long id;
    // private String rua;
    // private String numero;
    // private String cidade;
    // private String estado;
    // private String cep;

    // Associação com Pessoa
    // @ManyToOne(cascade = CascadeType.ALL)
    // private Pessoa pessoa;

    // Construtor vazio
    // public Endereco() {}

    // Getters e Setters
    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getRua() {
    //     return rua;
    // }

//     public void setRua(String rua) {
//         this.rua = rua;
//     }

//     public String getNumero() {
//         return numero;
//     }

//     public void setNumero(String numero) {
//         this.numero = numero;
//     }

//     public String getCidade() {
//         return cidade;
//     }

//     public void setCidade(String cidade) {
//         this.cidade = cidade;
//     }

//     public String getEstado() {
//         return estado;
//     }

//     public void setEstado(String estado) {
//         this.estado = estado;
//     }

//     public String getCep() {
//         return cep;
//     }

//     public void setCep(String cep) {
//         this.cep = cep;
//     }

//     public Pessoa getPessoa() {
//         return pessoa;
//     }

//     public void setPessoa(Pessoa pessoa) {
//         this.pessoa = pessoa;
//     }
// }