package com.caique.spring_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.caique.spring_crud.dtos.EnderecoDTO;
import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.mapping.PessoaMapper;
import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

      @Autowired
      private PessoaMapper pessoaMapper;

     // Endpoint para listar todas as pessoas
     @GetMapping
     public ResponseEntity<?> listarPessoas() {
         return ResponseEntity.ok(this.pessoaService.listarPessoas());
     }

     // Endpoint para cadastrar uma nova pessoa
     @PostMapping("/cadastrar-pessoa")
     public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
         return ResponseEntity.ok(pessoaService.savePessoa(pessoaDTO));
     }

    // // Endpoint para login de uma pessoa
     @PostMapping("/login")
     public ResponseEntity<PessoaDTO> login(@RequestBody PessoaDTO loginRequest) {
         Pessoa pessoa = pessoaService.findByEmail(loginRequest.getEmail());

         if (pessoa != null && pessoa.getSenha().equals(loginRequest.getSenha())) {
             PessoaDTO pessoaDTO = pessoaMapper.toPessoaDTO(pessoa);
             return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }
     }
}