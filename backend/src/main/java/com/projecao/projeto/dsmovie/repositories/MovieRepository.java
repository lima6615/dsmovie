package com.projecao.projeto.dsmovie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecao.projeto.dsmovie.entites.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Optional<Movie> findByTitleAndScore(@Param("title") String title, @Param("score") Double score);
	
}
