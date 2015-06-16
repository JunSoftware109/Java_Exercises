package Organization;

/**
 * This class representation a Design Engineer
 * @author c11452772
 */
public class DesignEngineer extends Engineer{

    public DesignEngineer(String name, Date hireDate,int id, double salary, String speciality) {
        super(name, hireDate, id, salary, speciality);// super allows us to override superclass methods of engineer
    }   
} // End of class DesignEngineer
