package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    private ResponseEntity<List<Film>> findAll() {
        List<Film> films = filmService.findAll();
        return ResponseEntity.ok(films);
    }

    @PostMapping
    private ResponseEntity<Film> crete(@RequestBody Film film) {
        return ResponseEntity.ok(filmService.create(film));
    }

}
