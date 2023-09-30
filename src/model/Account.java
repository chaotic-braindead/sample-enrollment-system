package model;

public class Account {
    protected String name;
    protected String username;
    protected String password;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(name.indexOf(",") != -1){
            String[] nameArr = name.split(",");
            nameArr[1] = nameArr[1].stripLeading();

            String temp = nameArr[0];
            nameArr[0] = nameArr[1];
            nameArr[1] = temp;

            name = String.join(" ", nameArr);
        }
        this.name = name;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String name){
        this.name = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.name = password;
    }
}
