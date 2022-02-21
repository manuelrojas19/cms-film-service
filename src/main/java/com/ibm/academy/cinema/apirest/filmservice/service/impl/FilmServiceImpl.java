package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Actor;
import com.ibm.academy.cinema.apirest.filmservice.entity.Category;
import com.ibm.academy.cinema.apirest.filmservice.entity.Director;
import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.repository.ActorRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.CategoryRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.DirectorRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.FilmRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Film> findAll() {
        List<Film> films = filmRepository.findAll();
        if (films.isEmpty())
            throw new RuntimeException("Not founded");
        return films;
    }

    @Override
    public Film create(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film update(Long id, Film film) {
        Film filmToUpdate = filmRepository.findById(id).orElseThrow();
        filmToUpdate.setTitle(film.getTitle());
        filmToUpdate.setDescription(film.getDescription());
        filmToUpdate.setDate(filmToUpdate.getDate());
        return filmRepository.save(filmToUpdate);
    }


    @Override
    public void delete(Long id) {
        Film film = filmRepository.findById(id).orElseThrow();
        filmRepository.delete(film);
    }

    @Override
    public Film addDirectorToFilm(String directorName, Long filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow();
        Director director = directorRepository.findByName(directorName).orElseThrow();
        film.getDirectors().add(director);
        return filmRepository.saveAndFlush(film);
    }

    @Override
    public Film addActorToFilm(String actorName, Long filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow();
        Actor actor = actorRepository.findByName(actorName).orElseThrow();
        film.getActors().add(actor);
        return filmRepository.saveAndFlush(film);
    }

    @Override
    public Film addCategoryToFilm(String categoryName, Long filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow();
        Category category = categoryRepository.findByName(categoryName).orElseThrow();
        film.getCategories().add(category);
        return filmRepository.saveAndFlush(film);
    }


}
