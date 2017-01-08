import java.util.Random;

/** A class for Processes. Each has a process serviceTime, arrivalTime and name.
 * @author Todd Fleming
 */
public class Process 
{

private int serviceTime;
private int arrivalTime;
private int name;

/** Constructor, create random number generator and set the service time
 * to a random number between 1 and 10 and the arrival time to 1 to 3 units 
 * after the last process was created.
 * @param lastTime the time the last process was created in the Main loop.
 * @param name the int number of the process = 1 plus the name of the last 
 * process.
 */
public Process (int lastTime, int name)
{
   Random rand = new Random();
   this.name = name;
   this.serviceTime = rand.nextInt(9) + 1;
   this.arrivalTime = lastTime + rand.nextInt(3) + 1;
}

/** Getters for member variables. */
public int getArrivalTime()
{
   return arrivalTime;
}

public int getServiceTime()
{
   return serviceTime;
}

public int getName()
{
   return name;
}

/** Method to decrement the remaining service time by one.
 * @return returns the service time after decrementing it for the CPU Run logic
 * to see if the service time is run up (now 0).
 */
public int decrementServiceTime()
{
   return --serviceTime;
}

}//--END-of-CLASS---------------------------------------------------------------