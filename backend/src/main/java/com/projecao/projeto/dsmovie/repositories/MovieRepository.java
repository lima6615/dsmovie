package com.projecao.projeto.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecao.projeto.dsmovie.entites.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
