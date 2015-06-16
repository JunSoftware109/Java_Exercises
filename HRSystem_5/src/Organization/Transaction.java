package Organization;
// Transaction.java
// Abstract superclass Transaction represents an ATM transaction
public abstract class Transaction
{
   Screen screen; // ATM's screen
   Keypad keypad;
   private CompanyDatabase companyDatabase; // account info database

   // transaction constructor invoked by subclasses using super()
   public Transaction( Screen hrScreen, Keypad hrKeypad, 
      CompanyDatabase hrCompanyDatabase )
   {

      screen = hrScreen;
      keypad = hrKeypad;
      companyDatabase = hrCompanyDatabase;
   } // end Transaction constructor

   // return reference to screen
   public Screen getScreen()
   {
      return screen;
   } // end method getScreen
   
   public Keypad getKeypad()
   {
       return keypad;
   }

   // return reference to bank database
   public CompanyDatabase getCompanyDatabase()
   {
      return companyDatabase;
   } // end method getBankDatabase

   // perform the transaction (overridden by each subclass)
   abstract public void execute();
} // end class Transaction