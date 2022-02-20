package com.ibm.academy.cinema.apirest.filmservice.repository;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findById(Long id);
    List<Film> findAll();
}
