import db.DBHelper;
import models.Actor;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Actor actor1;
    Actor actor2;

    @Before
    public void setUp() {
        actor1 = new Actor("Ryan", "Gosling", 4000000.00);

        actor2 = new Actor("Emma", "Stone", 4000000.00);

    }

    @Test
    public void hasFirstName() {
        assertEquals("Ryan", actor1.getFirstName());
    }

    @Test
    public void hasLastName() {
        assertEquals("Stone", actor2.getLastName());

    }

    @Test
    public void hasBankAccount() {
        assertEquals(4000000.00, actor1.getBankAccount());
    }
}
