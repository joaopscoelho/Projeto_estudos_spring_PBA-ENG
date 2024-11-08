package com.caique.spring_crud.controller;

import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping("/cadastrar-pessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody(required = true) PessoaDTO pessoa) {
        //Pessoa novaPessoa = pessoaRepository.save(pessoa);
        System.out.println("Teste");
        return new ResponseEntity<>(null, HttpStatus.CREATED);
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
