package Organization;
// EmployeeInquiry.java
// Represents a balance inquiry ATM transaction
public class EmployeeInquiry extends Transaction
{
   // EmployeeInquiry constructor
   public EmployeeInquiry( Screen hrScreen, Keypad hrKeypad, 
      CompanyDatabase hrCompanyDatabase )
   {
      super( hrScreen, hrKeypad, hrCompanyDatabase );
   } // end EmployeeInquiry constructor

   // performs the transaction
   @Override
   public void execute()
   {
      // get references to company database and screen
      CompanyDatabase companyDatabase = getCompanyDatabase();
      Screen screen = getScreen();
      // get the total balance for the account involved

      // display the balance information on the screen
      screen.displayMessageLine( "\nEmployee Information:" );
      screen.displayMessage("Employee list " );
      screen.displayMessage( "\nAvailable Employee: " ); 
      companyDatabase.getAllEmployeeDetails();
      screen.displayMessage( "\nTotal Employees: " );
  
   } // end method execute
} // end class EmployeeInquiry