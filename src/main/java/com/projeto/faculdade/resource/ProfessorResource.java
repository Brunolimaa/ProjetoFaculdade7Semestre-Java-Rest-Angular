package com.projeto.faculdade.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.faculdade.domain.Aluno;
import com.projeto.faculdade.domain.Professor;
import com.projeto.faculdade.service.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RequestMapping(value="/professores")
@RestController
@Api(value="Professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService service;
	
	@ApiOperation(value="Busca um professor especifico")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable Integer id){
		Professor professor = service.find(id);
		return ResponseEntity.ok().body(professor);
	}
	
	@ApiOperation(value="Insere um professor aluno")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Professor professor){
		service.insert(professor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(professor.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@ApiOperation(value="Atualiza um professor especifico")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Professor professor){
		professor.setId(id);
		service.update(professor);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Deleta um Professor")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Busca todos os professores")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Professor>> findAll(){
		List<Professor> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
}
