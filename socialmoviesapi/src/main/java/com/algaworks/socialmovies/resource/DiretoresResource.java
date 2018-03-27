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

import com.algaworks.socialmovies.model.Diretor;
import com.algaworks.socialmovies.service.DiretoresService;

@RestController
@RequestMapping("/diretores")
public class DiretoresResource {

	@Autowired
	private DiretoresService diretoresService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Diretor>> listar() {
		
		List<Diretor> diretores = diretoresService.listar();
				
		return ResponseEntity.status(HttpStatus.OK).body(diretores); 			
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Diretor diretor) {
		
		diretor = diretoresService.salvar(diretor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(diretor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Diretor> buscar(@PathVariable("id") Long id) {
		
		Diretor diretor = diretoresService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(diretor);
	}	
	
}
