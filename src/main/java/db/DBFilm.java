package db;

import models.Actor;
import models.Director;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;

    public static void addActorToFilm(Actor actor, Film film){
        film.addActorToFilm(actor);
        DBHelper.update(film);
    }

    public static List<Actor> getCastForFilm(Film film){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> cast = null;

        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("films", "film");
            cr.add(Restrictions.eq("film.id", film.getId()));
            cast = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return cast;
    }

    public static Director getDirectorForFilm(Film film){
        session = HibernateUtil.getSessionFactory().openSession();
        Director director = null;

        try {
            Criteria cr = session.createCriteria(Director.class);
            cr.createAlias("films", "film");
            cr.add(Restrictions.eq("film.id", film.getId()));
            director = (Director) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return director;
    }
}
