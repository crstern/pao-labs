package music.management.system;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private ArrayList<Song> list = new ArrayList<Song>();
    private Integer numberOfSongs = 0;
    private Integer duration = 0;

    public Integer getNumberOfSongs() {
        return numberOfSongs;
    }

    public Integer getDuration() {
        return duration;
    }

    public ArrayList<Song> getList() {
        return list;
    }

    public void setList(ArrayList<Song> list) {
        this.list = list;
    }

    public Playlist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Playlist(String name, Song song){
        this.name = name;
        this.list.add(song);
        this.numberOfSongs++;
        this.duration += song.getDuration();
    }

    public void addSong(Song song) {
        list.add(song);
        numberOfSongs++;
        duration += song.getDuration();
    }

}
