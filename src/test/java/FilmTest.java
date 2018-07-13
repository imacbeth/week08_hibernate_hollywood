import db.DBHelper;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    Studio studio1;
    Director director1;
    Film film;

    @Before
    public void setUp(){
        studio1 = new Studio("Lionsgate", 30000000.00);

        director1 = new Director("Damien", "Chazelle", 2500000.00);

        film = new Film("La La Land", director1, studio1, "Musical");

    }

    @Test
    public void hasTitle() {
        assertEquals("La La Land", film.getTitle());
    }


    @Test
    public void hasDirector() {
        assertEquals(director1, film.getDirector());
    }

    @Test
    public void hasStudio() {
        assertEquals(studio1, film.getStudio());
    }

    @Test
    public void hasGenre() {
        assertEquals("Musical", film.getGenre());
    }
}
