public class basicthread extends Thread{
  public static void main(String args[]){
    // Multitasking perform multiple task at a single time -> switching concept
    //Multiprocessing -> process based multitasking ( One system connected to multiple cpu to complete the task(s))
    //Multithreading -> thread based multitasking ( Multiple threads/(small task) executing at same time to finish one big task) used in game and softwares 
    // Process :- A program in executing state, Context switching is high  ,Interprocess comm is slow
    // Thread :- Subpart of a process ,very less context switching , Interthread communication is fast
    
// Creating thread  thread class and runnable interface
basicthread b = new basicthread();
b.start();
b.run(); // Not a thread just calling a function and also each thread can be invoked just once
// b.start();// cant do bcz already dead thread


  }


// Always override run function bcz interface Runnable has abstract class run
// Even thread class is implemented by runnable
@Override 
public void run(){
  System.out.println(0);
}

}
