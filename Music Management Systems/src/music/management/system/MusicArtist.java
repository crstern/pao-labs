package music.management.system;

import kotlin.jvm.JvmOverloads;

import java.util.Vector;

public class MusicArtist {
    private String name;    //artist name
    private Vector<Album> albums = null; // albums produced by artist
    private Vector<String> genres = null; // geners adopted by artist


    public MusicArtist(String name)
    {
        this.name = name;
        this.genres = null;
        this.albums = null;
        Library.addMusicArtist(this);
    }

    @JvmOverloads
    public MusicArtist(String name, Album album){
        this.name = name;
        this.albums = new Vector<Album>();
        this.albums.add(album);
        this.genres = new Vector<String>();
        this.genres.add(album.getGenre());
        Library.addMusicArtist(this);
    }

    @JvmOverloads
    public MusicArtist(String name, Vector<Album> albums, Vector<String> genres) {
        this.name = name;
        this.albums = albums;
        this.genres = genres;
        Library.addMusicArtist(this);
    }



    public void appendAlbum(Album album){
        /*
        Adds 'album' album and updates the gerers list.
         */
        if(this.albums == null){
            this.albums = new Vector<Album>();
        }



        String albumGenre = album.getGenre();
        for (Album album1 : this.albums) {
            if (album1.getName().equals(album.getName())) {
                return;
            }
        }
        albums.add(album);
        for (Album album1 : this.albums) {
            if (album1.getGenre().equals(albumGenre)) {
                return;
            }
        }
        genres.add(albumGenre);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Vector<String> getGenres() {
        return genres;
    }

    public void setGenres(Vector<String> genres) {
        this.genres = genres;
    }

    public Vector<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Vector<Album> albums) {
        this.albums = albums;
    }
}
