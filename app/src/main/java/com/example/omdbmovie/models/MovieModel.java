package com.example.omdbmovie.models;

public class MovieModel {

    String  slika, naslov, godina, moviid;


        public MovieModel(){}


        public String getSlika() {
            return slika;
        }
        public void   setSlika(String slika) {
            this.slika = slika;
        }

        public String getNaslov() {
            return naslov;
        }
        public void   setNaslov(String naslov) {
            this.naslov = naslov;
        }

        public String getGodina() {
            return godina;
        }
        public void   setGodina(String godina) {
            this.godina = godina;
        }

        public String getMoviid() {
            return moviid;
        }
        public void   setMoviid(String moviid) {
            this.moviid = moviid;
        }
}

