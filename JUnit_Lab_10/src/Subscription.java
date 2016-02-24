/**
 *
 * @author c11452772
 */
public class Subscription {

   private int price ; // subscription total price in cents
   private int nofMonths ; // length of subscription in months

   // constructor :
   public Subscription(int price, int nofMonths) {
    if (price <= 0 || nofMonths <=0) {
      throw new IllegalArgumentException("Invalid argument(s):");
    }
     this.price = price ;
     this.nofMonths = nofMonths ;
   } 
   
  /**
   * Calculate the monthly subscription price in euro,
   * rounded up to the nearest cent.
   */
   public double getPricePerMonth() {
     if (nofMonths<=0 || price <=0) {
         return 0.0;
     }
      double r = (double) price / (double) nofMonths ;
      //Change cents to euro
      r = r/100.0;

      //Round to 2 decimal places
      r = Math.round(r * 100);
      r = r/100;
      return r;
   }

  /**
   * Call this to cancel/nullify this subscription.
   */
   public void cancel() { 
       nofMonths = 0 ; 
   }
}

