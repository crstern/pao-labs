package music.management.system;

import kotlin.jvm.JvmOverloads;

import java.io.IOException;

public class Podcast extends Track {
    private PodcastArtist artist;

    public Podcast(String name, String genre, PodcastArtist artist, Integer duration) throws IOException {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.artist.addPodcast(this);
        Library.addPodcast(this);
    }

    @JvmOverloads
    public Podcast(String name, String genre, String artistName, Integer duration) throws IOException {
        this.name = name;
        this.genre = genre;
        this.artist = Library.findOrCreatePodcastArtistByName(artistName);
        this.duration = duration;
        this.artist.addPodcast(this);
        Library.addPodcast(this);
    }

    @JvmOverloads
    public Podcast(String name, String artistName, Integer duration) throws IOException {
        this.name = name;
        this.genre = "unk";
        this.artist = Library.findOrCreatePodcastArtistByName(artistName);
        this.duration = duration;
        this.artist.addPodcast(this);
        Library.addPodcast(this);
    }


    public PodcastArtist getArtist() {
        return artist;
    }

    public void setArtist(PodcastArtist artist) {
        this.artist = artist;
    }
}
