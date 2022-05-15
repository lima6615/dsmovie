package com.projecao.projeto.dsmovie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecao.projeto.dsmovie.dto.MovieDTO;
import com.projecao.projeto.dsmovie.service.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieResource {

	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
		Page<MovieDTO> dto = service.findAll(pageable);
		 return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){ 
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
