package StudentSorter;

import java.util.Arrays;
import java.util.Comparator;

public class Students {

    Student [] students;
    private int  amountOfStudents = 0;

    public Students() {
        this.students = new Student[amountOfStudents];
    }

    public void printStudents() {
        for (int i = 0; i < amountOfStudents; i++) {
            System.out.println(students[i]);
        }
    }

    /**
     * adds a student to the array
     * @param student to be added
     */
    public void addStudent(Student student) {
        Student [] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }

        newStudents[amountOfStudents] = student;
        students = newStudents;
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


    /**
     * returns the amount of students in students array
     * @return  the amount of students in students array
     */
    public int getAmountOfStudents() {
        return amountOfStudents;
    }


    public void sort () {

       Arrays.sort(students);

    }


    public void sort (Comparator<Student> theComparator) {
        Arrays.sort(students, theComparator);

    }


    public int findMedian() {
        return 50;
    }


    public Student getStudent(int index) {
        return students[index];

    }

    public static void main(String[] args) {


    }
}
