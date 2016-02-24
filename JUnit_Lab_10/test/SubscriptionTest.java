/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c11452772
 */
public class SubscriptionTest {
    
    public SubscriptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPricePerMonth method, of class Subscription.
     */
    @Test
    public void testGetPricePerMonth() {
        System.out.println("Test if pricePerMonth returns Euro...");
        Subscription subs = new Subscription(200,2);
        double expResult = 1.0;
        double result = subs.getPricePerMonth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    /**
    * Test of roundMonthlySubscription method, of class Subscription.
    */
    @Test
    public void roundMonthlySubscription() {
    System.out.println("Test if pricePerMonth rounds up to nearest cents...");
    Subscription subs = new Subscription(200,3);
    double expResult = 0.67;
    double result = subs.getPricePerMonth();
    assertEquals(expResult, result , 0.0);
    }

    /**
     * Test of cancel method, of class Subscription.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        Subscription subs = new Subscription(200,2);
        subs.cancel();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
}
