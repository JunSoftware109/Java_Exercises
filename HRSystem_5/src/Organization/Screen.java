package Organization;
// Screen.java
// Represents the screen of the ATM
public class Screen
{
   // displays a message without a carriage return
   public void displayMessage( String message ) 
   {
      System.out.print( message ); 
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
      System.out.println( message );   
   } // end method displayMessageLine
 


   public void displayEmployeeAmount( Employee emp )
   {
      System.out.printf( "%d", emp );   
   } // end method   
} // end class Screen