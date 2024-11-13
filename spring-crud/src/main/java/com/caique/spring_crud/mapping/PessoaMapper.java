package com.caique.spring_crud.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.caique.spring_crud.dtos.EnderecoDTO;
import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.dtos.SubPessoaDTO;
import com.caique.spring_crud.model.Endereco;
import com.caique.spring_crud.model.Pessoa;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    // Mapeamento para PessoaDTO
    @Mappings({
        @Mapping(target = "endereco", source = "endereco"),
        @Mapping(target = "cpf", source = "cpf"),
        @Mapping(target = "email", source = "email"),
        @Mapping(target = "senha", source = "senha"),
        @Mapping(target = "dataNascimento", source = "dataNascimento")
    })
    PessoaDTO toDto(Pessoa pessoa);

    // Mapeamento reverso para Pessoa a partir de PessoaDTO
    @Mapping(target = "endereco", source = "endereco")
    Pessoa toEntity(PessoaDTO pessoaDTO);

    // Conversão para listas de PessoaDTO a partir de listas de Pessoa
    List<PessoaDTO> toDtoList(List<Pessoa> pessoas);
    List<Pessoa> toEntityList(List<PessoaDTO> pessoaDTOs);

    // Mapeamento para SubPessoaDTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    SubPessoaDTO pessoaToSubPessoaDTO(Pessoa pessoa);

    // Mapeamento reverso para Pessoa a partir de SubPessoaDTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    Pessoa subPessoaDTOToPessoa(SubPessoaDTO subPessoaDTO);

    // Mapeamento de Endereco para EnderecoDTO com SubPessoaDTO
    @Mapping(target = "pessoa", source = "pessoa")
    EnderecoDTO enderecoToEnderecoDTO(Endereco endereco);

    // Mapeamento reverso para Endereco a partir de EnderecoDTO
    @Mapping(target = "pessoa", source = "pessoa")
    Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO);

    // Conversão de listas de Endereco e EnderecoDTO
    List<EnderecoDTO> enderecoListToEnderecoDTOList(List<Endereco> enderecos);
    List<Endereco> enderecoDTOListToEnderecoList(List<EnderecoDTO> enderecoDTOs);
}