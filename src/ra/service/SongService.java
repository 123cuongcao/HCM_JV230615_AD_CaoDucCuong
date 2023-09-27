package ra.service;

import ra.modal.Singer;
import ra.modal.Song;

import java.util.Scanner;

public class SongService {
    private Song[] arrSong = new Song[100];
    private int indexSong = 0;

    public SongService() {
    }

    public void addSong(Song song) {
        arrSong[indexSong] = song;
        indexSong++;
    }

    public void changeSong(String checkId, Scanner sc, Singer[] arrSinger, int indexSinger) {
        for (int i = 0; i < indexSong; i++) {
            if (checkId.equals(arrSong[i].getSongId())) {
                arrSong[i].inputData(sc, arrSinger, indexSinger);
            } else {
                System.out.println("Không tìm thấy id bài hát");
            }
        }
    }

    public void deleteSong(int index) {
        for (int i = index; i < indexSong-1; i++) {
            arrSong[i]=arrSong[i+1];
        }
        arrSong[index-1]=null;
        indexSong--;
    }

    public Song[] getSong() {
        return arrSong;
    }

    public void setArrSong(Song[] arrSong) {
        this.arrSong = arrSong;
    }

    public int getIndexSong() {
        return indexSong;
    }

    public void setIndexSong(int indexSong) {
        this.indexSong = indexSong;
    }
}
