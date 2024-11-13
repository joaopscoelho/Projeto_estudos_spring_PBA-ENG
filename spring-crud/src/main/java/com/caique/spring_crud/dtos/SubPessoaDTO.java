package com.caique.spring_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPessoaDTO {
    private Long id;
    private String nome;
}
