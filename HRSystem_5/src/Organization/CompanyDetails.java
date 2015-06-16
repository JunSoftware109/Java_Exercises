package Organization;
/**
 *
 * @author c11452772
 */
class CompanyDetails extends Transaction {
    private Keypad keypad; // HRSystem's keypad
   // String companyName;
    public CompanyDetails(Screen hrScreen, Keypad hrKeypad, CompanyDatabase hrCompanyDatabase) 
    {
        super(hrScreen, hrKeypad, hrCompanyDatabase);
        keypad = new Keypad();
        screen = new Screen();
    }
    
    
    @Override
    public void execute() {
    screen.displayMessage("\nEnter the Company name:");
    String companyName = keypad.getString();
    screen.displayMessage("\nCompany Name is now set to " + companyName);
    
    screen.displayMessage( "\nNew Company Object:" ); 
    CompanyDatabase company1 = new CompanyDatabase();
    screen.displayMessage(""+ company1 ); 
    screen.displayMessage("\nCompany Name is:" + companyName);
    }
 
 
    
    public void setCompanyDetails()
    {
    screen.displayMessage( "\nNew Company Object:" ); 
    
    //CompanyDetails company1 = new CompanyDetails();
    //System.out.println( company1 ); 
    }    
}