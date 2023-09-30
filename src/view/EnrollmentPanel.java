package view;

import javax.swing.JPanel;
import javax.swing.JButton;

public class EnrollmentPanel extends JPanel {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public EnrollmentPanel(){
        super();
    }
    
    public void mainMenu(){
        JButton button = new JButton("Click me");
        button.addMouseListener(new EnrollmentMouseAdapter());
        button.setSize(WIDTH, HEIGHT);
        this.add(button);
        this.setVisible(true);
    }
}
