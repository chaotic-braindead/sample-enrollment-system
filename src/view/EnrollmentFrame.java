package view;

import javax.swing.JFrame;
import model.Account;

public class EnrollmentFrame extends JFrame {
    public static final int WIDTH = 980;
    public static final int HEIGHT = 980;
    private EnrollmentPanel panel;

    public enum Menu {
        MAIN, LOGIN, SIGNUP, SETUP, ENROLL, DASHBOARD
    }

    public EnrollmentFrame(){
        this.setLayout(null);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setPanel(EnrollmentPanel panel){
        this.panel = panel;
        this.add(panel);
    }

    public void display(Menu m) {
        switch(m){
            case MAIN:      this.setTitle(panel.mainMenu());   
                            break;
            case LOGIN:     this.setTitle(panel.login());
                            break;
            case SIGNUP:    this.setTitle(panel.signUp());
                            break;
            case ENROLL:    this.setTitle(panel.enroll());
                            break;
        }
        this.setVisible(true);
    }

    public void display(Menu m, Account a) {
        switch(m){
            case SETUP:     this.setTitle(panel.setup(a));
                            break;
            case DASHBOARD: this.setTitle(panel.dashboard(a));

        }
        this.setVisible(true);
    }
}