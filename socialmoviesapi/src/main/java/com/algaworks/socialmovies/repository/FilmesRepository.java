package com.algaworks.socialmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialmovies.model.Filme;

public interface FilmesRepository extends JpaRepository<Filme, Long>{

	
}
