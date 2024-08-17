package StudentSorterTest;

import StudentSorter.Student;
import StudentSorter.Students;
import org.junit.jupiter.api.Test;

import static StudentSorter.Student.BY_AGE;
import static StudentSorter.Student.BY_GRADE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentsTest {

    @Test
    public void testShouldAddStudentToStudentsArray() {
        Students students = new Students();
        assertEquals(0, students.getAmountOfStudents());

        Student student1 = new Student("Timo", 22, 90);
        students.addStudent(student1);
        assertEquals(1, students.getAmountOfStudents());

        Student student2 = new Student("Timo2", 25, 99);
        students.addStudent(student2);
        assertEquals(2, students.getAmountOfStudents());

    }

    @Test
    public void testShouldDeleteStudentFromStudentsArray() {
        Students students = new Students();
        Student student1 = new Student("Timo", 22, 90);
        students.addStudent(student1);

        Student student2 = new Student("Timo2", 25, 99);
        students.addStudent(student2);

        students.deleteStudent(student1);
        assertEquals(1, students.getAmountOfStudents());

    }

    @Test
    public void testShouldSortStudentsname() {

        Students students = new Students();
        students.addStudent(new Student("Timo22", 22, 90));
        students.addStudent(new Student("Timo25", 25, 90));
        students.addStudent(new Student("Aapo2", 2, 99));

        students.sort();
        assertEquals("Aapo2", students.getStudent(0).getName());

    }

    @Test
    public void testShouldSortStudentsage() {
        Students students = new Students();
        students.addStudent(new Student("Timo22", 22, 90));
        students.addStudent(new Student("Timo25", 25, 90));
        students.addStudent(new Student("Aapo2", 2, 99));

        students.sort(BY_AGE);

        assertEquals(2, students.getStudent(0).getAge());

    }

    @Test
    public void testShouldSortStudentsByGrade() {
        Students students = new Students();
        students.addStudent(new Student("Timo22", 22, 90));
        students.addStudent(new Student("Timo25", 25, 90));
        students.addStudent(new Student("Aapo2", 2, 99));

        students.sort(BY_GRADE);

        assertEquals("Timo22", students.getStudent(0).getName());

    }

    @Test
    public void testShouldSortStudentsByAgeReverseOrder() {
        Students students = new Students();
        students.addStudent(new Student("Timo22", 22, 90));
        students.addStudent(new Student("Timo25", 25, 90));
        students.addStudent(new Student("Aapo2", 2, 99));

        students.sort(BY_AGE.reversed());
        assertEquals("Timo25", students.getStudent(0).getName());
    }

}
