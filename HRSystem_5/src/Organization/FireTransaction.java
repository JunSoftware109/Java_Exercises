package Organization;
import java.util.InputMismatchException;
/**
 *
 * @author c11452772
 */
public class FireTransaction extends Transaction {
    private Keypad keypad; // reference to keypad
    public FireTransaction(Screen hrScreen, Keypad hrKeypad,CompanyDatabase hrCompanyDatabase) 
    {
        super(hrScreen, hrKeypad, hrCompanyDatabase);
    }
    
    @Override
    public void execute() 
    {
     CompanyDatabase companyDatabase = getCompanyDatabase();
     Screen screen = getScreen();
     Keypad keypad = getKeypad();

    try
     {
     screen.displayMessage("List of employees: ");
     companyDatabase.getAllEmployeeDetails();     
     screen.displayMessageLine("Type the ID:");
     int ID = keypad.getInput();
     companyDatabase.fire(ID);   
     screen.displayMessage("\nEmployee is now fired ");
     companyDatabase.getAllEmployeeDetails();
    }
         catch(InputMismatchException e)
         {
            System.err.printf("\n Exception: %s\n", e); //print exeception type
            screen.displayMessage("You must enter integer. Please try again");
            keypad.getNextLine(); // get next input from the user
         }
         
         catch (IndexOutOfBoundsException e2)
          {
             System.err.printf("\n Exception: %s\n", e2);
             screen.displayMessage("ID does not exist please try again.");
          }
     }
}

