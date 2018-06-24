package com.projeto.faculdade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	///@JoinColumn(name = "cod")
	//private Integer cod;
	@OneToMany(mappedBy="cod", fetch = FetchType.EAGER)
	private List<Aluno> alunos = new ArrayList<Aluno>();
	//private String Materia;
	public Professor() {
		
	}
	public Professor(Integer id, String nome,  List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
	}
	

	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
	
	
}
