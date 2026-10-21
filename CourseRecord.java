import java.util.Enumeration;
import java.util.Vector;

public class CourseRecord {
    private Student student;
    private Vector<Assignment> assignments;

    public CourseRecord() {
        assignments = new Vector<>();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student s) {
        student = s;
    }

    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }

    public Enumeration<Assignment> getAssignments() {
        return assignments.elements();
    }
}