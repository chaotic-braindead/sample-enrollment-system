package view;

import model.*;
import constants.Query;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EnrollmentPanel extends JPanel {
    private static final int WIDTH = EnrollmentFrame.WIDTH;
    private static final int HEIGHT = EnrollmentFrame.HEIGHT;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_X_POS_DEFAULT = WIDTH / 2 - BUTTON_WIDTH;
    private static final int BUTTON_Y_POS_DEFAULT = HEIGHT / 2 - BUTTON_HEIGHT;
    private static final int TEXT_FIELD_WIDTH = 300;
    private static final int TEXT_FIELD_HEIGHT = 30;

    private EnrollmentFrame frame;

    public EnrollmentPanel(EnrollmentFrame frame){
        this.frame = frame;
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(EnrollmentFrame.WIDTH, EnrollmentFrame.HEIGHT);
    }

    private void refresh(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    private JButton generateButton(int x, int y, String text, MouseAdapter m){
        JButton button = new JButton(text);
        button.addMouseListener(m);
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        return button;
    }

    private JTextField generateTextField(boolean isPassword, int x, int y){
        JTextField text;
        if(!isPassword)
            text = new JTextField();
        else
            text = new JPasswordField();

        text.setBounds(x, y, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
        return text;
    }

    public final String mainMenu(){
        refresh();
        JButton login = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT, "Login",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    frame.display(EnrollmentFrame.Menu.LOGIN);
                }
            }
        );
        JButton signup = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT+BUTTON_HEIGHT+5, "Sign Up",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    frame.display(EnrollmentFrame.Menu.SIGNUP);
                }
            }
        );
        this.add(login);
        this.add(signup);
        return "Welcome!";
    }

    public final String login(){
        refresh();
        JTextField userField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*6);
        JPasswordField passField = (JPasswordField) generateTextField(true, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*4);

        JButton button = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT,"Login",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    String username = userField.getText();
                    String password = passField.getPassword().toString();
                    frame.display(EnrollmentFrame.Menu.DASHBOARD, new Account(username, password));
                }
            }
        );
        this.add(button);
        this.add(userField);
        this.add(passField);
        return "Login";
    }

    public final String enroll(){
        refresh();
        JButton button = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT,"Enroll",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    frame.display(EnrollmentFrame.Menu.MAIN);
                }
            }
        );
        this.add(button);
        return "Enroll";
    }

    public final String signUp(){
        refresh();
        JTextField userField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*6);
        JPasswordField passField = (JPasswordField) generateTextField(true, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*4);

        JButton button = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT,"Create Account",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    String username = userField.getText();
                    String password = passField.getPassword().toString();
                    Account a;
                    if(username.matches("^[0-9]{0,10}$"))
                        a = new Student(username, password);
                    else
                        a = new Staff(username, password);
                    
                    // store in database (check first for duplicates)
                    frame.display(EnrollmentFrame.Menu.SETUP, a);
                }
            }
        );
        this.add(button);
        this.add(userField);
        this.add(passField);
        return "Sign Up";
    }

    public final String setup(Account a){
        refresh();
        JTextField nameField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*10);
        JTextField courseField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*8);        JTextField yearField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*6);
        JTextField blockField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*4);

        JButton button = generateButton(BUTTON_X_POS_DEFAULT, BUTTON_Y_POS_DEFAULT,"Submit",
            new EnrollmentMouseAdapter(this) {
                @Override
                public void mouseClicked(MouseEvent e){
                    String name = nameField.getText();
                    String course = courseField.getText();
                    String year = courseField.getText();
                    String block = blockField.getText();

                    if(name.equals("")){
                        return;
                    }
                    if(a instanceof Student){
                        if(course.equals("")){
                            return;
                        }
                        if(year.equals("") || Byte.parseByte(year) > 5){
                            return;
                        }
                        if(block.equals("") || Byte.parseByte(block) > 5){
                            return;
                        }
                    }

                    String update = String.format(Query.UPDATE_STUD, name, course, year, block, true);
                    // UPDATE table_name 
                    // SET name = name, 
                    //     course = course,
                    //     year = year,
                    //     block = block,
                    //     isRegular = true WHERE username = '{a.getUsername()}' && password = '{a.getPassword()}';

                    frame.display(EnrollmentFrame.Menu.LOGIN);
                }
            }
        );
        
        this.add(nameField);
        if(a instanceof Student){
            this.add(courseField);
            this.add(yearField);
            this.add(blockField);
        }
        this.add(button);
        return "Form";
    }

    public final String dashboard(Account a){
        // validate username and password

        return "Dashboard";
    }

}
