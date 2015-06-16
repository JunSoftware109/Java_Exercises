package Organization;
import Organization.Employee;
import java.util.*;
/*
 * This comparator compares 
 * two employees by their salaries (lower first)
 */

class EmployeeSalaryCompare implements Comparator<Employee> {

    @Override// indicates that this method overrides a superclass method
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp1.getSalary(), emp2.getSalary());
    }
} // End of class EmployeeSalaryCompare
