package Organization;

/**
 *
 * @author Junaid
 */
public class PayrollTransaction extends Transaction {
    
   // constant corresponding to menu option to cancel
   private static final int EMPLOYEE_EARNINGS = 1;
   private static final int SORT_SALARY = 2;
   private static final int SORT_NAME = 3;
   private static final int EXIT = 4;
    
   public PayrollTransaction(Screen hrScreen, CompanyDatabase hrCompanyDatabase, Keypad hrKeypad) 
   {
        super(hrScreen,hrKeypad, hrCompanyDatabase);
        screen = new Screen(); // create screen
        keypad = new Keypad(); // create keypad 
   }

    @Override
    public void execute() {
       performTransactions();
    }

    private void performTransactions() {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            case EMPLOYEE_EARNINGS: 
            case SORT_SALARY: 
            case SORT_NAME:
               // initialize as new object of chosen type
               currentTransaction = createTransaction( mainMenuSelection );

               break; 
            case EXIT: // user chose to terminate session
               screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // this HRSystem session should end
               
               break;
            default: // user did not enter an integer from 1-4
               screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
         } // end switch
      } // end while
   } // end method performTransactions
   
    // display the main menu and return an input selection
   private int displayMainMenu()
   {   
      screen.displayMessageLine( "\nChoose Option:" );
      screen.displayMessageLine( "1 - Employee Earnings" );
      screen.displayMessageLine( "2 - Sort by Salary" );
      screen.displayMessageLine( "3 - Sort by Name" );
      screen.displayMessageLine( "4 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // return user's selection
    }
   
    // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      CompanyDatabase companyDatabase = getCompanyDatabase();
      Transaction temp1 = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case EMPLOYEE_EARNINGS: // create new EmployeeInquiry transaction
            companyDatabase.displayAllEmployeeEarnings();
            break;
         case SORT_SALARY: // create new Withdrawal transaction
            companyDatabase.sortEmployeeSalary();
            break; 
         case SORT_NAME: // create new Withdrawal transaction
            companyDatabase.sortEmployeeName();
            break; 
      } // end switch

      return temp1; // return the newly created object
   } // end method createTransaction
   
}
