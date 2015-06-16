package Interfaces;
import Organization.Date;
/*
 * This is an interface that decouples the implementation of employee
 *
*/
public interface Person {     
    void setName( String aName ); // calculate setName; no implementation
    String getName(); // calculate getName; no implementation
    void setHireDate(Date d); // calculate setHireDate; no implementation
    Date getHireDate(); //  getHireDate; no implementation
    abstract double calcEarnings(); // calculate calcEarnings; no implementation
    void setSalary( double s); // do setSalary; no implementation
    double getSalary(); // calculate getSalary; no implementation
    @Override
    String toString(); // toString method; no implementation
}// end interface Person
