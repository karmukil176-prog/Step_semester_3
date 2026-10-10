package oop_inheritance_and_polymorphism.assignment;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[capacity];
    }

    public boolean addSong(String s) {
        if (count == songs.length) return false;
        songs[count++] = s;
        return true;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] x) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(p.getSongs()));
    }
}
