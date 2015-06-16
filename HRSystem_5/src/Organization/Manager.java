package Organization;

import java.util.ArrayList;
/*
 * This class repersents a Manager who containts an arrayList for the number
 * of Enginners that he contains. The Manager also contains a varible called bonus.
 * @author C11452772
 */
public class Manager extends Employee {
   // static Manager engArray; // This static field will allow engArray.
    private ArrayList<Employee> engList = new ArrayList<>( );   //This creates a resizable-array of employee.
    public static int numberOfEngineers; // this static number of enginers will persist throughtout the life of application.
    private double bonus; // this field contains double varibale that is exclusive to the manager.

    
    public Manager(String name, Date dateOfHire, int id, double salary, double bonus) {
        super(name, dateOfHire, id, salary); // super keyword allows us to acces overridden method in base class.
        this.bonus = bonus; // We acess bonus field by using 'this' keyword.
    }
    
    public void addEngineer(Engineer eng) {
	numberOfEngineers++; // this increments nubmer of engineers.
	engList.add(eng); // we use add method to add engineer to list.
    }

    public void removeEngineer(Employee eng) {
        numberOfEngineers--; // this decrements nubmer of engineers.
        engList.remove(eng); // we use remove method to remove engineer to list.
    }
    
    public void displayAllEmployeeDetails() {
         //generally process each element in engList
        for(Employee eng : engList){ // this is ternary notation simlyfying a typical for loop.
            System.out.printf("manager has %s engineers: ", engList.size()); // prints number of enginner is engList array.
            System.out.println(eng.toString());  
        }
    }
    
    // This method sets bonus of Manager
    public void setBonus(double newbonus) {
              if ( bonus >= 0.0 ) // checks to see if bonus is valid
         bonus = newbonus; 
              else // invalid entry excelption is thrown.
         throw new IllegalArgumentException( "Base salary must be >= 0.0" );
    } //
    
    public double getBonus() { return bonus; }
    
    // Overriden method calcEarnings with its own implementation. Salary and
    // Bonus are returned.
    @Override// indicates that this method overrides a superclass method
    public double calcEarnings() { return getSalary() + getBonus();}
    
    // return string repersentation of manager object. We print bonus for Manager.
    @Override// indicates that this method overrides a superclass method
    public String toString() {    
        return super.toString() + String.format ("bonus : %s",bonus);
    }  
} // End Manager class

