package music.management.system;

import config.SetUpData;
import kotlin.jvm.JvmOverloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Vector;

public class Library {
    private static Vector<Album> albums = new Vector<Album>();
    private static Vector<MusicArtist> musicArtists = new Vector<MusicArtist>();
    private static Vector<Song> songs = new Vector<Song>();
    private static Vector<PodcastArtist> podcastArtists = new Vector<PodcastArtist>();
    private static Vector<Podcast> podcasts = new Vector<Podcast>();
    private static Vector<Playlist> playlists = new Vector<Playlist>();
    private static BufferedWriter bf;

    static {
        try {
            bf = new BufferedWriter(new FileWriter("./action_timestamp.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeBuffer() throws IOException {
        bf.close();
    }

    private static void storeActionTimestamp(String action_name, long timestamp) throws IOException {
        String csvSeparator = ",";
        bf.write(action_name + csvSeparator + timestamp + "\n");
    }

    @JvmOverloads
    public static MusicArtist findOrCreateMusicArtistByName(String name) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (MusicArtist artist : musicArtists) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return new MusicArtist(name);
    }

    @JvmOverloads
    public static MusicArtist findOrCreateMusicArtistByName(String name, Album album) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (MusicArtist artist : musicArtists) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return new MusicArtist(name, album);
    }

    public static Song findOrCreateSongByName(String name, String genre, String album, String artist, Integer duration) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Song song : songs) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return new Song(name, genre, album, artist, duration);
    }

    public static Album findOrCreateAlbumByName(String name, String genre, MusicArtist artist) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Album album : albums) {
            if (album.getName().equals(name)) {
                return album;
            }
        }
        return new Album(genre, name, artist);
    }

    public static PodcastArtist findOrCreatePodcastArtistByName(String artistName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (PodcastArtist podcastArtist : podcastArtists){
            if (podcastArtist.getName().equals(artistName)){
                return podcastArtist;
            }
        }
        return new PodcastArtist(artistName);
    }

    public static void addMusicArtist(MusicArtist artist) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        musicArtists.add(artist);
    }

    public static void addPodcastArtist(PodcastArtist artist) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        podcastArtists.add(artist);
    }

    public static void addPodcast(Podcast podcast) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        podcasts.add(podcast);
    }

    public static void addAlbum(Album album) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        albums.add(album);
    }

    public static void addPlaylist(Playlist playlist) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        playlists.add(playlist);
    }

    public static void addSongToPlaylist(Song song, String playlistName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Playlist playlist1 : playlists){
            if (playlist1.getName().equals(playlistName)){
                playlist1.addSong(song);
                return;
            }
        }
        Playlist newPlaylist = new Playlist(playlistName, song);
        playlists.add(newPlaylist);
    }

    public static void addSongToAlbum(Song song, Album album) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Album album1 : Library.albums) {
            if (album1 == album) {
                album1.addSong(song);
            }
        }
    }

    public static void addAlbumToArtist(Album album, MusicArtist artist) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Album album1 : artist.getAlbums()) {
            if (album == album1) {
                return;
            }
        }
        artist.appendAlbum(album);
    }

    public static void addSong(Song song) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        songs.add(song);
    }


    public static Vector<Album> getAlbums() {
        return albums;
    }

    public static Vector<MusicArtist> getMusicArtists() {
        return musicArtists;
    }

    public static Vector<Song> getSongs() {
        return songs;
    }

    public static void printAlbums() throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Album album : albums) {
            System.out.println("Album name: " + album.getName() + ", genre: " + album.getGenre() + " by " + album.getArtist().getName() + " duration: " + album.getDuration());
            Vector<Song> albumSongs = album.getSongs();
            for (Song song : albumSongs) {
                System.out.println("___ ** Song name :" + song.getName() + " duration : " + song.getDuration());
            }
        }
        System.out.println();
    }

    public static void printPlaylistByName(String playlistName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Playlist playlist:playlists){
            if(playlist.getName().equals(playlistName)){
                for (Song song : playlist.getList()) {
                    System.out.println("___ ** Song name :" + song.getName() + " duration : " + song.getDuration());
                }
                return;
            }
        }
        System.out.println("Playlist with name " + playlistName + " is not found!");
        System.out.println();

    }

    public static void printPodcastArtists() throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for(PodcastArtist artist : podcastArtists){
            System.out.println("Artist name: " + artist.getName() + " produced " + artist.getPodcasts().size() + " podcasts:");
            for (Podcast podcast : podcasts){
                if (podcast.getArtist().getName().equals(artist.getName()))
                System.out.println("__* Podcast name :" + podcast.getName() + " by: " + podcast.getArtist().getName() + ", duration: " + podcast.getDuration());
            }
        }
        System.out.println();
    }

    public static Vector<PodcastArtist> getPodcastArtists() {

        return podcastArtists;
    }

    public static Vector<Podcast> getPodcasts() {

        return podcasts;
    }

    public static Vector<Playlist> getPlaylists() {
        return playlists;
    }

    public static void printPodcasts() throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Podcast podcast : podcasts) {
            System.out.println("Podcast name :" + podcast.getName() + " by: " + podcast.getArtist().getName() + ", duration: " + podcast.getDuration());
        }
        System.out.println();
    }

    public static void printSongs() throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Song song : songs) {
            System.out.println("Song name :" + song.getName() + " artist: " + song.getArtist().getName() + ", album: " + song.getAlbum().getName());
        }
        System.out.println();
    }

    public static void printArtists() throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (MusicArtist artist : musicArtists) {
            System.out.println("Artist name: " + artist.getName());
        }
        System.out.println();
    }

    public static void printSongsFromAlbum(String albumName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Song song :songs){
            if (song.getAlbum().getName().equals(albumName)){
                System.out.println("Song name :" + song.getName() + " artist: " + song.getArtist().getName() + ", album: " + song.getAlbum().getName());
            }
        }
    }

    public static void printAlbumsFromArtist(String artistName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Album album :albums){
            if (album.getArtist().getName().equals(artistName)){
                System.out.println("Album name: " + album.getName() + ", genre: " + album.getGenre() + " by " + album.getArtist().getName() + " duration: " + album.getDuration());
            }
        }
    }

    public static void printSongsFromArtist(String artistName) throws IOException {
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        storeActionTimestamp(nameofCurrMethod, (new Timestamp(System.currentTimeMillis())).getTime());

        for (Song song :songs){
            if (song.getArtist().getName().equals(artistName)){
                System.out.println("Song name :" + song.getName() + " artist: " + song.getArtist().getName() + ", album: " + song.getAlbum().getName());
            }
        }
    }

    public static void storeAllInDataBase(){
        SetUpData setUpData = new SetUpData();
        setUpData.setUp();

        for(Song song : getSongs()){
            setUpData.addSong(song);
        }

        for(Album album : getAlbums()){
            setUpData.addAlbum(album);
        }

        for(Artist artist : getMusicArtists()){
            setUpData.addArtist(artist);
        }

        for(Podcast podcast : getPodcasts()){
            setUpData.addPodcast(podcast);
        }
    }

}
