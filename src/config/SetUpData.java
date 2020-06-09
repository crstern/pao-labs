package config;

import music.management.system.Album;
import music.management.system.Artist;
import music.management.system.Podcast;
import music.management.system.Song;
import repository.RepositoryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SetUpData {
    public void setUp(){

        String words_length = "60";
        String createSongsTableSql =  "CREATE TABLE IF NOT EXISTS songs(" +
                "name varchar(" + words_length + ")," +
                "genre varchar(" + words_length + ")," +
                "album varchar(" + words_length + ")," +
                "artist varchar(" + words_length + ")," +
                "duration int," +
                "PRIMARY KEY (name, album, artist)," +
                "UNIQUE(name)" +
                ")";

        String createAlbumsTableSql = "CREATE TABLE IF NOT EXISTS albums(" +
                "name varchar(" + words_length + ")," +
                "genre varchar(" + words_length + ")," +
                "artist varchar(" + words_length + ")," +
                "duration int," +
                "PRIMARY KEY(name)" +
                ")";

        String createArtistsTableSql = "CREATE TABLE IF NOT EXISTS artists(" +
                "name varchar(" + words_length + ")," +
                "PRIMARY KEY(name)" +
                ")";

        String createPodcastsTableSql = "CREATE TABLE IF NOT EXISTS podcasts(" +
                "name varchar(" + words_length + ")," +
                "artist varchar(" + words_length + ")," +
                "duration int," +
                "PRIMARY KEY (name)," +
                "UNIQUE (name)" +
                ")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try{
            repositoryHelper.executeSql(databaseConnection, createSongsTableSql);
            repositoryHelper.executeSql(databaseConnection, createAlbumsTableSql);
            repositoryHelper.executeSql(databaseConnection, createArtistsTableSql);
            repositoryHelper.executeSql(databaseConnection, createPodcastsTableSql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSong(Song song) {
        String insertSongSql = "INSERT INTO songs(name, genre, album, artist, duration) " +
                "VALUES('" +
                song.getName() + "','" +
                song.getGenre() + "','" +
                song.getAlbum().getName() + "','" +
                song.getArtist().getName() + "'," +
                song.getDuration().toString() +
                ")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertSongSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAlbum(Album album) {
        String insertAlbumSql = "INSERT INTO albums(name, genre, artist, duration) " +
                "VALUES('" +
                album.getName() + "','" +
                album.getGenre() + "','" +
                album.getArtist().getName() + "'," +
                album.getDuration().toString() +
                ")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertAlbumSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addArtist(Artist artist) {
        String insertArtistsSql = "INSERT INTO artists(name) " +
                "VALUES('" +
                artist.getName() + "'" +
                ")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertArtistsSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPodcast(Podcast podcast) {
        String insertPodcastSql = "INSERT INTO podcasts(name, artist, duration) " +
                "VALUES('" +
                podcast.getName() + "','" +
                podcast.getArtist().getName() + "'," +
                podcast.getDuration().toString() +
                ")";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPodcastSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void displaySongs() {
        String selectSql = "SELECT * FROM songs";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
        System.out.println("--- SONGS ---:\n");

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Song name:" + resultSet.getString(1));
                System.out.println("Genre:" + resultSet.getString(2));
                System.out.println("Album:" + resultSet.getString(3));
                System.out.println("Artist:" + resultSet.getString(4));
                System.out.println("Duration:" + resultSet.getInt(5));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAlbums() {
        String selectSql = "SELECT * FROM albums";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
        System.out.println("--- ALBUMS ---:\n");
        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Album name:" + resultSet.getString(1));
                System.out.println("Album:" + resultSet.getString(2));
                System.out.println("Artist:" + resultSet.getString(3));
                System.out.println("Duration:" + resultSet.getInt(4));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayArtists() {
        String selectSql = "SELECT * FROM artists";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
        System.out.println("--- ARTISTS ---:\n");
        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Artist name:" + resultSet.getString(1));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPodcasts() {
        String selectSql = "SELECT * FROM podcasts";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
        System.out.println("--- PODCASTS ---:\n");
        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Podcast title:" + resultSet.getString(1));
                System.out.println("Artist:" + resultSet.getString(2));
                System.out.println("Duration:" + resultSet.getInt(3));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
