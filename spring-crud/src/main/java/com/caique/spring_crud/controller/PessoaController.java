package com.caique.spring_crud.controller;

// import com.caique.spring_crud.dtos.EnderecoDTO;
import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.mapping.PessoaMapper;
import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    // Endpoint para listar todas as pessoas
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        List<PessoaDTO> pessoasDTO = pessoaMapper.toDtoList(pessoas);
        return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
    }

    // Endpoint para cadastrar uma nova pessoa
    @PostMapping("/cadastrar-pessoa")
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        Pessoa novaPessoa = pessoaService.savePessoa(pessoa);
        PessoaDTO novaPessoaDTO = pessoaMapper.toDto(novaPessoa);
        return new ResponseEntity<>(novaPessoaDTO, HttpStatus.CREATED);
    }

    // Endpoint para login de uma pessoa
    @PostMapping("/login")
    public ResponseEntity<PessoaDTO> login(@RequestBody PessoaDTO loginRequest) {
        Pessoa pessoa = pessoaService.findByEmail(loginRequest.getEmail());

        if (pessoa != null && pessoa.getSenha().equals(loginRequest.getSenha())) {
            PessoaDTO pessoaDTO = pessoaMapper.toDto(pessoa);
            return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}