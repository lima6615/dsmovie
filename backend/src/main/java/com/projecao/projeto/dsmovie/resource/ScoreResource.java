package com.projecao.projeto.dsmovie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecao.projeto.dsmovie.dto.MovieDTO;
import com.projecao.projeto.dsmovie.dto.ScoreDTO;
import com.projecao.projeto.dsmovie.service.ScoreService;

@RestController
@RequestMapping(value = "/scores")
@CrossOrigin("*")
public class ScoreResource {

	@Autowired
	private ScoreService service;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDto = service.saveScore(dto);
		return movieDto;
	}
}
