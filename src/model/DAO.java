package model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DAO implements DAOModel{
    

    public void add(Account a) throws SQLException{
        if(a instanceof Student){
            a = (Student) a;
        }
        else{
            a = (Staff) a;
        }
    }
    public void remove(Account a) throws SQLException{
        if(a instanceof Student){
            a = (Student) a;

        }
        else{   
            a = (Staff) a;
            
        }
    }
    public void get(Account a) throws SQLException{
        if(a instanceof Student){
            a = (Student) a;
        }
        else{
            a = (Staff) a;
        }
    }
    public List<Student> getStudents() throws SQLException{
        List<Student> students = new ArrayList<>();
        return students;
    }
    public List<Staff> getStaffs() throws SQLException{
        List<Staff> staffs = new ArrayList<>();
        return staffs;
    }
}
