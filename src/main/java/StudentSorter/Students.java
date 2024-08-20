package StudentSorter;

import java.util.Arrays;
import java.util.Comparator;

import static StudentSorter.Student.BY_GRADE;

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


    public Student[] getStudents() {
        return students;
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


    public double findMedian(Student [] studentarray) {
        sort(BY_GRADE);

        if (studentarray.length % 2 == 1) return studentarray[studentarray.length/2].getGrade();

        else return (studentarray[studentarray.length/2].getGrade() + studentarray[studentarray.length/2 - 1].getGrade()) / 2;
    }


    public double findFirstQuartile() {
        Student [] lowerHalf = new Student [amountOfStudents/2];

        System.arraycopy(students, 0, lowerHalf, 0, lowerHalf.length);

        return findMedian(lowerHalf);
    }


    public double findThirdQuartile() {

        return 87;
    }


    public Student getStudent(int index) {
        return students[index];

    }



    public static void main(String[] args) {


    }
}
