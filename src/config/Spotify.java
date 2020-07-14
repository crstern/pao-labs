package config;

import music.management.system.Album;
import music.management.system.Library;
import music.management.system.MusicArtist;
import music.management.system.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Spotify {
    public Spotify() {
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Library.printAlbums();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException, SQLException {
        JFrame frame = new JFrame("HelloWorld");
        frame.setContentPane(new Spotify().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        SetUpData setUpData = new SetUpData();



        Song track0 = setUpData.getSongByName("Mother");
        Album album = setUpData.getAlbumByName("The Wall");

        MusicArtist artist = setUpData.getArtistByName("Pink Floyd");

//        Library.printAlbums();

    }
    private JPanel rootPanel;
    private JLabel helloLabel;
    private JButton helloButton;
}
