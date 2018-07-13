package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    private int id;
    private String title;
    private Director director;
    private List<Actor> cast;
    private String genre;

    public Film() { }

    public Film(String title, Director director, List<Actor> cast, String genre) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "director")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Column(name = "cast")
    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
