package Organization;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Junaid
 */
public class DateTest {
    public DateTest() {
    }
    
    @Test
    public void testToStringInvalidMonthAbove() {
        System.out.println("toString");
        Date date = new Date(13, 12, 2014);
        String expResult = "1/12/2014";
        String result = date.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringInvalidMonthBelow() {
        System.out.println("toString");
        Date date = new Date(0, 12, 2014);
        String expResult = "1/12/2014";
        String result = date.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringInvalidDayAbove() {
        System.out.println("toString");
        Date date = new Date(1, 32,2014);
        String expResult = "1/1/2014";
        String result = date.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringInvalidDayBelow() {
        System.out.println("toString");
        Date date = new Date(1, 0,2014);
        String expResult = "1/1/2014";
        String result = date.toString();
        assertEquals(expResult, result);
    }

}
