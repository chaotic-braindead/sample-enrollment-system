package constants;

public final class Query{
    public static final String LOGIN = "SELECT * FROM %s WHERE username = '%s' AND password = '%s'";
    public static final String ADD_STUD = "INSERT INTO Student(name, course, year, block, isRegular) VALUES('%s', '%s', %d, %d, true)";
    public static final String ADD_STAFF = "INSERT INTO Staff(name) VALUES('%s')";
    public static final String DELETE = "DELETE FROM %s WHERE username = '%s'";
    public static final String GET_ALL = "SELECT * FROM '%s'";
    public static final String GET = "SELECT * FROM %s WHERE name = '%s' AND ";
    public static final String UPDATE_STUD = "UPDATE student_table SET name = '%s', course = '%s', year = %d, block = %d, isRegular = %b WHERE username = '%s' AND password = '%s'";
    public static final String UPDATE_STAFF = "UPDATE staff_table SET name = '%s' WHERE username = '%s' AND password = '%s'";
}