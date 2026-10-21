import java.util.Enumeration;
import java.util.Vector;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    public Course() {
        courseRecords = new Vector<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    // Mencetak seluruh mahasiswa yang mengambil mata kuliah
    public void printCourseStudents() {
        Enumeration<CourseRecord> records = getCourseRecords();

        System.out.println("Daftar Mahasiswa Mata Kuliah: " + title);

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student != null) {
                System.out.println("- " + student.getName());
            }
        }
    }

    // Mencetak mahasiswa dengan nilai rata-rata terbaik
    public void printBestStudent() {
        Enumeration<CourseRecord> records = getCourseRecords();

        Student bestStudent = null;
        double bestAverage = -1;

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student == null) {
                continue;
            }

            Enumeration<Assignment> assignments =
                    record.getAssignments();

            double total = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();

                try {
                    total += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Nilai yang belum diisi tidak dihitung
                }
            }

            if (count > 0) {
                double average = total / count;

                if (bestStudent == null || average > bestAverage) {
                    bestAverage = average;
                    bestStudent = student;
                }
            }
        }

        if (bestStudent != null) {
            System.out.println(
                    "Mahasiswa dengan Rata-rata Terbaik: "
                    + bestStudent.getName()
                    + " (" + bestAverage + ")");
        } else {
            System.out.println("Belum ada nilai yang dapat dihitung.");
        }
    }

    // Mencetak mahasiswa yang memenuhi syarat ujian akhir
    public void printFinalExamStudents() {
        Enumeration<CourseRecord> records = getCourseRecords();

        System.out.println("Mahasiswa yang Layak Mengikuti Ujian Akhir:");

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student == null) {
                continue;
            }

            Enumeration<Assignment> assignments =
                    record.getAssignments();

            double total = 0;
            int count = 0;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();

                try {
                    total += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    // Nilai yang belum diisi tidak dihitung
                }
            }

            if (count > 0) {
                double average = total / count;

                // Asumsi sementara: nilai rata-rata minimal 60
                if (average >= 60) {
                    System.out.println("- " + student.getName()
                            + " (" + average + ")");
                }
            }
        }
    }
}