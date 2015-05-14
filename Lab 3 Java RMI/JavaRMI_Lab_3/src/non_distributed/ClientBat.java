package non_distributed;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junaid
 */
import java.util.*;

public class ClientBat {
public static void main(String args[])
{
	//Create a LocalServerBall object
	LocalServerBall ball = new LocalServerBall();
	//Prompt the user for input
	System.out.println("How many times do you want to hit the server ball?");
	Scanner input = new Scanner(System.in);
	int nofHits = input.nextInt();
	//Call the hit method for the ball object
	System.out.println(ball.hit(nofHits));
}
}
