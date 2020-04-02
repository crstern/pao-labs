package music.management.system;

public class Song {
    private String name = "";
    private String genre = "<unk>";
    private Album album = null;
    private MusicArtist artist = null;
    private Integer duration = 3;

    public Song(String name, String genre, String albumName, String artistName, Integer duration){
        this.name = name;
        this.genre = genre;
        this.artist = Library.findOrCreateMusicArtistByName(artistName);
        this.duration = duration;
        this.album = Library.findOrCreateAlbumByName(albumName, genre, this.artist, duration);
        this.album.addSong(this);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public MusicArtist getArtist() {
        return artist;
    }

    public void setArtist(MusicArtist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


}
