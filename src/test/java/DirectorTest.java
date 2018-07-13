import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    Studio studio1;
    Studio studio2;
    Director director1;
    Director director2;
    Film film;

    @Before
    public void setUp() throws Exception {

        director1 = new Director("Damien", "Chazelle", 2500000.00);
        director2 = new Director("Billy", "Wilder", 2500000.00);
    }


    @Test
    public void hasFirstName() {
        assertEquals("Damien", director1.getFirstName());
    }

    @Test
    public void canSetFirstName() {
        director1.setFirstName("Chris");
        assertEquals("Chris", director1.getFirstName());
    }


    @Test
    public void hasLastName() {
        assertEquals("Chazelle", director1.getLastName());
    }

    @Test
    public void canSetLastName() {
        director1.setLastName("Wilder");
        assertEquals("Wilder", director1.getLastName());
    }

    @Test
    public void hasBankAccount() {
        assertEquals(2500000.00, director1.getBankAccount());
    }

}
