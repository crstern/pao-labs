import music.management.system.*;

import java.util.Vector;


public class Main {

    public static void main(String[] args){
        /*
        1 add a new song(durationm, name, collection (album/disk or ep), artist)
        2 add a new album(name, genre, disk, artist)
        3 add a new musicArtist(name, genres, albums)
        4 add a new podcastArtist(name, genres, podcasts)
        5 add a new Podcast(name, artist, genre)
        6 add a playlist(songs, genres)
        7 add a podacastPlaylist(podcasts)
        8 delete a song(name, artist)
        9 delete an album(name, artist)
        10 delete an artist(name)
        11 delete a podcast(name, artist)


        //Song
        //Album
        Podcast
        Artist
        //musicArtist
        podcastArtist
        musicPlaylist
        podcastPlaylist

         */
        Album masterOfPuppets = new Album("Metal", "Master Of Puppets", "Metallica");
        Album ride = new Album("Metal", "Ride the Lightning", "Metallica");

        Song track1 = new Song("Master Of Puppets", "Metal", "Master Of Puppets", "Metallica", 8);
        Song track2 = new Song("Battery", "Metal", "Master Of Puppets", "Metallica", 5);
        Song track3 = new Song("Disposable Heroes", "Metal", "Master Of Puppets", "Metallica", 7);



        Song track4 = new Song("Berzerk", "Rap", "MMLP2", "Eminem", 4);
        Song track5 = new Song("Rap God", "Rap", "MMLP2", "Eminem", 5);
        Song track6 = new Song("For Whom the Bell Tolls", "Metal", "Ride the Lightning", "Metallica", 7);

        Library.printSongs();

    }


}
