package com.projeto.faculdade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.faculdade.domain.Aluno;
import com.projeto.faculdade.domain.Professor;
import com.projeto.faculdade.repositories.AlunoRepository;
import com.projeto.faculdade.repositories.ProfessorRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AlunoRepository repo;
	
	@Autowired
	private ProfessorRepository professoreRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//professoreRepo.save(professor);
		//professoreRepo.save(professor1);

		Aluno aluno = new Aluno(null, "Bruno Lima", "Sistemas de Informacao", 2);
		Aluno aluno1 = new Aluno(null, "Teste", "Engenharia Civil", 1);		

		Professor professor = new Professor(null,"Willian", Arrays.asList(aluno, aluno1));
		Professor professor1 = new Professor(null,"Walter", Arrays.asList(aluno1));
		List<Professor> lista = new ArrayList<>();
		lista.add(professor);

		
		professoreRepo.save(professor);
		professoreRepo.save(professor1);

		repo.save(aluno);
		repo.save(aluno1);
	}
}
