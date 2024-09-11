

public class WaitAndNotifyclass implements Runnable {

 static final Object lock = new Object();

  public static void main(String args[]){
    Thread one = new Thread(() -> {
      try {
          one();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        throw new  RuntimeException(e);
      }
    });
    Thread two = new Thread(() -> {
      try {
        two();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        throw new  RuntimeException(e);
      }
    });
  one.start();
  two.start();

     
  }

  public static void one()throws InterruptedException{
   synchronized (lock) {
       
    System.out.println("Thread one beginning will lock all and once i release will notify");
    lock.wait();
    System.out.println("Back to thread 1 ");
  }}
  
  public static void two()throws InterruptedException{
  synchronized(lock){
      System.out.println("In thread 2 noww");
    lock.notify();
    System.out.println("I will exit from thread 2 now");
    // System.exit(1); uncomment this to demo how even after notifying the print statement executes telling the control is still in this block
  }}

/* What actually happens :-  
 * 
 * so first the control goes to say one then the msg is printed then the lock asks the current thread to wait and then sees the threads which are waiting
 * among those waiting threads it asks one to execute then it runs that tho it comes with notify it first executes all the statement after notify 
 */






  @Override
  public void run(){

  }
}