package Organization;
public class HRSystem 
{
   private final Screen screen; // HRSystem's screen
   private final Keypad keypad; // HRSystem's keypad
   private final CompanyDatabase companyDatabase; // account information database
   // constants corresponding to main menu options
   private static final int EMPLOYEE_INQUIRY = 1;
   private static final int COMPANY_DETAILS = 2;
   private static final int HIRE = 3;
   private static final int FIRE = 4;
   private static final int VIEWPAYROLL = 5;
   private static final int EXIT = 6;
   
   // no-argument HRSystem constructor initializes instance variables
   public HRSystem() 
   {
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      companyDatabase = new CompanyDatabase(); // create acct info database
   } // end no-argument HRSystem constructor

   // start HRSystem 
   public void run()
   {
      // welcome and authenticate user; perform transactions
      while ( true )
      {
         // loop while user is not yet authenticated
        screen.displayMessageLine( "\nWelcome!" );       
         
         performTransactions(); // user is now authenticated 
         screen.displayMessageLine( "\nThank you! Goodbye!" );
      } // end while   
   } // end method run


   // display the main menu and perform transactions
   private void performTransactions() 
   {
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
            case EMPLOYEE_INQUIRY: 
            case COMPANY_DETAILS: 
            case HIRE:
            case FIRE:
            case VIEWPAYROLL:  
                
               // initialize as new object of chosen type
               currentTransaction = createTransaction( mainMenuSelection );

               currentTransaction.execute(); // execute transaction
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
      screen.displayMessageLine( "\nMain menu:" );
      screen.displayMessageLine( "1 - Employee Inquiry" );
      screen.displayMessageLine( "2 - Company Details" );
      screen.displayMessageLine( "3 - Hire Employee" );
      screen.displayMessageLine( "4 - Hire Employee" );
      screen.displayMessageLine( "5 - View Payroll" );
      screen.displayMessageLine( "6 - Exit\n" );;
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // return user's selection
   } // end method displayMainMenu
         
   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case EMPLOYEE_INQUIRY: // create new EmployeeInquiry transaction
            temp = new EmployeeInquiry( screen,keypad, companyDatabase );
            break;
         case COMPANY_DETAILS: // create new Withdrawal transaction
            temp = new CompanyDetails( screen, keypad , 
               companyDatabase );
            break; 
         case HIRE: // create new Deposit transaction
            temp = new HireTransaction( screen, keypad, 
               companyDatabase );
            break;
         case FIRE: // create new Deposit transaction
            temp = new FireTransaction( screen, keypad, 
               companyDatabase );
            break;
          case VIEWPAYROLL: // create new Deposit transaction
            temp = new PayrollTransaction( screen, 
            companyDatabase, keypad );
            break;
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction
} // end class HRSystem