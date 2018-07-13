package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor extends Employee {

    private Set<Film> films;

    public Actor() { }

    public Actor(String firstName, String lastName, double bankAccount) {
        super(firstName, lastName, bankAccount);
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "films_actors",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns =  {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
