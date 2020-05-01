package music.management.system;

public class Song extends Track {
    private Album album;
    private MusicArtist artist;

    public Song(String name, String genre, String albumName, String artistName, Integer duration) {
        this.name = name;
        this.genre = genre;
        this.artist = Library.findOrCreateMusicArtistByName(artistName);
        this.duration = duration;
        this.album = Library.findOrCreateAlbumByName(albumName, genre, this.artist);
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
}
