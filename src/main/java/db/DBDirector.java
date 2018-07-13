package db;

import models.Actor;
import models.Director;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDirector {

    private static Session session;

    public static List<Film> getDirectorsFilms(Director director){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("director", director));
            films = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }

        return films;
    }


}
