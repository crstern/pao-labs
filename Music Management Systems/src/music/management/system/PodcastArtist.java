package music.management.system;

import java.io.IOException;
import java.util.Vector;

public class PodcastArtist extends Artist {
    private Vector<Podcast> podcasts = null;

    public PodcastArtist(String name) throws IOException {
        this.name = name;
        this.podcasts = new Vector<Podcast>();
        Library.addPodcastArtist(this);
    }

    public Vector<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(Vector<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public void addPodcast(Podcast podcast){
        this.podcasts.add(podcast);
    }
}

