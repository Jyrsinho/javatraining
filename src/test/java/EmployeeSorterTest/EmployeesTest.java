package EmployeeSorterTest;

import EmployeeSorter.Employee;
import EmployeeSorter.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    Employees employees;
    Employee aimo1;
    Employee timo1;
    Employee zimo1;

    @BeforeEach
    void setUp() {
        employees = new Employees();
        aimo1 = new Employee("Aimo1", 2, 1400);
        timo1 = new Employee("Timo1", 22, 2300);
        zimo1 = new Employee("Zimo1", 99, 6500);
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
        employees.add(timo1);
        employees.add(zimo1);
        employees.add(aimo1);

        employees.sort();

        assertEquals("Aimo1", employees.get(0).getName());
    }


}
