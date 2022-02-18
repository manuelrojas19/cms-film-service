package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.dto.FilmDto;
import com.ibm.academy.cinema.apirest.filmservice.entity.Film;

public interface FilmService {
    Film create(Film film);
}
