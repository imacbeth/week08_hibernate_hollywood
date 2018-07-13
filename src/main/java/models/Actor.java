package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends Employee {

    private List<Film> films;

    public Actor() { }

    public Actor(String firstName, String lastName, double bankAccount, List<Film> films) {
        super(firstName, lastName, bankAccount);
        this.films = films;
    }

    @Column(name = "films")
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
