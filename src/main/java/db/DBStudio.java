package db;

import models.Employee;
import models.Studio;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.util.List;


public class DBStudio {

    private static Session session;

    public static List<Film> getStudiosFilms(Studio studio){
        session = HibernateUtil.getSessionFactory().openSession();

        List<Film> films = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("studio", studio));
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


    public static void canPayEmployee(Studio studio, Employee employee, double amount){
        studio.payEmployee(employee, amount);
        DBHelper.update(studio);
    }
}
