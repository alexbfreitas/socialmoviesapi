package com.algaworks.socialmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialmovies.model.Diretor;
import com.algaworks.socialmovies.repository.DiretoresRepository;

@Service
public class DiretoresService {
	
	@Autowired 
	private DiretoresRepository diretoresRepository;
	
	public List<Diretor> listar() {
		
		return diretoresRepository.findAll();
	}
	
	public Diretor salvar(Diretor diretor) {
		
		return diretoresRepository.save(diretor);
	}
	
	public Diretor buscar(Long id) {
		
		return diretoresRepository.findOne(id);
	}
	
}
