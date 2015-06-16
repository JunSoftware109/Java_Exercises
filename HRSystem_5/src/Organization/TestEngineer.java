package Organization;

/**
 * This class represents TestEngineer who 'is a' engineer
 * @author c11452772
 */
public class TestEngineer extends Engineer {

    public TestEngineer(String name, Date hireDate, int id, double salary, String speciality) {
        super(name, hireDate, id, salary, speciality);//super allows us to override superclass methods of engineer
    }   
}
