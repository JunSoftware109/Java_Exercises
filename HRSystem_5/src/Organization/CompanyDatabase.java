package Organization;
// CompanyDatabase.java
// Represents the bank account information database 
import java.util.ArrayList;
import java.util.Collections;
public class CompanyDatabase
{      
   private ArrayList<Employee> empList = new ArrayList<>();//This creates a resizable-array of employee.
   public static int numberOfEmployees; // this static number of enginers will persist throughtout the life of application.
   // no-argument CompanyDatabase constructor initializes accounts
   public CompanyDatabase() {
   } // end no-argument CompanyDatabase constructor
   

    // this method allows us to serch throgh empList for a certain employee
    public boolean searchForEmployee(Employee emp) {   
        return empList.contains(emp); 	  // checks to see if employee is in list.
    }
    
    // displays employee comtained in array list
    public void getAllEmployeeDetails() {
        int index = 0;
            if(empList.isEmpty()){
            System.out.println("Employee list is empty!");
            }
            else{
        for(Employee employees : empList) { // this is ternary notation simlyfying a typical for loop.
            System.out.println("\nID: " + index);
            System.out.printf("Company has %s employees: ", empList.size());
            System.out.println(employees);
            index++;                    
        }
      }
    }
       
    // This method displays all salaries of employees in the company
    public void displayAllEmployeeEarnings () {
        for(Employee emp : empList){ // this is ternary notation simlyfying a typical for loop.
            System.out.printf("\nCalcEarnings: " + emp.calcEarnings()+"\nFor: " + emp +"\n");
        }       
    }
    
    // This method sorts employee salary using
    // collections class. It contains polymorphic algorithms
    // that operate on collections. 
    public void sortEmployeeSalary(){
    Collections.sort(empList,new EmployeeSalaryCompare()); // we create an instanc of the EployeeSalaryCompare() class/
	     //generally process each element in empList
            for(Employee e: empList){ // We create a looop to go through each employee and print details.
			//print out the sorted list of Salaries.
                   	System.out.println("\nEmployee salary Order from lowest to highest Salaries"+e);
	    }
    }
    
    // This method sorts employee names using
    // collections class. It contains polymorphic algorithms
    // that operate on collections. 
    public void sortEmployeeName(){
    Collections.sort(empList,new EmployeeNameCompare());
    //generally process each element in empList
	    for(Employee em: empList){ // We create a looop to go through each employee and print details.
			//print out the sorted list of Names.
                   	System.out.println("\nEmployee name Order from A to Z"+em);
	    }
    }
    public void hire(Employee emp) {
    	numberOfEmployees++; // this operator increments numberOfEmployees by 1.
	empList.add(emp); // this method will add to the empList
    }

    // this method enables us to remove employee from array list
    public void fire(int ID) {
       numberOfEmployees--; // this operator decrements numberOfEmployees by -1.
        empList.remove(ID); // this method will remove to the empList
    }
  
} // end class CompanyDatabase
