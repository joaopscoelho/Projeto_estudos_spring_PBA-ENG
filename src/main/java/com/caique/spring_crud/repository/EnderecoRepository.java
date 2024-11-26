package com.caique.spring_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caique.spring_crud.model.Endereco;
import com.caique.spring_crud.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findByPessoa(Pessoa pessoa);

}
