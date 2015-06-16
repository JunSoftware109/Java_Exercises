package Organization;
/**
 * This class represents an Engineer Employee
 * @author Junaid Malik
 */
public class Engineer extends Employee {

    private String speciality;
    public Engineer(String name, Date hireDate, int id, double salary, String speciality) {
        super(name, hireDate, id, salary); // super allows us to override superclass methods
        this.speciality = speciality;// this keyword refers to current instance variable of speciality
    }
    
    // Method for calcEarningaa
    @Override// indicates that this method overrides a superclass method
    public double calcEarnings() {
       return salary;
    }
    
    // return string repersentation of Engineer object
    @Override// indicates that this method overrides a superclass method
    public String toString() {
            return super.toString() + String.format(" Speciality : %s ", speciality);
    }
} // End Engineer Clas