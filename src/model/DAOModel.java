package model;

import java.sql.SQLException;
import java.util.List;

public interface DAOModel {
    public void add(Account a) throws SQLException;
    public void remove(Account a) throws SQLException;
    public void get(Account a) throws SQLException;
    public List<Student> getStudents() throws SQLException;
    public List<Staff> getStaffs() throws SQLException;
}