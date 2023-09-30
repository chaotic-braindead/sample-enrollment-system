package view;

import javax.swing.JFrame;

public class EnrollmentFrame extends JFrame {
    private static final int WIDTH = 980;
    private static final int HEIGHT = 980;
    private EnrollmentPanel panel;

    public enum Menu {
        MAIN, LOGIN, ENROLL
    }

    public EnrollmentFrame(String title, EnrollmentPanel panel){
        super(title);
        this.panel = panel;
        this.add(panel);
        this.setSize(WIDTH, HEIGHT);
    }

    public void start() throws Exception {
        this.display(EnrollmentFrame.Menu.MAIN);
    }
    
    private void display(Menu m) throws Exception {
        switch(m){
            case MAIN: panel.mainMenu();   
                       break;
            default:   throw new Exception("Menu invalid");
        }
        this.setVisible(true);
    }
    
}