package music.management;

import music.management.system.*;

import java.io.*;

public class ManageWithFiles {
    private static ManageWithFiles onlyInstance;

    private String loadArtistFile;
    private String loadPodcastsFile;
    private String loadSongsFile;
    private String loadAlbumsFile;

    private String storeArtistFile;
    private String storePodcastsFile;
    private String storeAlbumsFile;
    private String storeSongsFile;

    private ManageWithFiles(String loadArtistFile, String loadPodcastsFile, String loadSongsFile, String loadAlbumsFile, String storeArtistFile, String storePodcastsFile, String storeSongsFile, String storeAlbumsFile) {
        this.loadArtistFile = loadArtistFile;
        this.loadPodcastsFile = loadPodcastsFile;
        this.loadSongsFile = loadSongsFile;
        this.loadAlbumsFile = loadAlbumsFile;
        this.storeArtistFile = storeArtistFile;
        this.storePodcastsFile = storePodcastsFile;
        this.storeAlbumsFile = storeAlbumsFile;
        this.storeSongsFile = storeSongsFile;
    }

    public static ManageWithFiles getInstance(String loadArtistFile, String loadPodcastsFile, String loadSongsFile,
                                              String loadAlbumsFile, String storeArtistFile, String storePodcastsFile,
                                              String storeAlbumsFile, String storeSongsFile) {
        if (onlyInstance == null){
            onlyInstance = new ManageWithFiles(loadArtistFile, loadPodcastsFile, loadSongsFile, loadAlbumsFile,
                    storeArtistFile,storePodcastsFile, storeAlbumsFile, storeSongsFile);
        }
        return onlyInstance;
    }

    public void loadAll(){
        this.loadArtists();
        this.loadAlbums();
        this.loadSongs();
        this.loadPodcasts();
    }

    public void loadArtists(){
        BufferedReader bf = null;
        String musicArtistName = "";
        String csvSplitBy = ",";
        try {
            bf = new BufferedReader(new FileReader(this.loadArtistFile));
            while ((musicArtistName = bf.readLine()) != null) {
//                String []lineSpliced = line.split(csvSplitBy)
                new MusicArtist(musicArtistName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadSongs(){
        BufferedReader bf = null;
        String line = "";
        String csvSplitBy = ",";
        try {

            bf = new BufferedReader(new FileReader(this.loadSongsFile));
            while ((line = bf.readLine()) != null) {


                String []lineSpliced = line.split(csvSplitBy);

                String song = lineSpliced[0];
                String genre = lineSpliced[1];
                String album = lineSpliced[2];
                String musicArtist = lineSpliced[3];
                Integer duration = Integer.parseInt(lineSpliced[4]);

                new Song(song, genre, album, musicArtist, duration);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadAlbums(){
        BufferedReader bf = null;
        String line = "";
        String csvSplitBy = ",";
        try {
            bf = new BufferedReader(new FileReader(this.loadAlbumsFile));
            while ((line = bf.readLine()) != null) {

                String []items = line.split(csvSplitBy);
                String genre = items[0];
                String albumName = items[1];
                String artistName = items[2];

                new Album(genre, albumName, artistName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadPodcasts(){
        BufferedReader bf = null;
        String line = "";
        String csvSplitBy = ",";
        try {
            bf = new BufferedReader(new FileReader(this.loadPodcastsFile));
            while ((line = bf.readLine()) != null) {

                String []items = line.split(csvSplitBy);
                String name = items[0];
                String podcastArtist = items[1];
                Integer duration = Integer.parseInt(items[2]);

                new Podcast(name, podcastArtist, duration);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void storeArtists() {
        BufferedWriter bf = null;
        String csvSplitBy = ",";
        try {
            bf = new BufferedWriter(new FileWriter(this.storeArtistFile));
            for (Artist artist : Library.getMusicArtists()) {
                bf.write(artist.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void storeAlbums() {
        BufferedWriter bf = null;
        String csvSplitBy = ",";
        try {
            bf = new BufferedWriter(new FileWriter(this.storeAlbumsFile));
            for (Album album : Library.getAlbums()) {
                bf.write(album.getName() + csvSplitBy + album.getGenre() + csvSplitBy + album.getArtist().getName() +
                        csvSplitBy + album.getDuration() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void storeSongs() {
        BufferedWriter bf = null;
        String csvSplitBy = ",";
        try {
            bf = new BufferedWriter(new FileWriter(this.storeSongsFile));
            for (Song song : Library.getSongs()) {
                bf.write(song.getName() + csvSplitBy + song.getGenre() + csvSplitBy + song.getArtist().getName() +
                        csvSplitBy + song.getDuration() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void storePodcasts() {
        BufferedWriter bf = null;
        String csvSplitBy = ",";
        try {
            bf = new BufferedWriter(new FileWriter(this.storePodcastsFile));
            for (Podcast podcast : Library.getPodcasts()) {
                bf.write(podcast.getName() + csvSplitBy + podcast.getGenre() + csvSplitBy + podcast.getArtist().getName() +
                        csvSplitBy + podcast.getDuration() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
