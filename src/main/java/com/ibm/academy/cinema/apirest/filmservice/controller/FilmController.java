package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    private ResponseEntity<Film> create(@RequestBody Film film) {
        log.debug("Film to add: {}",  film);
        return ResponseEntity.ok(filmService.create(film));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    private ResponseEntity<Film> update(@PathVariable Long id, @RequestBody Film film) {
        return ResponseEntity.accepted().body(filmService.update(id, film));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
