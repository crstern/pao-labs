package music.management.system;

import kotlin.jvm.JvmOverloads;

import java.util.Vector;

public class Library {
    private static Vector<Album> albums = new Vector<Album>();
    private static Vector<MusicArtist> musicArtists = new Vector<MusicArtist>();
    private static Vector<Song> songs = new Vector<Song>();

    public static MusicArtist findOrCreateMusicArtistByName(String name){
        for (MusicArtist artist : musicArtists){
            if (artist.getName().equals(name)){
                return artist;
            }
        }
        MusicArtist newArtist = new MusicArtist(name);
        return newArtist;
    }

    @JvmOverloads
    public static MusicArtist findOrCreateMusicArtistByName(String name, Album album){
        for (MusicArtist artist : musicArtists){
            if (artist.getName().equals(name)){
                return artist;
            }
        }
        MusicArtist newArtist = new MusicArtist(name, album);
        return newArtist;
    }

    public static Album findOrCreateAlbumByName(String name, String genre, MusicArtist artist, Integer duration){
        for (Album album: albums){
            if (album.getName().equals(name)){
                return album;
            }
        }
        return new Album(genre, name, artist);
    }

    public static void addMusicArtist(MusicArtist artist){
        musicArtists.add(artist);
    }

    public static void addAlbum(Album album){
        albums.add(album);
    }

    public static void addSongToAlbum(Song song, Album album){
        for(Album album1: Library.albums){
            if(album1 == album){
                album1.addSong(song);
            }
        }
    }

    public static void addAlbumToArtist(Album album, MusicArtist artist){
        for(Album album1:artist.getAlbums()){
            if(album == album1){
                return;
            }
        }
        artist.appendAlbum(album);
    }

    public static void addSong(Song song){
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

    public static void printAlbums(){
        for(Album album: albums){
           System.out.println("Album name: " + album.getName() + ", genre: " + album.getGenre() + " by " + album.getArtist().getName() + " duration: " + album.getDuration());
           Vector<Song> albumSongs = album.getSongs();
           for(Song song : albumSongs){
               System.out.println("___ ** Song name :" + song.getName() + " duration : " + song.getDuration());
           }
        }
    }

    public static void printSongs(){
        for (Song song : songs){
            System.out.println("Song name :" + song.getName() + " artist: " + song.getArtist().getName() + ", album: " + song.getAlbum().getName());
        }
    }

    public static void printArtists(){
        for (MusicArtist artist : musicArtists){
            System.out.println("Artist name: " + artist.getName());
        }
    }
}
