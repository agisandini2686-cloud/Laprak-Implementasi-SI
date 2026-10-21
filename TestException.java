public class TestException {
    public static void main(String[] args) {
        Assignment assignment = new Assignment();

        try {
            System.out.println(assignment.getMark());
        } catch (NotYetSetException e) {
            System.out.println("Exception tertangkap: " + e.getMessage());
        }
    }
}