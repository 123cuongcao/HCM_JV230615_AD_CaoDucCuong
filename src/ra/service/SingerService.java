package ra.service;

import ra.modal.Singer;

import java.util.Scanner;

public class SingerService {
    private Singer[] arrSinger = new Singer[100];
    private static  int indexSinger = 0;

    public SingerService() {

    }
    public void addSinger(Singer singer){
        arrSinger[indexSinger] = singer;
        indexSinger++;
    }

    public void changeSinger(int checkId, Scanner sc){
        for(int i=0; i<indexSinger;i++){
            if(checkId == arrSinger[i].getSingerId()){
                arrSinger[i].inputData(sc);
            }
        }
    }
    public Singer[] displaySinger(){
        return arrSinger;
    }


    public Singer[] getArrSinger() {
        return arrSinger;
    }

    public void setArrSinger(Singer[] arrSinger) {
        this.arrSinger = arrSinger;
    }

    public static int getIndexSinger() {
        return indexSinger;
    }

    public static void setIndexSinger(int indexSinger) {
        SingerService.indexSinger = indexSinger;
    }


}
