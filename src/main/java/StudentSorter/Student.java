package StudentSorter;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
    }

    /**
     * Natural sorting order. Sorts students based on their names.
     * @param o the object to be compared.
     * @return negative if this is smaller than o, 0 if both students have equal values, 1 if
     * o is larger.
     */
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    public static final Comparator<Student> BY_AGE
            = new Comparator<>() {
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    public static final Comparator<Student> BY_GRADE
            = new Comparator<>() {
        public int compare(Student o1, Student o2) {
            return (int) (o1.getGrade() - o2.getGrade());
        }
    };
}



