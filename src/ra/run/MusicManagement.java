package ra.run;

import ra.modal.Singer;
import ra.modal.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Date;
import java.util.Scanner;

public class MusicManagement {
    public static Scanner sc = new Scanner(System.in);
//    public static  Singer[] arrsinger = new Singer[100];
    public static int inndexSinger = 0;
    public static SingerService singerService = new SingerService();
    public static SongService songService = new SongService();
    public static void main(String[] args) {
        int choice ;
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1. Quản lý ca sĩ  \n" +
                    "2. Quản lý bài hát \n"+
                    "3. Tìm kiếm bài hát \n" +
                    "4. Thoát ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("Hãy nhập lụa chọn của bạn");
            switch(choice){
                case 1:
                    singerManagement();
                    break;
                case 2:
                    songManagement();
                    break;
                case 3:
                    searchManagement();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
            }
        }while(choice != 4);
    }

    public static void singerManagement(){
        boolean isExit1 = true;
        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ [5 điểm]\n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id [10 điểm]\n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)[5 điểm]\n" +
                    "5.Thoát");
            System.out.println("Hãy chọn chựa chọn cảu bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    addSinger();
                    break;
                case 2:
                    displaySinger();
                    break;
                case 3:
                    changeSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    isExit1 = false;
            }
        }while (isExit1);
    }


    public static void songManagement(){
        boolean isExit2 = true;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) \n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ \n" +
                    "3.Thay đổi thông tin bài hát theo mã id \n" +
                    "4.Xóa bài hát theo mã id \n" +
                    "5.Thoát");
            System.out.println("hãy nhập vào lựa chọn cảu bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addSong();
                    break;
                case 2:
                    displaySong();
                    break;
                case 3:
                    changeSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    isExit2 = false;
            }
        }while(isExit2);
    }

    public static void searchManagement(){
        boolean isExit3 = true;
        do {
            System.out.println("*********************SEARCH-MANAGEMENT************************\n" +
                    "1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại . \n" +
                    "2.Tìm kiếm ca sĩ theo tên hoặc thể loại \n" +
                    "3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần \n" +
                    "4.Hiển thị 10 bài hát được đăng mới nhất \n" +
                    "5.Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    searchBySingerGenre();
                    break;
                case 2:
                    searchByNameGenre();
                    break;
                case 3:
                    sortArr();
                    break;
                case 4:
                    newSong();
                    break;
                case 5:
                    isExit3 = false;
            }
        }while(isExit3);
    }

    public static void addSinger(){
        System.out.println("Nhập số ca sĩ bạn muốn thêm");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            Singer singer = new Singer();
            singer.inputData(sc);
            singerService.addSinger(singer);
        }
    }

    public static void displaySinger(){
        for(int i = 0 ;i<singerService.getIndexSinger();i++){
            singerService.getArrSinger()[i].displayData();
        }
    }

    public static void changeSinger(){
        System.out.println("hãy nhập id sa sĩ");
        int checkId = Integer.parseInt(sc.nextLine());
        singerService.changeSinger(checkId,sc);
    }

    public static void deleteSinger(){
        System.out.println("hãy nhập id ca sĩ muốn xóa");
        int checkId = Integer.parseInt(sc.nextLine());
        int check = -1;
        for(int i = 0 ; i<songService.getIndexSong();i++){
            if(checkId == songService.getSong()[i].getSinger().getSingerId()){
                System.out.println("Ca sĩ này đang có bài hát không xóa được");
                check=1;
            }
        }
        if(check!=1){
            for(int i= checkId; i<singerService.getIndexSinger()-1;i++){
                singerService.getArrSinger()[i] = singerService.getArrSinger()[i+1];
            }
            singerService.getArrSinger()[singerService.getIndexSinger()-1]=null;
            singerService.setIndexSinger(singerService.getIndexSinger()-1);
        }
    }


    public static void addSong(){
        System.out.println("Nhập số bài hát bạn muốn thêm");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            Song song = new Song();
            if(singerService.getIndexSinger()==0){
                System.out.println("phải thêm ca sĩ trước");
                break;
            }
            song.inputData(sc,singerService.getArrSinger(),singerService.getIndexSinger());
            songService.addSong(song);
        }
    }

    public static void displaySong(){
        for(int i=0;i<songService.getIndexSong();i++){
            songService.getSong()[i].displayData();
        }
    }

    public static void changeSong(){
        System.out.println("hãy nhập id bài hát");
        String checkId = sc.nextLine();
        songService.changeSong(checkId,sc,singerService.getArrSinger(),singerService.getIndexSinger());
    }

    public static void deleteSong(){
        System.out.println("Nhập id muốn xóa");
        String wantDelete = sc.nextLine();
        int indexDelete = -1;
        for(int i = 0; i<songService.getIndexSong();i++){
            if(wantDelete.equals(songService.getSong()[i].getSongId())){
                indexDelete = i;
                songService.deleteSong(indexDelete);
                break;
            }
        }
    }

    public static void searchBySingerGenre(){
        System.out.println("Hãy nhập bài hát theo tên hoặc thể loại");
        String wantSong = sc.nextLine();
        for(int i = 0;i< songService.getIndexSong();i++){
            if(wantSong.contains(songService.getSong()[i].getSongName()) || wantSong.contains(songService.getSong()[i].getSinger().getGenre())){
                songService.getSong()[i].displayData();
            }else {
                System.out.println("không tìm thấy gì đâu!");
            }
        }
    }


    public static void searchByNameGenre(){
        System.out.println("hãy nhập tên hoăc thể loại muốn tìm ");
        String wantFind = sc.nextLine();
         for(int i= 0; i<singerService.getIndexSinger();i++){
             if(wantFind.contains(singerService.getArrSinger()[i].getSingerName())|| wantFind.contains(singerService.getArrSinger()[i].getGenre())){
                 singerService.getArrSinger()[i].displayData();
             }else {
                 System.out.println("không tìm thấy ");
             }
         }
    }

    public static void sortArr(){
        for(int i= 0; i<songService.getIndexSong()-1;i++){
            int minIndex = i;
            for(int j =i+1;j<songService.getIndexSong();j++){
                if(songService.getSong()[j].getSongName().compareTo(songService.getSong()[minIndex].getSongName())<0){
                    minIndex = j;
                }
            }
            Song temp =songService.getSong()[minIndex];
            songService.getSong()[minIndex]=songService.getSong()[i];
            songService.getSong()[i]=temp;
        }
        System.out.println("mảng đã được sắp xếp");
    }

    public static void newSong(){
        Song[] allSongs = songService.getSong();

        int count = Math.min(10, allSongs.length);
        Song[] latestSongs = new Song[count];

        for (int i = 0; i < count; i++) {
            latestSongs[i] = allSongs[i];
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (latestSongs[j].getCreatedDate().compareTo(latestSongs[j + 1].getCreatedDate()) < 0) {
                    Song temp = latestSongs[j];
                    latestSongs[j] = latestSongs[j + 1];
                    latestSongs[j + 1] = temp;
                }
            }
        }

        System.out.println("10 bài hát mới nhất:");
        for (Song song : latestSongs) {
            song.displayData();
        }
    }
}
