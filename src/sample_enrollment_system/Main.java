package sample_enrollment_system;

import view.EnrollmentFrame;
import view.EnrollmentPanel;

public class Main {
    public static void main(String[] args) {
        EnrollmentFrame frame = new EnrollmentFrame("hello", new EnrollmentPanel()); 
        try {
            frame.start();
        } catch(Exception e) {
            System.out.print(e);
        }
    }
}
