package student_enrollment_record;

import view.EnrollmentFrame;
import view.EnrollmentPanel;

public class Main {
    public static void main(String[] args) {
        EnrollmentFrame frame = new EnrollmentFrame("hello", new EnrollmentPanel()); 
        frame.display();
        
    }
}
