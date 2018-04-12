package com.projeto.faculdade;

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
		Aluno aluno = new Aluno(null, "Bruno Lima", "Sistemas de Informacao");
		Aluno aluno1 = new Aluno(null, "Teste", "Engenharia Civil");		
		Professor professor = new Professor(null,"Willian");
		
		professoreRepo.save(professor);
		repo.save(aluno);
		repo.save(aluno1);
	}
}
