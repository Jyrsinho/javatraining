package EmployeeSorterTest;

import EmployeeSorter.Employee;
import EmployeeSorter.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    Employees employees;
    Employee timo1;

    @BeforeEach
    void setUp() {
        employees = new Employees();
        timo1 = new Employee("Timo1", 22, 2300);
    }

    @Test
    public void testShouldAddEmployees() {
        employees.add(timo1);

        assertEquals(1, employees.getLength());

    }

    @Test
    public void testShouldRemoveEmployees() {
        employees.add(timo1);
        employees.removeEmployee(timo1);

        assertEquals(0, employees.getLength());

    }

    @Test
    public void testShouldSortEmployeesBasedOnNames() {

    }


}
