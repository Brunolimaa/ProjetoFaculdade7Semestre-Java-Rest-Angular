package com.projeto.faculdade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.faculdade.domain.Professor;
import com.projeto.faculdade.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repo;
	
	public Professor find(Integer id) {
		Optional<Professor> professor = repo.findById(id);
		return professor.orElse(null);
	}
	
	public List<Professor> findAll() {
		return repo.findAll();
	}
	
	public Professor insert(Professor professor) {
		professor.setId(null);
		return repo.save(professor);
	}
	
	public Professor update(Professor professor) {
		return repo.save(professor);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
