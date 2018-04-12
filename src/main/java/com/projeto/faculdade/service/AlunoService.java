package com.projeto.faculdade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.faculdade.domain.Aluno;
import com.projeto.faculdade.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public Aluno find(Integer id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.orElse(null);
	}
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno insert(Aluno aluno){
		aluno.setId(null);
		return repository.save(aluno);
	}
	
	public Aluno update(Aluno aluno){
		return repository.save(aluno);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
