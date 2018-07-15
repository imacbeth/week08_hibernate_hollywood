import db.*;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

public class Runner {

    public static void main(String[] args){

        Studio studio1 = new Studio("Lionsgate", 30000000.00);
        DBHelper.save(studio1);

        Studio studio2 = new Studio("Warner Bros", 30000000.00);
        DBHelper.save(studio2);

        Director director1 = new Director("Damien", "Chazelle", 2500000.00);
        DBHelper.save(director1);

        Actor ryan = new Actor("Ryan", "Gosling", 4000000.00);
        DBHelper.save(ryan);

        Actor emma = new Actor("Emma", "Stone", 3000000.00);
        DBHelper.save(emma);


        Film film1 = new Film("La La Land", director1, studio1, "Musical");
        DBHelper.save(film1);

        Film film2 = new Film("Whiplash", director1, studio1, "Drama");
        DBHelper.save(film2);

        DBFilm.addActorToFilm(ryan, film1);

        DBFilm.addActorToFilm(emma, film1);

        Director director =  DBFilm.getDirectorForFilm(film1);

        List<Film> goslingsFilms = DBActor.getActorsFilms(ryan);

        List<Film> stonesFilms = DBActor.getActorsFilms(emma);

        List<Actor> cast = DBFilm.getCastForFilm(film1);

        List<Film> chazellesFilms = DBDirector.getDirectorsFilms(director1);

        List<Film> studio1films = DBStudio.getStudiosFilms(studio1);

        DBStudio.canPayEmployee(studio1, emma, 1000000.00);



    }
}
