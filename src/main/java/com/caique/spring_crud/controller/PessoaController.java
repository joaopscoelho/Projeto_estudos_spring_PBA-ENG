package com.caique.spring_crud.controller;
import com.caique.spring_crud.dtos.EnderecoDTO;
import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.model.Endereco;
import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public Optional<?> listarPessoas() {
        return Optional.of(mapperPessoa());
    }

    private List<PessoaDTO> mapperPessoa() {
        List<PessoaDTO> toPessoasDTO = new ArrayList<>();
        List<Pessoa> pessoas = pessoaRepository.findAll();
        
        pessoas.forEach(x -> {
            PessoaDTO pesReturn = new PessoaDTO();
            List<EnderecoDTO> toEnderecosDTO = new ArrayList<>();
            if (x.getEndereco().size() > 0) {
                EnderecoDTO endReturn = new EnderecoDTO();
                x.getEndereco().forEach(e -> {
                    endReturn.setRua(e.getRua());
                    endReturn.setEstado(e.getEstado());
                    endReturn.setCep(e.getCep());
                    endReturn.setCidade(e.getCidade());
                    endReturn.setNumero(e.getNumero());

                });
                toEnderecosDTO.add(endReturn);
            }
            pesReturn.setCpf(x.getCpf());
            pesReturn.setDataNascimento(x.getDataNascimento());
            pesReturn.setEmail(x.getEmail());
            pesReturn.setId(x.getId());
            pesReturn.setNome(x.getNome());
            pesReturn.setSenha(x.getSenha());
            pesReturn.setEndereco(toEnderecosDTO);

            toPessoasDTO.add(pesReturn);
        });

        return toPessoasDTO;
    }

    @PostMapping("/cadastrar-pessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody(required = true) Pessoa pessoa) {
        // Gambiarra sem o mapper struct
        if (pessoa.getEndereco().size() > 0) { // Verifica se a lista tem valores
            pessoa.getEndereco().forEach(x -> { // Percorre a lista
                Pessoa pessoaEnd = new Pessoa(); // Cria a auxiliar
                pessoaEnd = pessoa; // Passa a pessoa principal para a auxiliar
                pessoaEnd.setEndereco(null); // Remover os endereço da auxiliar para não dar loop infinito
                x.setPessoa(pessoaEnd); // Passa a pessoa para o endereço da pessoa principal
            });
        }
        Pessoa novaPessoa = pessoaRepository.save(pessoa); // Salva 
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED); // Retorna para o front 
    }

    @PostMapping("/login")
    public ResponseEntity<Pessoa> login(@RequestBody Pessoa loginRequest) {
    Pessoa pessoa = pessoaRepository.findByEmail(loginRequest.getEmail());

    if (pessoa != null && pessoa.getSenha().equals(loginRequest.getSenha())) {
        // Login bem-sucedido
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    } else {
        // Credenciais inválidas
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
}
