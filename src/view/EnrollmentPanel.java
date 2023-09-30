package view;

import view.EnrollmentFrame;
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
    private static final int BUTTON_X_POS = WIDTH / 2 - BUTTON_WIDTH;
    private static final int BUTTON_Y_POS = HEIGHT / 2 - BUTTON_HEIGHT;
    private static final int TEXT_FIELD_WIDTH = 300;
    private static final int TEXT_FIELD_HEIGHT = 30;
    private static final int TEXT_FIELD_X_POS = TEXT_FIELD_WIDTH / 2 - TEXT_FIELD_HEIGHT;
    private static final int TEXT_FIELD_Y_POS = TEXT_FIELD_HEIGHT / 2 - TEXT_FIELD_HEIGHT;


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
        JButton login = generateButton(BUTTON_X_POS, BUTTON_Y_POS, "Login",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    frame.display(EnrollmentFrame.Menu.LOGIN);
                }
            }
        );
        JButton signup = generateButton(BUTTON_X_POS, BUTTON_Y_POS+BUTTON_HEIGHT+5, "Sign Up",
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
        JTextField stdNoField = generateTextField(false, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*6);
        JPasswordField passField = (JPasswordField) generateTextField(true, WIDTH / 2 - TEXT_FIELD_WIDTH, HEIGHT / 2 - TEXT_FIELD_HEIGHT*4);

        JButton button = generateButton(BUTTON_X_POS, BUTTON_Y_POS,"Enroll",
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println(stdNoField.getText());
                    System.out.println(passField.getPassword());
                    frame.display(EnrollmentFrame.Menu.ENROLL);
                }
            }
        );
        this.add(button);
        this.add(stdNoField);
        this.add(passField);
        return "Login";
    }

    public final String enroll(){
        refresh();
        JButton button = generateButton(BUTTON_X_POS, BUTTON_Y_POS,"Enroll",
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
        return "Sign Up";
    }
}
