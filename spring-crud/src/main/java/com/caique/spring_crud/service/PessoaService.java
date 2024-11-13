package com.caique.spring_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caique.spring_crud.model.Pessoa;
import com.caique.spring_crud.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private  PessoaRepository  pessoaRepository;

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        // Configura a relação de cada Endereco com a Pessoa antes de salvar
        pessoa.getEndereco().forEach(endereco -> endereco.setPessoa(pessoa));
        return pessoaRepository.save(pessoa);
    }

    public Pessoa findByEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }
}
