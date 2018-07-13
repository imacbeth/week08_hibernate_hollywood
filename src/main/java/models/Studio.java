package models;

import java.util.List;

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


}
