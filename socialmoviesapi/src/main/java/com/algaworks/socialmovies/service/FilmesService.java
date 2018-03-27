package com.algaworks.socialmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialmovies.model.Filme;
import com.algaworks.socialmovies.repository.FilmesRepository;

@Service
public class FilmesService {

	@Autowired
	private FilmesRepository filmesRepository;
	
	public List<Filme> listar() {
		
		return filmesRepository.findAll();
	}
	
	public Filme buscar(Long id) {
		
		return filmesRepository.findOne(id);
	}
	
	public Filme salvar(Filme filme) { 
		
		return filmesRepository.save(filme);
		
	}
	
	public void deletar(Long id) {
		
		filmesRepository.delete(id);
	}
	
}
