package ra.modal;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;
    private static int count = 0;

    public Singer() {
        this.singerId = count ;
        count ++;
    }
    public void inputData(Scanner sc){
        boolean singerNameCheck = false;
        while(!singerNameCheck){
            System.out.println("Hãy nhập tên ca sĩ");
            String singerNameTest = sc.nextLine();
            if(singerNameTest.length()>=0){
                this.singerName = singerNameTest;
                singerNameCheck = true;
            }else {
                System.out.println("Tên ca sĩ phải lớn hơn 0");
            }
        }

        boolean ageCheck = false;
        while(!ageCheck){
            System.out.println("Hãy nhập tuổi của ca sĩ");
            int ageTest = Integer.parseInt(sc.nextLine());
            if(ageTest>0){
                this.age = ageTest;
                ageCheck = true;
            }else {
                System.out.println("Tưởi phải lớn hơn không ");
            }
        }

        boolean nationalityCheck =false;
        while(!nationalityCheck){
            System.out.println("Hãy nhập quốc tịch của ca sĩ");
            String nationalityTest = sc.nextLine();
            if(nationalityTest.length()>0){
                this.nationality = nationalityTest;
                nationalityCheck = true;
            }else {
                System.out.println("Phải lớn hơn không");
            }
        }

        System.out.println("Hãy nhập giới tính của ca sĩ");
        this.gender = Boolean.parseBoolean(sc.nextLine());

        boolean genreCheck = false ;
        while(!genreCheck){
            System.out.println("Hãy nhập thể loại ");
            String genreTest = sc.nextLine();
            if(genreTest.length()>0){
                this.genre = genreTest;
                genreCheck = true;
            }else {
                System.out.println("Không được để trống");
            }
        }
    }


    public void displayData(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", genre='" + genre + '\'' +
                '}';
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

