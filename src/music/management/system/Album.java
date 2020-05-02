package music.management.system;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class Album {
    private String genre = "";
    private String name = "<unk>";
    private MusicArtist artist = null;
    private Integer duration = 40;
    private Date releaseDate = null;
    private Vector<Song> songs = null;


    public Album(String genre, String name, String artistName, Integer duration, Date releaseDate, Vector<Song> songs) throws IOException {
        this.genre = genre;
        this.name = name;
        this.artist = Library.findOrCreateMusicArtistByName(artistName, this);
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.songs = songs;
        Library.addAlbum(this);
        Library.addAlbumToArtist(this, this.artist);
    }

    public Album(String genre, String name, String artistName) throws IOException {
        this.genre = genre;
        this.name = name;
        this.duration = 0;
        this.songs = new Vector<Song>();
        this.artist = Library.findOrCreateMusicArtistByName(artistName, this);
        this.artist.appendAlbum(this);
        Library.addAlbum(this);
    }


    public Album(String genre, String name, MusicArtist artist) throws IOException {
        this.duration = 0;
        this.genre = genre;
        this.name = name;
        this.artist = artist;
        this.songs = new Vector<Song>();
        Library.addAlbum(this);
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicArtist getArtist() {
        return artist;
    }

    public void setArtist(MusicArtist artist) {
        this.artist = artist;
    }

    public void addSong(Song song) throws IOException {
        Library.addSong(song);
        this.songs.add(song);
        this.duration += song.getDuration();
    }

    public Vector<Song> getSongs() {
        return songs;
    }
}
