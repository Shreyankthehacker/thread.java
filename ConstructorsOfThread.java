

public class ConstructorsOfThread extends Thread{
  public static void main(String args[]){
    ConstructorsOfThread c1 = new ConstructorsOfThread (); // constructor of type Thread()
  // Wait notify notifyall are of object class andf not thread class rest just check for the built in methods and constructors 
  System.out.println(Thread.currentThread().getName());
  
  c1.setPriority(10);
  c1.start();
  try {
    c1.join();
  } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  
  Thread.currentThread().setName("Shreyank"); // we can change name of main thread as well

  System.out.println(Thread.currentThread().getName());  
 
  ConstructorsOfThread c2 = new ConstructorsOfThread (); 
  c2.setDaemon(true); /// shud be created before starting else ILlegalThreadState exception
  c2.start();// Hence we cant create daemon of main


  // Daemon thread are threads executed in bg and provides service and its life depends on the thread for which it provides service 
}

  @Override
  public void run(){
    try {
      Thread.sleep(10000);// thread sleeps for 1sec or 1000 mili second 

    } catch (Exception e) {
    }
    Thread.yield(); // Stops current thread and allows other threads to execute
    System.out.println("running THIS IS INSIDE THREAD");
    System.out.println(Thread.currentThread().getName()+" With the priority "+Thread.currentThread().getPriority());
    if(isDaemon()){
      System.out.println("This is also Daemon");
    }
  }
}

// Join method is used like if thread t2 wants t1 to execute first then join method shud be used
