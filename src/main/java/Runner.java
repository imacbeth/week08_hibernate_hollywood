import db.DBFilm;
import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

public class Runner {

    public static void main(String[] args){

        Studio studio1 = new Studio("Lionsgate", 30000000.00);
        DBHelper.save(studio1);

        Director director1 = new Director("Damien", "Chazelle", 2500000.00);
        DBHelper.save(director1);

        Actor ryan = new Actor("Ryan", "Gosling", 4000000.00);
        DBHelper.save(ryan);

        Actor emma = new Actor("Emma", "Stone", 3000000.00);
        DBHelper.save(emma);


        Film film1 = new Film("La La Land", director1, studio1, "Musical");
        DBHelper.save(film1);

        DBFilm.addActorToFilm(ryan, film1);
        DBFilm.addActorToFilm(emma, film1);

        Director director =  DBFilm.getDirectorForFilm(film1);

        List<Actor> cast = DBFilm.getCastForFilm(film1);

    }
}
