package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.repository.CategoryRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.FilmRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Film create(Film film) {
        return filmRepository.save(film);
    }
}
