package view;

import javax.swing.JPanel;


import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnrollmentPanel extends JPanel {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public EnrollmentPanel(){
        super();
        this.setVisible(true);
    }

    private void refresh(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    public void mainMenu(){
        refresh();
        JButton button = new JButton("Click me");
        button.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    notFound();
            }
        });
        button.setSize(WIDTH, HEIGHT);
        this.add(button);
    }

    public void notFound(){
        refresh();
        JButton button = new JButton("notFound");
        button.setSize(WIDTH, HEIGHT);
        this.add(button);
    }
}
