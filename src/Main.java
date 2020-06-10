import config.SetUpData;
import music.management.ManageWithFiles;
import music.management.system.*;


import java.io.*;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws IOException, SQLException {

//        ManageWithFiles manageWithFiles = ManageWithFiles.getInstance("./data/inputArtist.csv",
//                "./data/inputPodcasts.csv", "./data/inputSongs.csv",
//                "./data/inputAlbums.csv", "./data/outputArtist.csv",
//                "./data/outputPodcasts.csv", "./data/outputSongs.csv",
//                "./data/outputAlbums.csv");
//        manageWithFiles.loadAll();
//        manageWithFiles.storeSongs();
//
//        System.out.println("Print songs from MMLP2: ");
//
//        Library.printSongsFromAlbum("MMLP2");
//        System.out.println("\nPrint songs from Metallica: ");
//        Library.printSongsFromArtist("Metallica");
//        System.out.println("\nPrint songs from Eminem: ");
//
//        Library.printAlbumsFromArtist("Eminem");
//        Library.printPodcastArtists();
//        Library.printArtists();
//        Library.printAlbums();
//        Library.closeBuffer();
        SetUpData setUpData = new SetUpData();


        setUpData.deleteSongByName("Battery");

        Song track0 = setUpData.getSongByName("Battery");
        Album album = setUpData.getAlbumByName("Master of Puppets");
        MusicArtist artist = setUpData.getArtistByName("Metallica");
        Podcast podcast = setUpData.getPodcastByName("Tataee");

        Library.printAlbums();


    }


}
