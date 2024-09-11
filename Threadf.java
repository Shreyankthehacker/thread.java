public class Threadf implements Runnable{
  public static  int ctr = 0;
  public static void main (String args[])throws InterruptedException {
      Thread first = new Thread(new Threadf());
      Thread second = new Thread(new Threadf());
      first.start();
      second.start();
      first.join();
      second.join();
      System.out.println("The sum is "+ctr);
  
  }

 @Override
  public void   run(){
    for(int i = 0;i<10000;i++){
      increment(); // three steps load increment and store back
    }
  }
  public static  synchronized void increment(){
    ctr++;
  }

   
public void f2(){
  Thread Daemon = new Thread(new DeamonThread());
      Thread User = new Thread(new UserThread());
      User.setPriority(10);
      User.start();
      Daemon.setDaemon(true);
      Daemon.start();
      // first goes to user there asked to wait 2 second in that time it goes to daemon and waits 1 second there then print there in 2nd sec then comes to daemon in 3rd second and thats all daemon ends when all user threads are ended 
      
}

public void f1() throws InterruptedException{
      Thread first = new Thread(new Threadone());
      Thread second = new Thread(new Threadtwo());
      first.start();
      second.start();
      
          first.join(); // Only this then main waits till this finishes and as soon as this finishes then main completes its execution 
          // i.e main prints Done executing the .... string as soon as this exec is finished if only used join on one thread  
        second.join();
      System.out.println("Done executing the threads");

    }

}


class Threadone implements Runnable {
  @Override
  public void run(){
    for(int i = 1;i<10;i++){
    System.out.println("Thread 1 "+ i);
  }}
}
class Threadtwo implements Runnable{
  @Override
  public void run(){
    for(int i = 1;i<10;i++){
    System.out.println("Thread 2 "+ i);
  }}
}
class DeamonThread implements Runnable{
  @Override
  public void run(){
    int ctr = 0;
   
    while(ctr++<1000){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println("Daemon thread is in execution");    
      
    }
  }
}
class UserThread implements Runnable{
  @Override
  public void run(){
    
    int ctr = 0;
    while(ctr++<1){
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("User thread is in execution");
    }
  }
}