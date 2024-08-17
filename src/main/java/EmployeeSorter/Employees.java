package EmployeeSorter;

import java.util.ArrayList;

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
}
