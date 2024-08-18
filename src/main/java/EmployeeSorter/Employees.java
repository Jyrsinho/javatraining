package EmployeeSorter;

import java.util.ArrayList;
import java.util.Comparator;

public class Employees {

    ArrayList<Employee> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public int getLength() {
        return employees.size();
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void sort() {

        employees.sort(null);

    }

    public void sort(Comparator<Employee> comparator) {

        employees.sort(comparator);

    }

    public Employee get(int index) {
        return employees.get(index);
    }


}
