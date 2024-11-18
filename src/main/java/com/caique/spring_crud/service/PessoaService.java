package com.caique.spring_crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caique.spring_crud.dtos.PessoaDTO;
import com.caique.spring_crud.mapping.PessoaMapper;
import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PessoaMapper mapper;

	public List<Pessoa> getAllPessoas() {
		return pessoaRepository.findAll();
	}

	public Optional<?> savePessoa(PessoaDTO pessoaDTO) {
		try {
			return Optional.of(this.mapper.toPessoaDTO(this.pessoaRepository.save(this.mapper.mapPessoa(pessoaDTO)))) ;
			
		} catch (Exception e) {
			return Optional.of(e.getMessage());
		}
	}

	public Optional<?> editPessoa(PessoaDTO pessoaDTO) throws Throwable {
		try {
			return Optional.of(this.mapper.toPessoaDTO(this.pessoaRepository.save(this.mapper.mapPessoa(pessoaDTO)))) ;
		} catch (Exception e) {
			throw new Throwable(e);
		}
	}

	
	public List<PessoaDTO> listarPessoas() {
		return pessoaRepository.findAll().stream().map(x -> this.mapper.toPessoaDTO(x)).collect(Collectors.toList());
	}

	public Optional<?> deletar(Long id) throws Throwable {
		try {
			this.pessoaRepository.deleteById(id);
			return null;
		} catch (Exception e) {
			throw new Throwable(e);
		}
	}
	
	
	public Optional<?> carragarPessoa(Long id) throws Throwable{
		try {
			return Optional.of(this.mapper.toPessoaDTO(pessoaRepository.findById(id).get()));	
		} catch (Exception e) {
			throw new Throwable(e);
		}
	}
	
	public Pessoa findByEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}


}
