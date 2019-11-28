package com.example.omdbmovie.models;

public class DetailsModel {


    private String  released,   runtime, genre, director, production,
            imdbRating, writer,  actors, title, year,     poster;


        public DetailsModel() {
        }


        public String getReleased() {
            return released;
        }
        public void   setReleased(String released) {
            this.released = released;
        }

        public String getRuntime() {
            return runtime;
        }
        public void   setRuntime(String runtime) {
            this.runtime = runtime;
        }

        public String getGenre() {
            return genre;
        }
        public void   setGenre(String genre) {
            this.genre = genre;
        }

        public String getDirector() {
            return director;
        }
        public void   setDirector(String director) {
            this.director = director;
        }

        public String getProduction() {
            return production;
        }
        public void   setProduction(String production) {
            this.production = production;
        }

        public String getImdbRating() {
            return imdbRating;
        }
        public void   setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
        }

        public String getWriter() {
            return writer;
        }
        public void   setWriter(String writer) {
            this.writer = writer;
        }

        public String getActors() {
            return actors;
        }
        public void   setActors(String actors) {
            this.actors = actors;
        }

        public String getTitle() {
            return title;
        }
        public void   setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }
        public void   setYear(String year) {
            this.year = year;
        }

        public String getPoster() {
            return poster;
        }
        public void   setPoster(String poster) {
            this.poster = poster;
        }
}
