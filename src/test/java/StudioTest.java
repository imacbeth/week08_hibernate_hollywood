import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio1;
    Studio studio2;
    Director director1;
    Director director2;
    Actor actor1;
    Actor actor2;
    Film film;

    @Before
    public void setUp(){
        studio1 = new Studio("Lionsgate", 30000000.00);
        studio2 = new Studio("Warner Bros", 30000000.00);

        director1 = new Director("Damien", "Chazelle", 2500000.00);
        director2 = new Director("Billy", "Wilder", 2500000.00);
        actor1 = new Actor("Ryan", "Gosling", 4000000.00);

        actor2 = new Actor("Emma", "Stone", 4000000.00);

        film = new Film("La La Land", director1, studio1, "Musical");

        film.addActorToFilm(actor1);
        film.addActorToFilm(actor2);
    }

    @Test
    public void canPayEmployees(){
        studio1.payEmployee(actor2, 1000000.00);
        assertEquals(29000000.00 ,studio1.getBudget());
    }
}
