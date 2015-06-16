package Organization;
/**
 * This class representation an Administrator
 * @author C11452772
 */

public class Administrator extends Employee{
    private int numberOfWorkers; // this variable conatains workers under the administrator
    private double overTimeRate; // this variable is only for the admin
    public double hourlyWage; // this variable is only for the admin

    public Administrator( String name, Date dateOfHire, int id, double salary,int theNumberOfWorkers, double theOverTimeRate, double theHourlyWage){
        super(name, dateOfHire,id ,salary); // super allows us to override superclass methods and pass to employee constrcutor
        this.numberOfWorkers = theNumberOfWorkers;// this keyword refers to current instance variable 
        this.overTimeRate = theOverTimeRate;// this keyword refers to current instance variable 
        this.hourlyWage = theHourlyWage;// this keyword refers to current instance variable     
    }    
    //method to setNumberOfWorkers
    public void setNumberOfWorkers( int theNumberOfWorkers ){
        numberOfWorkers = theNumberOfWorkers;
    } // end method setNumberOfWorkers

    //method to getNumberOfWorkers
    public int getNumberOfWorkers() { return numberOfWorkers; }   
   
    //method to setOverTimeRate
    public void setOverTimeRate( double theoverTimeRate ) {
      overTimeRate = theoverTimeRate;
    } // end method setFirstName

    //method to getOverTimeRate
    public double getOverTimeRate() { return overTimeRate;}
    
    //method to setHourlyWage
    public void setHourlyWage( double theHourlyWage) {
        hourlyWage = theHourlyWage;
    }
    //method to getHourlyWage
    public double getHourlyWage() { return hourlyWage; }
    
    // our overrriden method add salary, hourly wage and multiplies with
    // overtime for the administrator
    @Override// indicates that this method overrides a superclass method
    public double calcEarnings() {
        return getSalary() + getHourlyWage() * getOverTimeRate();
    }
    
    // return string repersentation of Administrators methods
    @Override// indicates that this method overrides a superclass method
    public String toString(){    
        return super.toString() + String.format(" numberOfWorkers : %s overTimeRate : %s HourlyWage: %s ",numberOfWorkers,overTimeRate,hourlyWage);
    }
} // End class Administrator
