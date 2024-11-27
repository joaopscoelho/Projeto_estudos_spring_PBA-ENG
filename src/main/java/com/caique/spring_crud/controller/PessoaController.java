package com.caique.spring_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caique.spring_crud.dtos.EnderecoDTO;
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
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> listarPessoas() {
	    return ResponseEntity.ok(this.pessoaService.listarPessoas());
	}
	
	@CrossOrigin
	@GetMapping("carregar-pessoa/{id}")
	public ResponseEntity<?> carregarPessoa(@PathVariable(required = true) Long id) throws Throwable{
	    return ResponseEntity.ok(this.pessoaService.carragarPessoa(id));
	}
	
	@CrossOrigin
	@PostMapping("/pesquisar-pessoas")
	public ResponseEntity<?> pesquisar(PessoaDTO pessoa) {
	    return ResponseEntity.ok(this.pessoaService.listarPessoas());
	}
	
	 // Endpoint para cadastrar uma nova pessoa
	@CrossOrigin
	@PostMapping("/cadastrar-pessoa")
	public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
	    return ResponseEntity.ok(pessoaService.savePessoa(pessoaDTO));
	}
	
	// Endpoint para cadastrar uma nova pessoa
	@CrossOrigin
	@PutMapping("/editar-pessoa")
	public ResponseEntity<?> editar(@RequestBody(required = true) PessoaDTO pessoaDTO) throws Throwable {
	    return ResponseEntity.ok(pessoaService.editPessoa(pessoaDTO));
	}
	 
	@CrossOrigin
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable(required = true) Long id) throws Throwable {
	    return ResponseEntity.ok(pessoaService.deletar(id));
	}
	
	// // Endpoint para login de uma pessoa
//	@CrossOrigin
//	@PostMapping("/login")
//	public ResponseEntity<PessoaDTO> login(@RequestBody PessoaDTO loginRequest) {
//	    Pessoa pessoa = pessoaService.findByEmail(loginRequest.getEmail());
//	
//	    if (pessoa != null && pessoa.getSenha().equals(loginRequest.getSenha())) {
//	        PessoaDTO pessoaDTO = pessoaMapper.toPessoaDTO(pessoa);
//	        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//	    }
//	}
	
	
	//************************************************************
	
	@CrossOrigin
	@PostMapping("endereco/cadastrar")
	public ResponseEntity<?> cadastrarEndereco(@RequestBody(required = true) EnderecoDTO dto) throws Throwable {
		return ResponseEntity.ok(this.pessoaService.cadastrarEndereco(dto)) ;
	}
	
	@CrossOrigin
	@PostMapping("endereco/editar")
	public ResponseEntity<?> editarEndereco(@RequestBody(required = true) EnderecoDTO dto) throws Throwable {
		return ResponseEntity.ok(this.pessoaService.editarEndereco(dto)) ;
	}
	
	@CrossOrigin
	@DeleteMapping("endereco/deletar/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable (required = true) Long id) throws Throwable {
		return ResponseEntity.ok(this.pessoaService.delatarEndereco(id)) ;
	}
	
	@CrossOrigin
	@GetMapping("endereco/listar-por-usuario/{id}")
	public ResponseEntity<?> listarEnderecoPorUsuario(@PathVariable(required = true) Long id) throws Throwable {
		return ResponseEntity.ok(this.pessoaService.listarEnderecoPorUsuario(id)) ;
	}
	
	
}