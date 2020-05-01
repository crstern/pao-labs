package music.management.system;

import java.io.*;

public class ReadGeneric {
    private static ReadGeneric onlyInstance;
    private String fileToRead;
    private String fileToWrite;


    private ReadGeneric(String fileToRead, String fileToWrite){
        this.fileToRead = fileToRead;
        this.fileToWrite = fileToWrite;
    }

    public static ReadGeneric getInstance(String fileToRead, String fileToWrite){
        if (onlyInstance == null){
            onlyInstance = new ReadGeneric(fileToRead, fileToWrite);
        }
        return onlyInstance;
    }

    public void loadLibrary(){
        BufferedReader bf = null;
        String line = "";
        String csvSplitBy = ",";
        try {

            bf = new BufferedReader(new FileReader(this.fileToRead));
            while ((line = bf.readLine()) != null) {


                String []lineSpliced = line.split(csvSplitBy);

                String song = lineSpliced[0];
                String genre = lineSpliced[1];
                String album = lineSpliced[2];
                String musicArtist = lineSpliced[3];
                String duration = lineSpliced[4];

                new Song(song, genre, album, musicArtist, Integer.parseInt(duration));
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

    public void writeLibrary(){
        BufferedWriter bf = null;
        String line = "";
        String csvSplitBy = ",";
        try{
            bf = new BufferedWriter(new FileWriter(this.fileToWrite));
            for(Song song : Library.getSongs()){
                bf.write(song.getName() + "," + song.getArtist().getName() + "\n");
            }
        }catch (IOException e) {
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
