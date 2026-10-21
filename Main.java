public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("Pemrograman Berorientasi Objek");

        // Mahasiswa pertama
        Student student1 = new Student();
        student1.setName("Andi");

        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);

        Assignment a1 = new Assignment();
        a1.setMark(80);

        Assignment a2 = new Assignment();
        a2.setMark(90);

        record1.addAssignment(a1);
        record1.addAssignment(a2);
        course.addCourseRecord(record1);

        // Mahasiswa kedua
        Student student2 = new Student();
        student2.setName("Budi");

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);

        Assignment a3 = new Assignment();
        a3.setMark(70);

        Assignment a4 = new Assignment();
        a4.setMark(75);

        record2.addAssignment(a3);
        record2.addAssignment(a4);
        course.addCourseRecord(record2);

        // Pengujian method Course
        course.printCourseStudents();
        System.out.println();

        course.printBestStudent();
        System.out.println();

        course.printFinalExamStudents();
    }
}