package com.sergif.crudPractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String original_title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imdb_id;
    //private Array genres; // TODO: Mirar com passar les arrays (crear taules/objectes noves o com)
    private String original_language;
    private String overview;
    private Integer popularity;
    private String poster_path;
    //private Array production_companies;
    //private Array production_countries;
    private Date release_date;
    private Integer runtime;
    //private Array spoken_languages;
    private String title;
    private Double vote_average;
    private Integer vote_count;

}
