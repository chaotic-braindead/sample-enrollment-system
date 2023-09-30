package model;

public class Student extends Account {
    protected String course;
    protected byte year;
    protected byte block;
    protected boolean isRegular;

    public Student(String username, String password){
        super(username, password);
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
    public String toString(){
        return String.format("Name: %s\nYear: %d\nCourse/Block: %s-%d\nRegular Student: %s", this.name, this.year, this.course, this.block, (this.isRegular ? "Yes" : "No"));
    }
    
}
