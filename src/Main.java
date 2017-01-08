/** This program creates a simulation of the Shortest Remaining Time scheduling
 * policy, printing the schedule of events out to the system. Main creates a 
 * list of Process objects and a CPU ojbects, which it passes the Process List.
 * @author Todd Fleming
 */

public class Main{

/**
 * @param args there are no expected args for the main method
 */
   public static void main(String[] args)
   {
      //Create Process List so it can hold up to 64 processes
      Process[] processList = new Process[64];

      //Create processes and add them to the process list
      //LastTime is passed to each process as a starting point for when the 
      //created process can be arrive at the CPU (1-3 time units later)
      //So last time is the arrival time of the last process that was created,
      //it starts at -1 so that the first process can be created at time 0 by
      //chance.
      int lastTime = -1;
      int processName = 0;
      while (lastTime <= 60)
      {
       Process p = new Process(lastTime, processName); 
       lastTime = p.getArrivalTime();
       processName++;
       processList[p.getArrivalTime()] = p ;
      }
   
      //Create a new CPU object to handle the logic of running processes, 
      //pass the process list to it, and then run the CPU logic.
      CPU cpu = new CPU(processList); 
      cpu.run(); 
   }
}
