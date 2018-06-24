package com.projeto.faculdade.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String curso;
	//@OneToMany(mappedBy="cod", fetch = FetchType.EAGER)
	//private List<Professor> professor;
	
	@JoinColumn(name="cod")
	private Integer cod;
	
	public Aluno() {
		
	}
	
	public Aluno(Integer id, String nome, String curso, Integer cod) {
		super();
		//this.professor = professor_id;
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.cod = cod;
	}
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

//	public List<Professor> getProfessor() {
//		return professor;
//	}
//
//	public void setProfessor(List<Professor> professor) {
//		this.professor = professor;
//	}

}
