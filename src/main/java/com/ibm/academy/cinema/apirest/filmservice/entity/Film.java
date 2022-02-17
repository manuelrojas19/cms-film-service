package com.ibm.academy.cinema.apirest.filmservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date date;

    @ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)
    private List<Category> categories;

    @ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)
    private List<Actor> actors;

    @ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)
    private List<Director> directors;
}
