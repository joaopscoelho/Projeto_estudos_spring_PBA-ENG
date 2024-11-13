package com.caique.spring_crud.dtos;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id; // ID único do endereço
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private SubPessoaDTO pessoa;
}
    // private Long pessoaId; // ID da pessoa associada (opcional, caso seja necessário referenciar a pessoa)


// public class EnderecoDTO {

//     private String rua;
//     private String numero;
//     private String cidade;
//     private String estado;
//     private String cep;
//     private SubPessoaDTO pessoa;

//         // Getter e Setter para rua
//         public String getRua() {
//             return rua;
//         }
    
//         public void setRua(String rua) {
//             this.rua = rua;
//         }
    
//         // Getter e Setter para numero
//         public String getNumero() {
//             return numero;
//         }
    
//         public void setNumero(String numero) {
//             this.numero = numero;
//         }
    
//         // Getter e Setter para cidade
//         public String getCidade() {
//             return cidade;
//         }
    
//         public void setCidade(String cidade) {
//             this.cidade = cidade;
//         }
    
//         // Getter e Setter para estado
//         public String getEstado() {
//             return estado;
//         }
    
//         public void setEstado(String estado) {
//             this.estado = estado;
//         }
    
//         // Getter e Setter para cep
//         public String getCep() {
//             return cep;
//         }
    
//         public void setCep(String cep) {
//             this.cep = cep;
//         }
    
//         // Getter e Setter para pessoa
//         public SubPessoaDTO getPessoa() {
//             return pessoa;
//         }
    
//         public void setPessoa(SubPessoaDTO pessoa) {
//             this.pessoa = pessoa;
//         }

// }
