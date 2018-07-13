package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film {

    private int id;
    private String title;
    private Director director;
    private List<Actor> cast;
    private Studio studio;
    private String genre;

    public Film() { }

    public Film(String title, Director director, Studio studio, String genre) {
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.genre = genre;
        this.cast = new ArrayList<Actor>();
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

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "films_actors",
    joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addActorToFilm(Actor actor){
        this.cast.add(actor);
    }


}
