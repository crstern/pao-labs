import config.SetUpData;
import music.management.ManageWithFiles;
import music.management.system.*;


import javax.swing.*;
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


        Library.printAlbumsFromArtist("Eminem");
        Library.printPodcastArtists();
        Library.printArtists();
        Library.printAlbums();
//        Library.closeBuffer();
        SetUpData setUpData = new SetUpData();



        Song track0 = setUpData.getSongByName("Mother");
        Album album = setUpData.getAlbumByName("The Wall");

        MusicArtist artist = setUpData.getArtistByName("Pink Floyd");

        Library.printAlbums();


    }


}
