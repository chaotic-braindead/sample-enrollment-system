package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnrollmentMouseAdapter extends MouseAdapter{
    
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("Clicked");
    }
}
