import java.util.LinkedList;
import java.util.PriorityQueue;

/** CPU contains the main run method to printout the schedule of events.
 * It adds processes to a priority queue (heap) and sorts them based on their
 * remaining time.
 * @author Todd Fleming
 */
public class CPU
{
 /** A comparator object to compare processes by service time.*/
 private ProcessComparator comp;
 
 /** A priority queue to the sort the processes by service time and hold the 
  * shortest remaining time process on top.
  */
 private PriorityQueue<Process> processQueue; 

 /** the list of all created process passed from the main method. */
 private Process[] processList;

 /** Constructor, all member variables initialized here. */
 public CPU(Process[] processList)
{
  this.processList = processList;
  //create a new ProcessComparator oject
  this.comp = new ProcessComparator();
  //processQueue is based on the ProcessComparator comp
  this.processQueue = new PriorityQueue<Process>(60, comp);
}

/** The Run method cycles through a for loop of time units.  For every time unit
 * it examines the process list to see if there is a process whose arrival time
 * says it should arrive or be created then. If so, it prints out that the 
 * process was created then.  It then adds that process to the 
 * processQueue (a priority queue, based on service time remaining).
 *  It then pulls the next process from the queue, prints that its running, 
 * decrements its service time one and adds it back to the queue. 
 *  If nothing is running, it prints out that the processor is idle.
 */
public void run()
{
   //Print out headers
   System.out.println("Time  --  Event");
  
   //Main time loop til 60 units.
   for (int time=0; time <=60; time++)
   {
      //processor starts idle
      boolean isIdle = true;
      
      //if there is a process in the processList array that starts at the
      //current time, say it is created now and add it to the processQueue.
      if (processList[time] != null)
      {
         Process p = processList[time];
         processQueue.add(p);
         System.out.println(""+time+"  --  Process "+p.getName()+" created -"+
         "- Service Time: "+ p.getServiceTime());
      }
      
      //Create a process object to hold the top process in the priority queue
      //(the one with the least service time)and retrieve and remove it from the 
      //queue.
      Process shortestProcess = processQueue.poll();
      
      //if there is a process in the queue, set the flag to processor running,
      //print that the current process is running, decrement its service time
      //for the one unit it ran.
      if (shortestProcess != null)
      {
        isIdle = false;
        System.out.println(""+time+"  --  Process "
                           +shortestProcess.getName()+" is Running.");
        //if the process's service time has run out, do not add it to the queue
        //again, if it is still 1 or more, add it back to be sorted into the 
        //priority queue.
        if (shortestProcess.decrementServiceTime() > 0) 
           processQueue.add(shortestProcess);
      }
     
      //if the flag is still set to idle (ie: there is no process currently in the 
      //process queue, print out that the processor is idle right now.
      if (isIdle) System.out.println(""+time+"  --  Processor is Idle");
     
   }
   
}


}
