package org.cap.theatermgt.controller;

import java.util.*;

import org.cap.theatermgt.dto.AddTheaterDto;
import org.cap.theatermgt.entities.Theater;
import org.cap.theatermgt.exception.TheaterNotFoundException;
import org.cap.theatermgt.service.ITheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

	private static final Logger Log = LoggerFactory.getLogger(TheaterController.class);

	@Autowired
	private ITheaterService service;

	@PostMapping("/add")
	public ResponseEntity<Theater> addTheater(@RequestBody AddTheaterDto theaterDto) {
		Theater theater = convert(theaterDto);
		theater = service.save(theater);
		ResponseEntity<Theater> response = new ResponseEntity<Theater>(theater, HttpStatus.OK);
		return response;
	}

	@GetMapping
	public ResponseEntity<List<Theater>> fetchAll() {
		List<Theater> theaters = service.fetchAll();
		ResponseEntity<List<Theater>> response = new ResponseEntity<>(theaters, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Theater> fetchById(@PathVariable("id") int theaterId) {
		Theater th = service.fetchById(theaterId);
		ResponseEntity<Theater> response = new ResponseEntity<Theater>(th, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTheater(@PathVariable("id") int theaterId) {
		String result = service.delete(theaterId);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}

	private Theater convert(AddTheaterDto theaterdto) {
		Theater theater = new Theater();
		theater.setTheaterId(theaterdto.getTheaterId());
		theater.setTheaterName(theaterdto.getTheaterName());
		theater.setTheaterCity(theaterdto.getTheaterCity());
		theater.setManagerName(theaterdto.getManagerName());
		theater.setManagerContact(theaterdto.getManagerContact());
		theater.setMovieList(addMovie());
		return theater;
	}
	
	private List<String> addMovie()
	{
		List<String> movieList = new ArrayList<String>();
		movieList.add("Pink");
		movieList.add("URI : The Surgical Strike");
		return movieList;
	}

	@ExceptionHandler(TheaterNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(TheaterNotFoundException ex) {
		Log.error("handleTheaterNotFound()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("handleAll()", ex);// this will get logged
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}
