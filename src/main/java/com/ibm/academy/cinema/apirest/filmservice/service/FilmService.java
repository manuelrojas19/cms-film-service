package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();
    Film create(Film film);
    Film update(Long id, Film film);
    void delete(Long id);
    Film addDirectorToFilm(String directorName, Long filmId);
    Film addActorToFilm(String actorName, Long filmId);
    Film addCategoryToFilm(String categoryName, Long filmId);
}
