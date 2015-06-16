package Organization;
import java.util.InputMismatchException;
/**
 *
 * @author c11452772
 */
public class HireTransaction extends Transaction { 
   private Screen screen; // HRSystem's screen
   private Keypad keypad; // HRSystem's keypad
   
   // constant corresponding to menu option to cancel
   private static final int MANAGER = 1;
   private static final int ADMINISTRATOR = 2;
   private static final int ENGINEER = 3;
   private static final int EXIT = 4;
  
   public HireTransaction(Screen hrScreen,Keypad hrKeypad, CompanyDatabase hrCompanyDatabase) 
   {
        super(hrScreen, hrKeypad, hrCompanyDatabase);
        keypad = new Keypad();
        screen = new Screen();
   }
   
   // display the main menu and perform transactions
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction;
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
            case MANAGER: 
            case ADMINISTRATOR: 
            case ENGINEER:     

               // initialize as new object of chosen type
               currentTransaction =   createTransaction( mainMenuSelection );
               //currentTransaction.execute(); // execute transaction
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
      try{
      screen.displayMessageLine( "\nChoose an Employee:" );
      screen.displayMessageLine( "1 - Manager" );
      screen.displayMessageLine( "2 - Administrator" );
      screen.displayMessageLine( "3 - Engineer" );
      screen.displayMessageLine( "4 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput();
       }
       catch(InputMismatchException e)
       {
           System.err.printf("\nException:%s\n",e);
           keypad.getNextLine(); // get next input from the user
       }
       return 0;
   } // end method displayMainMenu
   
   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case MANAGER: // create new EmployeeInquiry transaction
            createManager();
            break;
         case ADMINISTRATOR: // create new Withdrawal transaction
            createAdministrator();
            break; 
         case ENGINEER: // create new Withdrawal transaction
            createEngineer();
            break; 
             
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction
   
   public void createEngineer()
   {
      CompanyDatabase companyDatabase = getCompanyDatabase();
      Date hireeng = new Date (9, 3, 1994);
      try{
      screen.displayMessage("New Engineer" );         
      screen.displayMessageLine("Enter the Engineers name:");
      String name = keypad.getString();
      
      screen.displayMessageLine("Enter Engineers ID:");
      int id = keypad.getInput();
      
      System.out.println("Enter Engineers Salary:");   
      double salary = keypad.getDouble();
      
      System.out.println("Enter Engineers speciality");
      String speciality = keypad.getString();
      
      Engineer eng1 = new Engineer(name, hireeng , id, salary ,speciality);
      eng1.setHireDate(hireeng);
      companyDatabase.hire(eng1);
      screen.displayMessage("Employee has been added\n" + eng1);
      screen.displayMessage( "\nEmployee Information:" );
      screen.displayMessage( " - Available Employee: " ); 
      companyDatabase.getAllEmployeeDetails();
      screen.displayMessage( "\nTotal Employees: " );
      companyDatabase.toString();
      performTransactions();
      
      }catch(Exception e1)
      {
          System.err.printf("Excelption:\n",e1);
          screen.displayMessage("Please Enter correct ID:");
          keypad.getNextLine();  
      }
      
   }
   public void createManager()
   {
      CompanyDatabase companyDatabase = getCompanyDatabase();
      //Instantiating the Manager
      Date hiremanager1 = new Date (5, 8, 1989); 
      screen.displayMessage("New Manager" ); 
      screen.displayMessageLine("Enter the Managers name:");
      String name = keypad.getString();

      screen.displayMessageLine("Enter Managers ID:");
      int id = keypad.getInput();

      screen.displayMessageLine("Enter Salary for the Manager:");
      double salary = keypad.getInput();

      screen.displayMessage("Enter Bonus for the Manager:");
      double bonus = keypad.getDouble();

      Manager m1 = new Manager(name, hiremanager1, id, salary, bonus );
      m1.setHireDate(hiremanager1);
      companyDatabase.hire(m1);
      screen.displayMessage("Employee has been added\n" + m1);  
      screen.displayMessage( "\nEmployee Information:" );
      screen.displayMessage( " - Available Employee: " ); 
      companyDatabase.getAllEmployeeDetails();
      screen.displayMessage( "\nTotal Employees: " );
      companyDatabase.toString();
      performTransactions();
  }
   
   public void createAdministrator()
   {
     CompanyDatabase companyDatabase = getCompanyDatabase();
     screen.displayMessage("New Administrator" );      
     Date hireadmin1 = new Date (7, 3, 1988);
     // Instantiating the Administrator
     screen.displayMessageLine("Enter the Administrator name:");
     String name1 = keypad.getString();
    
     screen.displayMessageLine("Enter Administrator ID:");
     int id1 = keypad.getInput();
    
     screen.displayMessageLine("Enter Administrator Salary:");   
     int salary1 = keypad.getInput();
    
     Administrator admin1 = new Administrator(name1, hireadmin1, id1, salary1, 5, 30, 100);
     admin1.setHireDate(hireadmin1);
     companyDatabase.hire(admin1);
     screen.displayMessage("Employee has been added\n" + admin1);      
     screen.displayMessage( "\nEmployee Information:" );
     screen.displayMessage( " - Available Employee: " );      
     companyDatabase.getAllEmployeeDetails();
     screen.displayMessage( "\nTotal Employees: " );
     companyDatabase.toString();
     screen.displayMessage(""+admin1 );
     performTransactions();
    }
    
    @Override
    public void execute() {
      performTransactions();
     /* Date hireeng1 = new Date (9, 3, 1994);
      Date hiretesteng1 = new Date (5, 8, 1997); 
      Date hiretesteng2 = new Date (1, 5, 1992); 
      Date hiredesigneng1 = new Date(5, 4, 1995);*/
    }
}