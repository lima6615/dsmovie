package com.projecao.projeto.dsmovie.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecao.projeto.dsmovie.dto.MovieDTO;
import com.projecao.projeto.dsmovie.dto.ScoreDTO;
import com.projecao.projeto.dsmovie.entites.Movie;
import com.projecao.projeto.dsmovie.entites.Score;
import com.projecao.projeto.dsmovie.entites.User;
import com.projecao.projeto.dsmovie.repositories.MovieRepository;
import com.projecao.projeto.dsmovie.repositories.ScoreRepository;
import com.projecao.projeto.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());

		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.save(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.save(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double media = sum / movie.getScores().size();
		
		movie.setScore(media);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return modelMapper.map(movie, MovieDTO.class);
	}
}
