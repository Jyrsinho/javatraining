package EmployeeSorterTest;

import EmployeeSorter.Employee;
import EmployeeSorter.Employees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    @Test
    public void testShouldAddEmployees() {
        Employees employees = new Employees();
        Employee timo1 = new Employee("Timo1", 22, 2300);
        employees.add(timo1);

        assertEquals(1, employees.getLength());


    }


}
