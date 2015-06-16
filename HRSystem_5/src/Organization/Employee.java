package Organization;
import Interfaces.Person;
/*
 * This abstract class provides partial implementation
 * so the base classes build upon the methods such as
 * calcSalary and toString method. It also implements Person interface
*/
public abstract class Employee implements Person {
    private String name;
    private static int id;
    private Date hireDate;
    public double salary;

    //default constructor
    public Employee() { }

    public Employee(String name, Date hireDate,int id, double salary) { //user-defined constructor
       this.name = name;// this keyword refers to current instance variable 
       this.id = id;// this keyword refers to current instance variable 
       this.hireDate = hireDate; // this keyword refers to current instance variable 
       this.salary = salary;// this keyword refers to current instance variable 
    }   
    
   // method to setName 
    @Override// indicates that this method overrides a superclass method
    public void setName( String aName ){
      name = aName; // 
    } // end method setName
   
    // method to getName 
    @Override// indicates that this method overrides a superclass method
    public String getName()  {
      return name;
    } // end method getName
    
    // method to setId
    public void setId ( int aId ){
      id = aId; // 
    } // end method setId
   
    // method to getid
    public int getId()  {
      return id;
    } // end method getId
    
    // method to setHireDate
    @Override// indicates that this method overrides a superclass method
    public void setHireDate(Date d) {};
    
    // method to getHireDate
    @Override// indicates that this method overrides a superclass method
    public Date getHireDate() {return hireDate; };

    // abstract method is empty as other classes can override this 
    @Override// indicates that this method overrides a superclass method
    public abstract double calcEarnings();
    
    // method to setSalary
    @Override// indicates that this method overrides a superclass method
    public void setSalary( double s) {
      if ( s >= 0.0 )
         salary = s;
      else
        throw new IllegalArgumentException( 
        "Salary must be >= 0.0" );
    };
    
    // method to getSalary
    @Override// indicates that this method overrides a superclass method
    public double getSalary() {return salary; }; 
    
    // toString method is used to get a String object
    // repersenting the value of the number object.
    @Override// indicates that this method overrides a superclass method
    public String toString() {
    return String.format( "\nName: %s Hired: %s Employee ID : %d Salary: %s    ", name, hireDate, id, salary );         
    }
}// end abtsract class Employee
