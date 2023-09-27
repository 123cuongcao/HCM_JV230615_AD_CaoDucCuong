package ra.modal;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        createdDate = new Date();
    }

    public void inputData(Scanner sc, Singer[] arrSinger, int indexSinger) {
        boolean songIdCheck = false;
        while (!songIdCheck) {
            System.out.println("Hãy nhập mã bài hát");
            String songIdTest = sc.nextLine();
            String regex = "^S(?!.*(.).*\\1).{3}$";
            if (Pattern.matches(regex, songIdTest)) {
                this.songId = songIdTest;
                songIdCheck = true;
            } else {
                System.out.println("Sai định dang (kiểm tra lai)");
            }
        }

        boolean songNameCheck = false;
        while (!songNameCheck) {
            System.out.println("Hãy nhập tên vài hát");
            String songNameTest = sc.nextLine();
            if (songNameTest.length() > 0) {
                this.songName = songNameTest;
                songNameCheck = true;
            } else {
                System.out.println("Không được để trống tên bài hát");
            }
        }

        System.out.println("Hãy nhập mô tả bài hát");
        this.descriptions = sc.nextLine();

        System.out.println("Danh sách ca sĩ");
        for (int i = 0; i < indexSinger; i++) {
            arrSinger[i].displayData();
        }
        System.out.println("Hãy chọn 1 ca sĩ");
        int wantSinger = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<indexSinger;i++){
            if(wantSinger == arrSinger[i].getSingerId()){
                this.singer = arrSinger[i];
            }
        }

        boolean songWriterCheck = false;
        while(!songWriterCheck){
            System.out.println("Hãy chọn người sáng tác");
            String songWriterTest = sc.nextLine();
            if(songWriterTest.length()>0){
                this.songWriter = songWriterTest;
                songWriterCheck = true;
            }else {
                System.out.println("Không được bỏ trống");
            }
        }

        System.out.println("Hãy nhập vào trạng thái ");
        this.songStatus = Boolean.getBoolean(sc.nextLine());

    }

    public void displayData(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", singer=" + singer.getSingerName() +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}';
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
}
