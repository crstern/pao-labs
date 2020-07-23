package config;

import music.management.system.Album;
import music.management.system.Library;
import music.management.system.MusicArtist;
import music.management.system.Song;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Spotify {

    private static String[] getSongsNames(){
        int index = 0;
        String[] songNames = new String[Library.getSongs().size()];

        for (Song song : Library.getSongs()){
            String songName = song.getName();
            songNames[index] = songName;
            index++;
        }
        return songNames;
    }

    private static String[] getAlbumsNames(){
        int index = 0;
        String[] albumNames = new String[Library.getAlbums().size()];

        for (Album album : Library.getAlbums()){
            String albumName = album.getName();
            albumNames[index] = albumName;
            index++;
        }
        return albumNames;
    }

    private static String[] getArtistsNames(){
        int index = 0;
        String[] artistsNames = new String[Library.getMusicArtists().size()];

        for (MusicArtist artist : Library.getMusicArtists()){
            String artistName = artist.getName();
            artistsNames[index] = artistName;
            index++;
        }
        return artistsNames;
    }

    private static JTabbedPane createJTabbedPane(){
        JTabbedPane panou = new JTabbedPane();
        JTextArea textArea = new JTextArea(5, 30);
        String[] songNames = getSongsNames();
        String[] albumNames = getAlbumsNames();
        String[] artistNames = getArtistsNames();



        JList lista1 = new JList(songNames);
        JList lista2 = new JList(albumNames);
        JList lista3 = new JList(artistNames);

        JScrollPane songs = new JScrollPane(lista1);
        JScrollPane albums = new JScrollPane(lista2);
        JScrollPane artists = new JScrollPane(lista3);

        panou.addTab("Songs", songs);
        panou.addTab("Albums", albums);
        panou.addTab("Artists", artists);
        return panou;
    }

    public static void main(String[] args) throws IOException, SQLException {
        SetUpData setUpData = new SetUpData();
        setUpData.loadAllSongs();
        JFrame frame = new JFrame("HelloWorld");
        JTabbedPane pane = createJTabbedPane();
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);

    }



    private JPanel rootPanel;
}
