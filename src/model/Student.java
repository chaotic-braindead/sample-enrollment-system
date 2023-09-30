package model;

public class Student {
    private String name;
    private String course;
    private byte year;
    private byte block;
    private boolean isRegular;

    public Student(String name, String course, byte year, byte block){
        this.name = name;
        this.course = course;
        this.year = year;
        this.block = block;
        this.isRegular = true;
    }

    public String getName(){
        return this.name;
    }
    public String getCourse(){
        return this.course;
    }
    public byte getYear(){
        return this.year;
    }
    public byte getBlock(){
        return this.block;
    }
    public boolean getisRegular(){
        return this.isRegular;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public void setYear(byte year){
        this.year = year;
    }
    public void setBlock(byte block){
        this.block = block;
    }
    public void setisRegular(boolean isRegular){
        this.isRegular = isRegular;
    }
    
}
