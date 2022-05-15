package com.projecao.projeto.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecao.projeto.dsmovie.entites.Score;
import com.projecao.projeto.dsmovie.entites.ScorePK;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
