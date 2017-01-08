import java.util.Comparator;

/** A comparator for the priority queue processQueue in the CPU class to use
 * to compare processes by service time.  
 * @author Todd Fleming
 */
public class ProcessComparator implements Comparator
{
   /** Returns -1 if the process object o1's service time is less than the 
    * process 02's, 0 if they are equal, and 1 if o1's is greater.
    */
   public int compare(Object o1, Object o2)
   {
      if (((Process)o1).getServiceTime() > ((Process)o2).getServiceTime()) 
         return 1;
      else if (((Process)o1).getServiceTime() == ((Process)o2).getServiceTime()) 
         return 0;
      else return -1;
   }
}//--END-OF-CLASS---------------------------------------------------------------
