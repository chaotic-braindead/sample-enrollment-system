package sample_enrollment_system;

import view.EnrollmentFrame;
import view.EnrollmentPanel;

public class Main {
    public static void main(String[] args) {
        EnrollmentFrame frame = new EnrollmentFrame();
        EnrollmentPanel panel = new EnrollmentPanel(frame);
        frame.setPanel(panel);  // wonky AF
        frame.display(EnrollmentFrame.Menu.MAIN);
        
    }
}
