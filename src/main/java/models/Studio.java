package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studio")
public class Studio {

    private int id;
    private String name;
    private int budget;
    private List<Film> films;


    public Studio() { }

    public Studio(String name, int budget, List<Film> films) {
        this.name = name;
        this.budget = budget;
        this.films = films;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Column(name = "films")
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
