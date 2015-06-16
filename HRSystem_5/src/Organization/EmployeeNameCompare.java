package Organization;

import Organization.Employee;
import java.util.Comparator;
/*
 * This comparator compares 
 * two employees by their Name (A to Z)
 */

class EmployeeNameCompare implements Comparator<Employee>{

    @Override // indicates that this method overrides a superclass method
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }  
} // End of class EmployeeNameCompare
