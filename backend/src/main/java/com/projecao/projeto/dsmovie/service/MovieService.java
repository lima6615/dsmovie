package com.projecao.projeto.dsmovie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecao.projeto.dsmovie.dto.MovieDTO;
import com.projecao.projeto.dsmovie.entites.Movie;
import com.projecao.projeto.dsmovie.repositories.MovieRepository;
import com.projecao.projeto.dsmovie.service.exception.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> entity = repository.findAll(pageable);
		Page<MovieDTO> dto = entity.map(x -> modelMapper.map(x, MovieDTO.class));
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<MovieDTO> findAll() {
		List<Movie> entity = repository.findAll();
		List<MovieDTO> dto = entity.stream().map(x -> modelMapper.map(x, MovieDTO.class)).collect(Collectors.toList());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return  modelMapper.map(entity, MovieDTO.class);
	}
}
