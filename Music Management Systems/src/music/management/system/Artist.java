package music.management.system;

import java.util.Vector;

public abstract class Artist {
    protected String name;    //artist name
    protected Vector<String> genres = null; // geners adopted by artist

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Vector<String> getGenres() {
        return genres;
    }

    public void setGenres(Vector<String> genres) {
        this.genres = genres;
    }
}
