package com.algaworks.socialmovies.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialmovies.model.Filme;
import com.algaworks.socialmovies.service.FilmesService;

@RestController
@RequestMapping("/filmes")
public class FilmesResource {

	@Autowired
	private FilmesService filmesService;
	
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Filme>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(filmesService.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Filme filme) {
		filme = filmesService.salvar(filme);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(filme.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Filme filme = filmesService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(filme);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delelar(@PathVariable("id") Long id) {
		filmesService.deletar(id);
		return ResponseEntity.noContent().build(); 
		
	}	
		
	
}
