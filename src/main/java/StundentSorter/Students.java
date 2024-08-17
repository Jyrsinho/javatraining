package StundentSorter;

public class Students {

    Student [] students;
    private final int MAX_ARRAY_SIZE = 10;
    private int  amountOfStudents = 0;

    public Students() {
        this.students = new Student[MAX_ARRAY_SIZE];
    }

    public void printStudents() {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            System.out.println(students[i]);
        }
    }

    /**
     * adds a student to the array
     * @param student to be added
     */
    public void addStudent(Student student) {
        students[amountOfStudents] = student;
        amountOfStudents++;

    }

    /**
     * deletes a student from array
     * @param student to be deleted
     */
    public void deleteStudent(Student student) {
        for (int i = 0; i < amountOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                amountOfStudents--;
            }
        }
    }

    public void sort() {

    }

    public static void main(String[] args) {


        Students students = new Students();
        students.printStudents();
    }
}
