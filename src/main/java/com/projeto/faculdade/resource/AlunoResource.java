package com.projeto.faculdade.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.faculdade.domain.Aluno;
import com.projeto.faculdade.service.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value="/alunos")
@RestController
@Api(value="alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@ApiOperation(value="Busca um aluno especifico")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable Integer id){
		Aluno aluno = service.find(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@ApiOperation(value="Insere um novo aluno")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno aluno){
		service.insert(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@ApiOperation(value="Atualiza um aluno especifico")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Aluno aluno){
		aluno.setId(id);
		service.update(aluno);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Deleta um aluno")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Busca todos os alunos")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
}
