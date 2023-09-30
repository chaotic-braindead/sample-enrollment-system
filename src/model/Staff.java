package model;

public class Staff extends Account{
    public Staff(String username, String password){
        super(username, password);
    }
    public String toString(){
        return String.format("Name: %s", this.name);
    }
}
